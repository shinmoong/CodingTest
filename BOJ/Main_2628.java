import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main_2628 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().split(" ");
		int W = Integer.parseInt(line[0]);
		int H = Integer.parseInt(line[1]);

		int M = Integer.parseInt(br.readLine());

		List<Integer> Hsplit = new LinkedList<>();
		List<Integer> Wsplit = new LinkedList<>();
		Hsplit.add(0);
		Hsplit.add(H);
		Wsplit.add(0);
		Wsplit.add(W);	//split 할때 초기위치 0과 끝 위치를 넣어줘야지 그 사이끼리 거리가 계산됨.
		
		for (int i = 0; i < M; i++) {
			line = br.readLine().split(" ");

			if (Integer.parseInt(line[0]) == 0) {
				Hsplit.add(Integer.parseInt(line[1]));
			} else {
				Wsplit.add(Integer.parseInt(line[1]));
			}
		}
		Collections.sort(Hsplit);
		Collections.sort(Wsplit);
		int maxH = 0, maxW = 0, tmp;
		for (int i = 1; i < Hsplit.size(); i++) {
			tmp = Hsplit.get(i) - Hsplit.get(i - 1);
			if (tmp > maxH)
				maxH = tmp;
		}
		for (int i = 1; i < Wsplit.size(); i++) {
			tmp = Wsplit.get(i) - Wsplit.get(i - 1);
			if (tmp > maxW)
				maxW = tmp;
		}

		System.out.println(maxH * maxW);
	}

}
