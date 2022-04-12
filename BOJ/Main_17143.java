import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17143 {
	static int R, C;
	static Shark[][] map;
	static int[][] deltas = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new Shark[R][C];
		int r, c, s, d, z;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			switch (d) {
			case 1:
				d = 2;
				break;
			case 2:
				d = 0;
				break;
			case 3:
				d = 1;
				break;
			case 4:
				d = 3;
				break;
			}
			map[r - 1][c - 1] = new Shark(r - 1, c - 1, s, d, z);
		}

		int ans = 0;
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				if (map[j][i] != null) {
					ans += map[j][i].z;
					map[j][i] = null;
					break;
				}
			}
			move();
		}

		System.out.println(ans);
	}

	private static void move() {
		Queue<Shark> queue = new LinkedList<Shark>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != null) {
					queue.offer(map[i][j]);
					map[i][j] = null;
				}
			}
		}

		Shark current;
		int r, c, s, d;
		while (!queue.isEmpty()) {
			current = queue.poll();
			r = current.r;
			c = current.c;
			s = current.s;
			d = current.d;

			if (d % 2 == 0)
				s %= (2 * (R - 1));
			else
				s %= (2 * (C - 1));

			for (int i = 0; i < s; i++) {
				r += deltas[d][0];
				c += deltas[d][1];
				if (r < 0 || r >= R || c < 0 || c >= C) {
					d = (d + 2) % 4;
					r += (2 * deltas[d][0]);
					c += (2 * deltas[d][1]);
				}
			}

			if (map[r][c] == null || (map[r][c] != null && current.z > map[r][c].z)) {
				current.r = r;
				current.c = c;
				current.d = d;
				map[r][c] = current;
			}
		}
	}

	static class Shark {
		int r, c, s, d, z;

		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
}
