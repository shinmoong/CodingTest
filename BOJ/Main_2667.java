import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_2667 {
	static char cnt = '1';
	static char[][] map;
	static int r, c;
	static int[][] deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int N;
	static int size;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new char[N][];
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '1') {
					cnt++;
					r = i;
					c = j;
					size = 0;
					//bfs();
					dfs(r, c);
					list.add(size);
				}
			}
		}
		Collections.sort(list);
		sb.append(cnt - '1' + "\n");

		for (int num : list) {
			sb.append(num + "\n");
		}
		System.out.print(sb);
	}

	public static void bfs() {
		Queue<int[]> queue = new LinkedList<>();

		queue.offer(new int[] { r, c });
		map[r][c] = cnt;
		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			size++;
			for (int i = 0; i < 4; i++) {
				int nr = current[0] + deltas[i][0];
				int nc = current[1] + deltas[i][1];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == '1') {
					queue.offer(new int[] { nr, nc });
					map[nr][nc] = cnt;
				}
			}
		}
	}

	public static void bfs2() {
		Queue<int[]> queue = new LinkedList<>();

		queue.offer(new int[] { r, c });
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			if (map[current[0]][current[1]] != cnt) {
				map[current[0]][current[1]] = cnt;
				size++;
			}
			for (int i = 0; i < 4; i++) {
				int nr = current[0] + deltas[i][0];
				int nc = current[1] + deltas[i][1];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == '1') {
					queue.offer(new int[] { nr, nc });
				}
			}
		}
	}
	
	public static void dfs(int r, int c) {
		map[r][c] = cnt;
		size++;
		for (int i = 0; i < 4; i++) {
			int nr = r + deltas[i][0];
			int nc = c + deltas[i][1];

			if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == '1') {
				dfs(nr, nc);
			}
		}
	}
}
