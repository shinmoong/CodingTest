import java.util.Scanner;

public class Solution_2001 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			/////////////////////////////////////////////////////////////////////////////////////////////
			int N = sc.nextInt();
			int M = sc.nextInt();
			int max = 0;
			int[][] flies = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					flies[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j <= N - M; j++) {
					int sum = 0;
					for (int r = i; r < i + M; r++) {
						for (int c = j; c < j + M; c++) {
							sum += flies[r][c];
						}
					}
					if (sum > max) {
						max = sum;
					}
				}
			}

			System.out.println("#" + test_case + " " + max);
			/////////////////////////////////////////////////////////////////////////////////////////////

		}
	}

}
