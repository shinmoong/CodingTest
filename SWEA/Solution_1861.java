import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1861 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int[][] map;
	static int[][] index;
	static int current = 1;
	static int N;
	static int ans_index;
	static int ans_count;

	public static int search() {
		int nx, ny;
		int count = 1;
		boolean flag = true;
		while (flag) {
			flag = false; // 사방 탐색을 했는데도 옮길 자리를 못 찾은 경우 while문을 끝내야 함.
			for (int i = 0; i < 4; i++) {
				nx = index[current][0] + dx[i];
				ny = index[current][1] + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < N && map[nx][ny] == current + 1) {
					count++;
					current++;
					flag = true;
					break;
				}
			}
		}
		return count; // 갯수 current - return값
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			index = new int[(N * N) + 1][2];
			current = 1;
			ans_index = 1;
			ans_count = 0;
			index[0] = new int[] { -1, -1 };
			int temp;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < N; k++) {
					temp = Integer.parseInt(st.nextToken());
					map[i][k] = temp;
					index[temp][0] = i;
					index[temp][1] = k;
				}
			}

			while (current < N * N + 1) {
				int temp_num = search();
//                System.out.printf("%d %d\n",current,temp_num);
				if (ans_count < temp_num) {
					ans_count = temp_num;
					ans_index = current - ans_count + 1;
//                    System.out.printf("%d %d\n", ans_index, ans_count);
				}
				current++;
			}
			System.out.println("#" + test_case + " " + ans_index + " " + ans_count);
		}
	}
}
