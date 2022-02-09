import java.util.Scanner;

public class Solution_5215 {
	public static int N, L, max;
	public static int[] tastes, calories;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			/////////////////////////////////////////////////////////////////////////////////////////////
			N = sc.nextInt();
			L = sc.nextInt();
			max = 0;
			tastes = new int[N];
			calories = new int[N];

			for (int i = 0; i < N; i++) {
				tastes[i] = sc.nextInt();
				calories[i] = sc.nextInt();
			}

			hamburgerCombination(0, 0, 0);

			System.out.println("#" + test_case + " " + max);
			/////////////////////////////////////////////////////////////////////////////////////////////

		}
	}

	public static void hamburgerCombination(int taste, int calorie, int start) {
		for (int i = start; i < N; i++) {
			if (calorie + calories[i] <= L) {
				if (taste + tastes[i] > max)
					max = taste + tastes[i];
				hamburgerCombination(taste + tastes[i], calorie + calories[i], i + 1);

				if (i == N - 1) {
					return;
				}
			}
		}
	}
}
