import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution_1228 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			LinkedList<Integer> list = new LinkedList<Integer>();
			int N = Integer.parseInt(br.readLine());

			for (String num : br.readLine().split(" ")) {
				list.add(Integer.parseInt(num));
			}

			int commandNum = Integer.parseInt(br.readLine());

			String[] line = br.readLine().split(" ");
			int cnt = 0;
			for (int i = 0; i < commandNum; i++) {
				cnt++;
				int index = Integer.parseInt(line[cnt++]);
				int insertNum = Integer.parseInt(line[cnt++]);
				for (int j = 0; j < insertNum; j++) {
					list.add(index++, Integer.parseInt(line[cnt++]));
				}
			}

			System.out.print("#" + test_case + " ");

			cnt = 0;
			for (int num : list) {
				cnt++;
				System.out.print(num + " ");
				if (cnt == 10)
					break;
			}
			System.out.println();
		}

	}

}
