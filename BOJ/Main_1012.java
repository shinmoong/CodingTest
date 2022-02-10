import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1012 {
	static int[][] ground;
	static int M, N, K, cnt;
	static int[][] deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String[] line = br.readLine().split(" ");
			M = Integer.parseInt(line[0]); // 가로
			N = Integer.parseInt(line[1]); // 세로
			K = Integer.parseInt(line[2]); // 배추 갯수
			ground = new int[N][M];
			cnt = 0;

			for (int i = 0; i < K; i++) {
				line = br.readLine().split(" ");
				int X = Integer.parseInt(line[0]); // 가로
				int Y = Integer.parseInt(line[1]); // 세로
				ground[Y][X] = 1;
			}
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (ground[r][c] == 1) {
						dfs(r, c);
						cnt++;
					}
				}
			}

			System.out.println(cnt);
		}
	}

	public static void dfs(int r, int c) {
		ground[r][c] = 0;

		for (int i = 0; i < deltas.length; i++) {
			int nr = r + deltas[i][0];
			int nc = c + deltas[i][1];

			if (nr >= 0 && nr < N && nc >= 0 && nc < M && ground[nr][nc] == 1) {
				dfs(nr, nc);
			}
		}
	}

}
