import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_2635 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		List<Integer> ansList = new ArrayList<>();

		int cnt, tmp, max = 0;
		for (int i = 1; i <= N; i++) {
			list.clear();
			cnt = 1;
			list.add(N);
			list.add(i);

			while (true) {
				tmp = list.get(cnt - 1) - list.get(cnt);
				if (tmp < 0)
					break;

				list.add(tmp);
				cnt++;
			}

			if (cnt > max) {
				max = cnt;
				ansList.clear();
				ansList.addAll(list);
			}
		}

		System.out.println(ansList.size());
		for (int i = 0; i < ansList.size(); i++) {
			System.out.print(ansList.get(i) + " ");
		}
	}

}
