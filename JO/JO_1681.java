import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JO_1681 {
	static int N, min;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		String[] line;
		for (int i = 0; i < N; i++) {
			line = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}

		visited = new boolean[N];
		min = Integer.MAX_VALUE;

		dfs(0, 0, 0);

		if (min == Integer.MAX_VALUE)
			System.out.println(0);
		else
			System.out.println(min);
	}

	public static void dfs(int cnt, int sum, int current) {
		if (sum >= min)
			return;

		if (cnt == N - 1 && map[current][0] > 0 && min > sum + map[current][0]) {
			min = sum + map[current][0];
			return;
		}

		visited[current] = true;

		for (int i = 0; i < N; i++) {
			if (!visited[i] && map[current][i] > 0) {
				dfs(cnt + 1, sum + map[current][i], i);
			}
		}
		
		visited[current] = false;
	}
}
