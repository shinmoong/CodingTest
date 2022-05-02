import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_7569 {
	static int M, N, H;
	static boolean[][][] map;
	static int[][] deltas = { { 1, 0, 0 }, { -1, 0, 0 }, { 0, 1, 0 }, { 0, -1, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };
	static int remain = 0; // 남은 토마토 갯수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().split(" ");
		M = Integer.parseInt(line[0]); // 가로
		N = Integer.parseInt(line[1]); // 세로
		H = Integer.parseInt(line[2]); // 높이

		map = new boolean[H][N][M]; // 높이, 세로, 가로
		int tmp;
		Queue<Node> queue = new LinkedList<>();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				line = br.readLine().split(" ");
				for (int k = 0; k < M; k++) {
					tmp = Integer.parseInt(line[k]);
					if (tmp == 0) {
						remain++;
					} else if (tmp == -1) {
						map[i][j][k] = true;
					} else { // tmp == 1
						map[i][j][k] = true;
						queue.offer(new Node(i, j, k, 0));
					}
				}
			}
		}

		int nh, nr, nc;
		Node current = null;
		while (!queue.isEmpty()) {
			current = queue.poll();
			for (int d = 0; d < 6; d++) {
				nh = current.h + deltas[d][0];
				nr = current.r + deltas[d][1];
				nc = current.c + deltas[d][2];

				if (nh >= 0 && nh < H && nr >= 0 && nr < N && nc >= 0 && nc < M && !map[nh][nr][nc]) {
					map[nh][nr][nc] = true;
					queue.offer(new Node(nh, nr, nc, current.level + 1));
					remain--;
				}
			}
		}

		if (remain != 0) {
			System.out.println(-1);
		} else {
			if (current == null) {
				System.out.println(0);
			} else {
				System.out.println(current.level);
			}
		}
	}

	static class Node {
		int h, r, c, level;

		public Node(int h, int r, int c, int level) {
			super();
			this.h = h;
			this.r = r;
			this.c = c;
			this.level = level;
		}
	}
}
