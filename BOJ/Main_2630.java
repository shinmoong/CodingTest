import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2630 {
	static boolean[][] paper;
	static int[] ans = new int[2];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		paper = new boolean[N][N];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				if (st.nextToken().charAt(0) == '1')
					paper[i][j] = true;
			}
		}

		int x = getPapers(N, 0, 0);
		if (x != 2)
			ans[x]++;

		System.out.println(ans[0]);
		System.out.println(ans[1]);
	}

	static int getPapers(int n, int r, int c) {
		if (n == 1)
			return paper[r][c] ? 1 : 0;

		int first = getPapers(n / 2, r, c);
		int second = getPapers(n / 2, r, c + n / 2);
		int third = getPapers(n / 2, r + n / 2, c);
		int fourth = getPapers(n / 2, r + n / 2, c + n / 2);

		if (first == 2 || second == 2 || third == 2 || fourth == 2) {
			if (first != 2)
				ans[first]++;
			if (second != 2)
				ans[second]++;
			if (third != 2)
				ans[third]++;
			if (fourth != 2)
				ans[fourth]++;
			return 2;
		} else {
			if (first == second && second == third && third == fourth)
				return first;
			else {
				ans[first]++;
				ans[second]++;
				ans[third]++;
				ans[fourth]++;
				return 2;
			}
		}
	}
}
