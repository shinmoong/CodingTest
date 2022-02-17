import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1247 {
	static int N, min;
	static int[] office = new int[2], home = new int[2];
	static int[][] customers;
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			office[0] = Integer.parseInt(st.nextToken());
			office[1] = Integer.parseInt(st.nextToken());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());

			customers = new int[N][2];
			for (int i = 0; i < N; i++) {
				customers[i][0] = Integer.parseInt(st.nextToken());
				customers[i][1] = Integer.parseInt(st.nextToken());
			}

			min = Integer.MAX_VALUE;
			isSelected = new boolean[N];

			permutation(0, 0, 0);
			System.out.println("#" + test_case + " " + min);
		}
	}

	public static void permutation(int cnt, int sum, int prevC) {
		if (cnt == N) {
			min = Math.min(min,
					sum + (Math.abs(customers[prevC][0] - home[0]) + Math.abs(customers[prevC][1] - home[1])));
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				if (cnt == 0)
					permutation(cnt + 1,
							sum + (Math.abs(office[0] - customers[i][0]) + Math.abs(office[1] - customers[i][1])), i);
				else
					permutation(cnt + 1, sum + (Math.abs(customers[prevC][0] - customers[i][0])
							+ Math.abs(customers[prevC][1] - customers[i][1])), i);
				
				isSelected[i] = false;
			}
		}
	}
}
