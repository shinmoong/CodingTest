import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_3234 {
	static int[] weights, factorials = new int[10];
	static int N, answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		factorials[0] = 1;
		for (int i = 1; i <= 9; i++) {
			factorials[i] = factorials[i - 1] * i;
		}

		int T = Integer.parseInt(br.readLine());
		String[] line;
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());

			weights = new int[N];
			answer = 0;

			line = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				weights[i] = Integer.parseInt(line[i]);
			}
			Arrays.sort(weights);

			do {
				subset(0, 0, 0, 0);
			} while (nextPermutation());

			System.out.println("#" + test_case + " " + answer);
		}
	}

	public static void subset(int cnt, int sumR, int sumL, int chooseR) {
		if (sumR > sumL)
			return;

		if (cnt == N) {
			answer++;
			return;
		}

		subset(cnt + 1, sumR + weights[cnt], sumL, chooseR + 1);
		subset(cnt + 1, sumR, sumL + weights[cnt], chooseR);
	}

	public static boolean nextPermutation() {
		int i = N - 1;
		while (i > 0 && weights[i - 1] >= weights[i]) {
			i--;
		}

		if (i == 0)
			return false;

		int j = N - 1;
		while (weights[i - 1] >= weights[j]) {
			j--;
		}

		swap(i - 1, j);

		int k = N - 1;
		while (i < k) {
			swap(i++, k--);
		}
		return true;
	}

	public static void swap(int a, int b) {
		int tmp = weights[a];
		weights[a] = weights[b];
		weights[b] = tmp;
	}
}
