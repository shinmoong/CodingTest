import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10157 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().split(" ");
		int C = Integer.parseInt(line[0]); // 가로
		int R = Integer.parseInt(line[1]); // 세로
		int K = Integer.parseInt(br.readLine());
		boolean[][] map = new boolean[R + 1][C + 1];
		int[][] deltas = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

		int cnt = 1, curR = 1, curC = 1, nr, nc, dir = 0;

		if (K > C * R) {
			System.out.println(0);
		} else {
			while (cnt <= C * R) {
				if (cnt == K) {
					System.out.println(curC + " " + curR);
					break;
				}
				map[curR][curC] = true;
				nr = curR + deltas[dir][0];
				nc = curC + deltas[dir][1];

				if (nr < 1 || nr > R || nc < 1 || nc > C || map[nr][nc]) {
					dir = (dir + 1) % 4;
					continue;
				}

				curR = nr;
				curC = nc;
				cnt++;
			}
		}
	}

}
