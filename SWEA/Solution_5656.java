import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656 {
	static int N, W, H, bCount, ans;
	static int[][] deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			int[][] map = new int[H][W];
			bCount = 0;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0)
						bCount++;
				}
			}

			ans = bCount;
			permutation(map, 0, bCount);

			System.out.println("#" + t + " " + ans);
		}
	}

	private static void permutation(int[][] map, int cnt, int bRemain) {
		if (ans == 0)
			return;

		if (bRemain == 0) {
			ans = 0;
			return;
		}

		if (cnt == N) {
			if (ans > bRemain)
				ans = bRemain;
			return;
		}

		Block startBlock;
		int explodeCnt;
		for (int i = 0; i < W; i++) {
			startBlock = findBlock(map, i);
			if (startBlock != null) {
				int[][] newMap = new int[H][W];
				for (int j = 0; j < H; j++) {
					for (int k = 0; k < W; k++) {
						newMap[j][k] = map[j][k];
					}
				}

				explodeCnt = explode(newMap, startBlock);
				down(newMap);
				permutation(newMap, cnt + 1, bRemain - explodeCnt);
			}
		}
	}

	private static void down(int[][] map) {
		int startR, cnt;
		int[] cntBlock = new int[W];
		for(int i=0; i<W; i++) {
			for(int j=0; j<H; j++) {
				if(map[j][i] > 0) {
					cntBlock[i]++;
				}
			}
		}
		for (int c = 0; c < W; c++) {
			startR = H - 1;
			cnt = 0;

			for (int r = H - 1; r >= 0; r--) {
				if (cnt == cntBlock[c])
					break;

				if (map[r][c] == 0)
					continue;

				if (startR == r) {
					cnt++;
					startR--;
					continue;
				}

				cnt++;
				map[startR][c] = map[r][c];
				map[r][c] = 0;
				startR--;
			}
		}
	}

	private static int explode(int[][] map, Block startBlock) {
		Queue<Block> newExplodeQueue = new LinkedList<>();
		int nr, nc, cnt = 1;
		Block current;
		newExplodeQueue.offer(startBlock);
		map[startBlock.r][startBlock.c] = 0;
		while (!newExplodeQueue.isEmpty()) {
			current = newExplodeQueue.poll();
			for (int i = 1; i < current.range; i++) {
				for (int d = 0; d < 4; d++) {
					nr = current.r + deltas[d][0] * i;
					nc = current.c + deltas[d][1] * i;

					if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] > 0) {
						if (map[nr][nc] > 1) {
							newExplodeQueue.offer(new Block(nr, nc, map[nr][nc]));
						}
						map[nr][nc] = 0;
						cnt++;
					}
				}
			}
		}
		return cnt;
	}

	private static Block findBlock(int[][] map, int c) {
		for (int i = 0; i < H; i++) {
			if (map[i][c] > 0)
				return new Block(i, c, map[i][c]);
		}
		return null;
	}

	static class Block {
		int r, c, range;

		public Block(int r, int c, int range) {
			super();
			this.r = r;
			this.c = c;
			this.range = range;
		}

		@Override
		public String toString() {
			return "Block [r=" + r + ", c=" + c + ", range=" + range + "]";
		}

	}
}
