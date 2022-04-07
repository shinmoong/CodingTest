import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_1249_dijkstra {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] deltas = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		int T = Integer.parseInt(br.readLine());
		int N;
		char[] line;
		int[][] distance;
		boolean[][] visited;
		PriorityQueue<Node> pq;
		Node current;
		int curR, curC, curMinDist, nr, nc, cnt;

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				line = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = line[j] - '0';
				}
			}

			distance = new int[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					distance[i][j] = Integer.MAX_VALUE;
				}
			}

			pq = new PriorityQueue<>();
			pq.offer(new Node(0, 0, 0));
			distance[0][0] = 0;
			cnt = 0;
			while (!pq.isEmpty()) {
				current = pq.poll();
				curR = current.r;
				curC = current.c;
				curMinDist = current.minDist;

				if (visited[curR][curC])
					continue;

				visited[curR][curC] = true;

				cnt++;
				if (cnt == N * N)
					break;

				for (int d = 0; d < 4; d++) {
					nr = curR + deltas[d][0];
					nc = curC + deltas[d][1];

					if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]
							&& distance[nr][nc] > distance[curR][curC] + map[nr][nc]) {
						distance[nr][nc] = distance[curR][curC] + map[nr][nc];
						pq.offer(new Node(nr, nc, distance[nr][nc]));
					}
				}
			}

			System.out.println("#" + t + " " + distance[N - 1][N - 1]);
		}
	}

	static class Node implements Comparable<Node> {
		int r, c, minDist;

		public Node(int r, int c, int minDist) {
			this.r = r;
			this.c = c;
			this.minDist = minDist;
		}

		@Override
		public int compareTo(Node o) {
			return this.minDist - o.minDist;
		}
	}
}
