import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236 {
	static int N;
	static int[][] map;
	static int size = 2;
	static int num_eat = 0;
	static int cur_r, cur_c;
	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };
	static int ans = 0;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < N; k++) {
				map[i][k] = Integer.parseInt(st.nextToken());
				if (map[i][k] == 9) {
					cur_r = i;
					cur_c = k;
					map[i][k] = 0;
				}
			}
		}
		while (BFS(cur_r, cur_c)) {
			if (num_eat == size) {
				num_eat = 0;
				size++;
			}
		}

		System.out.println(ans);

	}

	public static boolean BFS(int input_r, int input_c) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { input_r, input_c, 0 });
		int[] temp;
		int r, c, cnt, min = -1;
		int ans_r = 0, ans_c = 0;
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], false);
		}
		visited[input_r][input_c] = true;
		while (!queue.isEmpty()) {
			temp = queue.poll();
			r = temp[0];
			c = temp[1];
			cnt = temp[2];
			if (0 < map[r][c] && map[r][c] < size) {
				if (min == -1) {
					min = cnt;
					flag = true;
					ans_r = r;
					ans_c = c;
				}
				if (min == cnt) {
					if (r < ans_r) {
						ans_r = r;
						ans_c = c;
					} else if (r == ans_r) {
						ans_c = Math.min(ans_c, c);
					}
				}
			}
			if (flag && min < cnt)
				break;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (0 <= nr && nr < N && 0 <= nc && nc < N && map[nr][nc] <= size && !visited[nr][nc]) {
					visited[nr][nc] = true;
					queue.add(new int[] { nr, nc, cnt + 1 });
				}
			}
		}
		if (flag) {
			map[ans_r][ans_c] = 0;
			num_eat++;
			cur_r = ans_r;
			cur_c = ans_c;
			ans += min;
		}
		return flag;
	}
}
