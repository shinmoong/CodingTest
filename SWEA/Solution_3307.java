import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3307 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st = null;
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			int[] nums = new int[N];
			int[] dp = new int[N];
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			dp[0] = 1;
			for (int i = 1; i < N; i++) {
				dp[i] = 1;

				for (int j = 0; j < i; j++) {
					if (nums[j] < nums[i] && dp[i] < dp[j] + 1)
						dp[i] = dp[j] + 1;
				}
			}

			int max = 0;
			for (int i = 0; i < N; i++) {
				if (dp[i] > max)
					max = dp[i];
			}

			System.out.println("#" + t + " " + max);
		}
	}

}
