import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4485 {
	static int N;
	static int[][] deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int cnt = 1;

		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;

			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			System.out.println("Problem " + cnt++ + ": " + dijkstra(map, N));
		}
	}

	private static int dijkstra(int[][] map, int N) {
		int[][] distance = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		PriorityQueue<Vertex> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				distance[i][j] = Integer.MAX_VALUE;
			}
		}

		pq.offer(new Vertex(0, 0, map[0][0]));
		distance[0][0] = map[0][0];

		Vertex current;
		int nr, nc;
		while (!pq.isEmpty()) {
			current = pq.poll();

			if (visited[current.r][current.c])
				continue;

			visited[current.r][current.c] = true;

			for (int i = 0; i < 4; i++) {
				nr = current.r + deltas[i][0];
				nc = current.c + deltas[i][1];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]
						&& distance[nr][nc] > distance[current.r][current.c] + map[nr][nc]) {
					distance[nr][nc] = distance[current.r][current.c] + map[nr][nc];
					pq.offer(new Vertex(nr, nc, distance[nr][nc]));
				}
			}
		}

		return distance[N - 1][N - 1];
	}

	static class Vertex implements Comparable<Vertex> {
		int r, c, minDistance;

		public Vertex(int r, int c, int minDistance) {
			this.r = r;
			this.c = c;
			this.minDistance = minDistance;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.minDistance - o.minDistance;
		}
	}
}
