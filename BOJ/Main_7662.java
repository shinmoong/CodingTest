import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_7662 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		Map<Integer, Integer> map;
		StringTokenizer st = null;
		int tmp = 0, tmp2 = 0;
		for (int t = 1; t <= T; t++) {
			int k = Integer.parseInt(br.readLine());

			PriorityQueue<Integer> minPQ = new PriorityQueue<>();
			PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
			map = new HashMap<>();
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				if (st.nextToken().charAt(0) == 'I') {
					tmp = Integer.parseInt(st.nextToken());
					minPQ.add(tmp);
					maxPQ.add(tmp);
					if (map.get(tmp) == null) {
						map.put(tmp, 1);
					} else {
						map.put(tmp, map.get(tmp) + 1);
					}
				} else { // D
					tmp = Integer.parseInt(st.nextToken());
					if (map.isEmpty()) {
						continue;
					}

					if (tmp == 1) { // 최댓값 삭제
						while (true) {
							tmp2 = maxPQ.poll();
							if (map.get(tmp2) == null) {
								continue;
							}
							if (map.get(tmp2) == 1) {
								map.remove(tmp2);
							} else {
								map.put(tmp2, map.get(tmp2) - 1);
							}
							break;
						}
					} else { // 최솟값 삭제
						while (true) {
							tmp2 = minPQ.poll();
							if (map.get(tmp2) == null) {
								continue;
							}
							if (map.get(tmp2) == 1) {
								map.remove(tmp2);
							} else {
								map.put(tmp2, map.get(tmp2) - 1);
							}
							break;
						}
					}
				}
			}

			if (map.isEmpty()) {
				System.out.println("EMPTY");
			} else {
				while (true) {
					tmp2 = maxPQ.poll();
					if (map.get(tmp2) == null) {
						continue;
					}
					System.out.print(tmp2 + " ");
					break;
				}
				while (true) {
					tmp2 = minPQ.poll();
					if (map.get(tmp2) == null) {
						continue;
					}
					System.out.println(tmp2);
					break;
				}
			}
		}
	}

}
