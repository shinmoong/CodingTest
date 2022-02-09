import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_1873 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			/////////////////
			int H = sc.nextInt();
			int W = sc.nextInt();
			char[][] map = new char[H][W];
			int tankR = -1, tankC = -1; // 전차의 row, column index
			int N; // 전차 동작 횟수
			char[] commands;
			int direction = -1;
			int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

			for (int i = 0; i < H; i++) {
				String line = sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j] = line.charAt(j);
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						tankR = i;
						tankC = j;
						if (map[i][j] == '^') {
							direction = 0;
						} else if (map[i][j] == 'v') {
							direction = 1;
						} else if (map[i][j] == '<') {
							direction = 2;
						} else { // '>'
							direction = 3;
						}
					}
				}
			}

			N = sc.nextInt();

			commands = sc.next().toCharArray();

			for (int i = 0; i < N; i++) {
				if (commands[i] == 'U') {
					direction = 0;
					int nr = tankR + deltas[direction][0];
					int nc = tankC + deltas[direction][1];
					if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] == '.') {
						map[tankR][tankC] = '.';
						map[nr][nc] = '^';
						tankR = nr;
						tankC = nc;
					} else {
						map[tankR][tankC] = '^';
					}
				} else if (commands[i] == 'D') {
					direction = 1;
					int nr = tankR + deltas[direction][0];
					int nc = tankC + deltas[direction][1];
					if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] == '.') {
						map[tankR][tankC] = '.';
						map[nr][nc] = 'v';
						tankR = nr;
						tankC = nc;
					} else {
						map[tankR][tankC] = 'v';
					}
				} else if (commands[i] == 'L') {
					direction = 2;
					int nr = tankR + deltas[direction][0];
					int nc = tankC + deltas[direction][1];
					if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] == '.') {
						map[tankR][tankC] = '.';
						map[nr][nc] = '<';
						tankR = nr;
						tankC = nc;
					} else {
						map[tankR][tankC] = '<';
					}
				} else if (commands[i] == 'R') {
					direction = 3;
					int nr = tankR + deltas[direction][0];
					int nc = tankC + deltas[direction][1];
					if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] == '.') {
						map[tankR][tankC] = '.';
						map[nr][nc] = '>';
						tankR = nr;
						tankC = nc;
					} else {
						map[tankR][tankC] = '>';
					}
				} else { // 'S'
					int nr = tankR + deltas[direction][0];
					int nc = tankC + deltas[direction][1];
					while(nr >= 0 && nr < H && nc >= 0 && nc < W) {
						if(map[nr][nc] == '*') {
							map[nr][nc] = '.';
							break;
						} else if(map[nr][nc] == '#') {
							break;
						}
						
						nr += deltas[direction][0];
						nc += deltas[direction][1];
					}
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#"+test_case+" ");
			
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			System.out.print(sb);
			/////////////////
		}
	}
}
