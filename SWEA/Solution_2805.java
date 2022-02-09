import java.util.Scanner;

public class Solution_2805 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			///////////
			int N = sc.nextInt(); // 농장 크기
			int[][] farm = new int[N][N];
			int sum = 0;

			for (int i = 0; i < N; i++) {
				String line = sc.next();
				for (int j = 0; j < N; j++) {
					farm[i][j] = line.charAt(j) - '0';
				}
			}

			for (int i = 0; i <= N / 2; i++) {
				for (int j = i; j < N - i; j++) {
					if (i == 0) {
						sum += farm[N / 2][j];
					} else {
						sum += (farm[N / 2 + i][j] + farm[N / 2 - i][j]);
					}
				}
			}

			System.out.println("#" + test_case + " " + sum);
			///////////
		}
	}

}
