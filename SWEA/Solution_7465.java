import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_7465 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		String[] line;
		int ans, N, M;
		int[] parents;
		for (int test_case = 1; test_case <= T; test_case++) {
			line = br.readLine().split(" ");
			N = Integer.parseInt(line[0]);
			M = Integer.parseInt(line[1]);
			ans = N;
			parents = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				parents[i] = i;
			}

			for (int i = 0; i < M; i++) {
				line = br.readLine().split(" ");
				if (union(parents, Integer.parseInt(line[0]), Integer.parseInt(line[1])))
					ans--;
			}

			System.out.println("#" + test_case + " " + ans);
		}
	}

	public static boolean union(int[] parents, int a, int b) {
		int rootA = find(parents, a);
		int rootB = find(parents, b);

		if (rootA == rootB)
			return false;

		if (rootA > rootB)
			parents[rootA] = rootB;
		else
			parents[rootB] = rootA;

		return true;
	}

	public static int find(int[] parents, int a) {
		if (parents[a] == a)
			return a;

		return parents[a] = find(parents, parents[a]);
	}
}
