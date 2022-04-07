import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953 {
	static int[][] deltas = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } }; // 상좌하우
	static final int UP = 0, LEFT = 1, DOWN = 2, RIGHT = 3;
	static int N, M, R, C, L;
	static int[][] map;
	static boolean[][] pipe = new boolean[8][4];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i < 8; i++) {
			if (i == 1 || i == 2 || i == 4 || i == 7)
				pipe[i][0] = true;
			if (i == 1 || i == 3 || i == 6 || i == 7)
				pipe[i][1] = true;
			if (i == 1 || i == 2 || i == 5 || i == 6)
				pipe[i][2] = true;
			if (i == 1 || i == 3 || i == 4 || i == 5)
				pipe[i][3] = true;
		}

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			System.out.println("#" + t + " " + bfs());
		}
	}

	private static int bfs() {
		Queue<Node> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		int cnt = 0;
		Node current;
		int curR, curC, curT, curPipe, nr, nc;

		queue.offer(new Node(R, C, 1));
		visited[R][C] = true;

		while (!queue.isEmpty()) {
			current = queue.poll();
			curR = current.r;
			curC = current.c;
			curT = current.t;
			curPipe = map[curR][curC];

			if (curT > L)
				break;

			cnt++;

			for (int d = 0; d < 4; d++) {
				if (!pipe[curPipe][d])
					continue;

				nr = curR + deltas[d][0];
				nc = curC + deltas[d][1];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == 0 || !pipe[map[nr][nc]][(d + 2) % 4])
					continue;

				queue.offer(new Node(nr, nc, curT + 1));
				visited[nr][nc] = true;
			}
		}

		return cnt;
	}

	static class Node {
		int r, c, t;

		public Node(int r, int c, int t) {
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}
}
