import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10026 {
	static char[][] colors;
	static boolean[][] firstVisited, secondVisited;
	static int[][] deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		colors = new char[N][];

		for (int i = 0; i < N; i++) {
			colors[i] = br.readLine().toCharArray();
		}

		firstVisited = new boolean[N][N];
		secondVisited = new boolean[N][N];
		int firstAns = 0;
		int secondAns = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!firstVisited[i][j]) {
					firstAns++;
					firstDFS(i, j);
				}
				if (!secondVisited[i][j]) {
					secondAns++;
					secondDFS(i, j);
				}
			}
		}

		System.out.println(firstAns + " " + secondAns);
	}

	public static void firstDFS(int r, int c) {
		firstVisited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + deltas[i][0];
			int nc = c + deltas[i][1];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && !firstVisited[nr][nc] && colors[r][c] == colors[nr][nc]) {
				firstDFS(nr, nc);
			}
		}
	}

	public static void secondDFS(int r, int c) {
		secondVisited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + deltas[i][0];
			int nc = c + deltas[i][1];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && !secondVisited[nr][nc]) {
				if (colors[r][c] == 'B' && colors[nr][nc] != 'B') {
					continue;
				} else if (colors[r][c] != 'B' && colors[nr][nc] == 'B') {
					continue;
				}
				secondDFS(nr, nc);
			}
		}
	}
}
