import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2961 {
	static int N, min = Integer.MAX_VALUE;
	static int[][] ingredients;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		ingredients = new int[N][2];
		String[] line;
		for (int i = 0; i < N; i++) {
			line = br.readLine().split(" ");

			ingredients[i][0] = Integer.parseInt(line[0]);
			ingredients[i][1] = Integer.parseInt(line[1]);
		}

		subset(0, 1, 0);
		System.out.println(min);
	}

	// 신맛 쓴맛 따로 sum 파라미터 받아서 bitterness가 0이면 공집합이므로 무시.
	public static void subset(int cnt, int sourness, int bitterness) {
		if (cnt == N) {
			if (bitterness != 0)
				min = Math.min(min, Math.abs(sourness - bitterness));
			return;
		}

		subset(cnt + 1, sourness * ingredients[cnt][0], bitterness + ingredients[cnt][1]);
		subset(cnt + 1, sourness, bitterness);
	}
}
