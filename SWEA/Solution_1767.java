import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1767 {
	static boolean[][] originalMap;
	static ArrayList<Core> cores = new ArrayList<>();
	static int N, PCount;
	static int[][] deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int maxCores, minLength;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			PCount = 0;
			originalMap = new boolean[N][N];
			cores.clear();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					if (st.nextToken().charAt(0) == '1') {
						originalMap[i][j] = true;
						if (i != 0 && i != N - 1 && j != 0 && j != N - 1) {
							cores.add(new Core(i, j));
							PCount++;
						}
					} else {
						originalMap[i][j] = false;
					}
				}
			}

			maxCores = 0;
			minLength = Integer.MAX_VALUE;
			// permutation
			permutation(originalMap, 0, 0, 0);
			
			System.out.println("#"+t+" "+minLength);
		}
	}

	private static void permutation(boolean[][] map, int cnt, int useCnt, int length) {
		if(maxCores > PCount-cnt+useCnt)
			return;
		
		if(cnt == PCount) {
			if(useCnt > maxCores) {
				maxCores = useCnt;
				minLength = length;
			}
			else if(useCnt == maxCores) {
				if(minLength > length) {
					minLength = length;
				}
			}
			return;
		}

		Core core = cores.get(cnt);
		int newLength;
		
		for (int d = 0; d < 4; d++) {
			if (available(map, core.r, core.c, d)) {
				boolean[][] newMap = new boolean[N][N];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						newMap[i][j] = map[i][j];
					}
				}
				newLength = length + connect(newMap, core.r, core.c, d);
				permutation(newMap, cnt+1, useCnt+1, newLength);
			}
		}
		
		permutation(map, cnt+1, useCnt, length);
	}

	private static int connect(boolean[][] map, int r, int c, int d) {
		int nr = r, nc = c;
		int cnt = 0;
		
		while (true) {
			nr = nr + deltas[d][0];
			nc = nc + deltas[d][1];
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
				break;
			} else {
				map[nr][nc] = true;
				cnt++;
			}
		}

		return cnt;
	}

	private static boolean available(boolean[][] map, int r, int c, int d) {
		int nr = r, nc = c;

		while (true) {
			nr = nr + deltas[d][0];
			nc = nc + deltas[d][1];
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
				return true;
			} else {
				if (map[nr][nc])
					return false;
			}
		}
	}

	static class Core {
		int r, c;

		public Core(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}
