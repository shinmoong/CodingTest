import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502 {
	static int N, M;
	static ArrayList<Point> virusList = new ArrayList<>();
	static boolean[][] originalMap;
	static ArrayList<Point> zeroList = new ArrayList<>();
	static int zeroListLen, virusListLen;
	static int selected[][] = new int[3][2];
	static int[][] deltas = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
	static int safetyCount;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		originalMap = new boolean[N][M];
		char val;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				val = st.nextToken().charAt(0);
				if (val == '1') {
					originalMap[i][j] = true;
				} else if (val == '2') {
					originalMap[i][j] = true;
					virusList.add(new Point(i, j));
				} else {
					zeroList.add(new Point(i, j));
					safetyCount++;
				}
			}
		}
		zeroListLen = zeroList.size();
		virusListLen = virusList.size();
		safetyCount -= 3; // 벽 만드는 갯수만큼 미리 제외.
		combination(0, 0);

		System.out.println(max);
	}

	private static void combination(int start, int cnt) {
		if (cnt == 3) {
			boolean[][] newMap = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					newMap[i][j] = originalMap[i][j];
				}
			}
			for (int i = 0; i < 3; i++) {
				newMap[selected[i][0]][selected[i][1]] = true;
			}

			bfs(newMap);
			return;
		}

		for (int i = start; i < zeroListLen; i++) {
			selected[cnt][0] = zeroList.get(i).x;
			selected[cnt][1] = zeroList.get(i).y;
			combination(i + 1, cnt + 1);
		}
	}

	private static void bfs(boolean[][] map) {
		Point curVirus;
		Point current;
		Queue<Point> queue = new LinkedList<>();
		int nr, nc;
		int val = safetyCount;

		for (int i = 0; i < virusListLen; i++) {
			curVirus = virusList.get(i);
			queue.offer(curVirus);

			while (!queue.isEmpty()) {
				current = queue.poll();

				for (int d = 0; d < 4; d++) {
					nr = current.x + deltas[d][0];
					nc = current.y + deltas[d][1];
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && !map[nr][nc]) {
						map[nr][nc] = true;
						queue.offer(new Point(nr, nc));
						val--;
					}
				}
			}
		}

		if (max < val)
			max = val;
	}

}
