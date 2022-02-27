import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		System.out.println(bfs(map, N, M));
	}

	static int bfs(char[][] map, int N, int M) {
		int[][] delta = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
		boolean[][] visited = new boolean[N][M];
		Queue<Vertex> queue = new LinkedList<Vertex>();

		queue.offer(new Vertex(0, 0, 1));
		visited[0][0] = true;

		Vertex current;
		int nr, nc;
		while (!queue.isEmpty()) {
			current = queue.poll();

			if (current.r == N - 1 && current.c == M - 1)
				return current.depth;
			for (int i = 0; i < 4; i++) {
				nr = current.r + delta[i][0];
				nc = current.c + delta[i][1];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && map[nr][nc] == '1') {
					visited[nr][nc] = true;
					queue.offer(new Vertex(nr, nc, current.depth + 1));
				}
			}
		}

		return -1;
	}

	static class Vertex {
		int r, c, depth;

		public Vertex(int r, int c, int depth) {
			this.r = r;
			this.c = c;
			this.depth = depth;
		}
	}
}
