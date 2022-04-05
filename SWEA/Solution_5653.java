import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5653 {
	static int N, M, K, ans;
	static int[][] map = new int[650][650];
	static Queue<Cell> inactiveQ, activeQ, tmpQ = new LinkedList<>();
	static PriorityQueue<GrowthCell> growthPQ;
	static int[][] deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			inactiveQ = new LinkedList<>();
			activeQ = new LinkedList<>();
			growthPQ = new PriorityQueue<>();
			ans = 0;

			for (int i = 0; i < 650; i++) {
				for (int j = 0; j < 650; j++) {
					map[i][j] = 0;
				}
			}
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					map[i + 300][j + 300] = Integer.parseInt(st.nextToken());
					inactiveQ.offer(new Cell(i + 300, j + 300, 0));
					if (map[i + 300][j + 300] != 0)
						ans++;
				}
			}

			for (int i = 0; i < K; i++) {
				// 활성 상태 처리
				doActive();
				// 번식 상태 처리
				doGrowth();
				// 비활성 상태 처리
				doInactive();
				// tmpQ에 저장했던 비활성 상태 저장
				saveInactive();
			}

			System.out.println("#" + t + " " + ans);
		}
	}

	private static void saveInactive() {
		while(!tmpQ.isEmpty()) {
			inactiveQ.offer(tmpQ.poll());
		}
	}

	private static void doActive() {
		int size = activeQ.size();
		Cell current;

		for (int i = 0; i < size; i++) {
			current = activeQ.poll();
			current.t++;
			if (current.t == 2 * map[current.r][current.c]) { // 죽음 상태
				ans--;
			} else { // 활성 상태
				activeQ.offer(current);
			}
		}
	}

	private static void doGrowth() {
		GrowthCell current;
		int nr, nc;
		while (!growthPQ.isEmpty()) {
			current = growthPQ.poll();
			for (int d = 0; d < 4; d++) {
				nr = current.r + deltas[d][0];
				nc = current.c + deltas[d][1];

				if (map[nr][nc] == 0) {
					map[nr][nc] = current.vitality;
					tmpQ.offer(new Cell(nr, nc, 0));
					ans++;
				}
			}
			current.t++;
			if (current.t == 2 * map[current.r][current.c]) { // 죽음 상태
				ans--;
			} else { // 활성 상태
				activeQ.offer(new Cell(current.r, current.c, current.t));
			}
		}
	}

	private static void doInactive() {
		int size = inactiveQ.size();
		Cell current;

		for (int i = 0; i < size; i++) {
			current = inactiveQ.poll();
			current.t++;
			if (current.t == map[current.r][current.c]) { // 번식 상태
				growthPQ.offer(new GrowthCell(current.r, current.c, current.t, map[current.r][current.c]));
			} else { // 비활성 상태
				inactiveQ.offer(current);
			}
		}
	}

	static class Cell {
		int r, c, t;

		public Cell(int r, int c, int t) {
			super();
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}

	static class GrowthCell extends Cell implements Comparable<GrowthCell> {
		int vitality;

		public GrowthCell(int r, int c, int t, int vitality) {
			super(r, c, t);
			this.vitality = vitality;
		}

		@Override
		public int compareTo(GrowthCell o) {
			return o.vitality - this.vitality;
		}
	}
}
