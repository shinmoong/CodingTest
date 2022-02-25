import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576 {
	static int M, N;
	static int[][] map;
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		// 1 익은토마토 0 안 익은 토마토 -1 빈칸
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1)
					q.offer(new int[] { i, j, 0 });
			}
		}
		System.out.println(bfs());
	}

	static int bfs() {
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, -1, 0, 1 };
		int[] tmp = null;
		while (!q.isEmpty()) {
			tmp = q.poll();
			int x = tmp[0];
			int y = tmp[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
					map[nx][ny] = 1;
					q.offer(new int[] { nx, ny, tmp[2] + 1 });
				}
			}

		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==0)
					return -1;
			}
		}
		return tmp[2];
	}
}
