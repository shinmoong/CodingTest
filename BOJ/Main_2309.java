import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2309 {
	public static int[] ans = new int[7];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 9;
		int[] heights = new int[N];
		int[] isUsed = new int[7];

		for (int i = 0; i < N; i++) {
			heights[i] = Integer.parseInt(br.readLine());
		}
		combination(0, 0, heights, isUsed, N, 0);
		
		Arrays.sort(ans);
		
		for(int i=0; i<7; i++) {
			System.out.println(ans[i]);
		}
	}

	public static void combination(int cnt, int start, int[] heights, int[] isUsed, int N, int sum) {
		if (cnt == 7) {
			if (sum == 100) {
				ans = isUsed.clone();
			}
			return;
		}

		for (int i = start; i < N; i++) {
			isUsed[cnt] = heights[i];
			combination(cnt + 1, i + 1, heights, isUsed, N, sum + heights[i]);
		}
	}
}
