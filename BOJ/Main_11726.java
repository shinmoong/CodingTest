import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11726 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[3];

		dp[0] = 1;
		dp[1] = 2;

		if (n == 1) {
			System.out.println(1);
		} else if (n == 2) {
			System.out.println(2);
		} else {
			for (int i = 3; i <= n; i++) {
				dp[2] = dp[0] + dp[1];
				dp[2] %= 10007;
				dp[0] = dp[1];
				dp[1] = dp[2];
			}
			System.out.println(dp[2] % 10007);
		}
	}

}
