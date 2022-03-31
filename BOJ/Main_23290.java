import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_23290 {
	static int M, S;
	static int[][] fishDeltas = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 },
			{ 1, -1 } };
	static int[][] sharkDeltas = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
	static int[][][] fishMap = new int[4][4][8];
	static int[][][] copyMap = new int[4][4][8];
	static int[][][] moveMap = new int[4][4][8];
	static int[][] fishSumMap = new int[4][4];
	static int[][] copySumMap = new int[4][4];
	static boolean[][] beforeSmell = new boolean[4][4];
	static boolean[][] nowSmell = new boolean[4][4];
	static boolean[][] tmpSmell = new boolean[4][4];
	static int sharkR, sharkC;
	static boolean[] canMove = new boolean[8];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		int a, b;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken()) - 1;
			b = Integer.parseInt(st.nextToken()) - 1;
			fishMap[a][b][Integer.parseInt(st.nextToken()) - 1]++;
			fishSumMap[a][b]++;
		}
		st = new StringTokenizer(br.readLine(), " ");
		sharkR = Integer.parseInt(st.nextToken()) - 1;
		sharkC = Integer.parseInt(st.nextToken()) - 1;

		for (int t = 0; t < S; t++) {
			copy();
			fishMove();
			sharkMove();
			deleteSmell();
			successCopy();
		}

		int ans= 0;
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				ans += fishSumMap[i][j];
			}
		}
		
		System.out.println(ans);
	}

	private static void successCopy() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				fishSumMap[i][j] += copySumMap[i][j];
				for (int k = 0; k < 8; k++) {
					fishMap[i][j][k] = copyMap[i][j][k] + moveMap[i][j][k];
					moveMap[i][j][k] = 0;
				}
			}	
		}		
	}

	private static void deleteSmell() {
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				beforeSmell[i][j] = nowSmell[i][j];
				nowSmell[i][j] = tmpSmell[i][j];
				tmpSmell[i][j] = false;
			}
		}
	}

	private static void sharkMove() {
		int ar, ac, br, bc, cr, cc, suma, sumb, sumc;
		int max = -1;
		int[][] selected = new int[3][2];
		
		for (int i = 0; i < 4; i++) {
			ar = sharkR + sharkDeltas[i][0];
			ac = sharkC + sharkDeltas[i][1];
			if (ar < 0 || ar >= 4 || ac < 0 || ac >= 4)
				continue;
			suma = fishSumMap[ar][ac];
			for (int j = 0; j < 4; j++) {
				br = ar + sharkDeltas[j][0];
				bc = ac + sharkDeltas[j][1];
				if (br < 0 || br >= 4 || bc < 0 || bc >= 4)
					continue;
				sumb = suma + fishSumMap[br][bc];
				for (int k = 0; k < 4; k++) {
					cr = br + sharkDeltas[k][0];
					cc = bc + sharkDeltas[k][1];
					if (cr < 0 || cr >= 4 || cc < 0 || cc >= 4)
						continue;

					if (ar != cr || ac != cc) {
						sumc = sumb + fishSumMap[cr][cc];
					} else {
						sumc = sumb;
					}

					if (sumc > max) {
						max = sumc;
						selected[0][0] = ar;
						selected[0][1] = ac;
						selected[1][0] = br;
						selected[1][1] = bc;
						selected[2][0] = cr;
						selected[2][1] = cc;
					}
				}
			}
		}
		
		int r, c;
		for(int i=0; i<3; i++) {
			r = selected[i][0];
			c = selected[i][1];
			if(fishSumMap[r][c] != 0) {
				fishSumMap[r][c] = 0;
				tmpSmell[r][c] = true;
				for(int j=0; j<8; j++) {
					moveMap[r][c][j] = 0;
				}
			}
		}
		sharkR = selected[2][0];
		sharkC = selected[2][1];
	}

	private static void fishMove() {
		int nr, nc, dir;
		boolean flag;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				flag = false;
				for (int k = 0; k < 8; k++) {
					nr = i + fishDeltas[k][0];
					nc = j + fishDeltas[k][1];

					if (nr >= 0 && nr < 4 && nc >= 0 && nc < 4 && !beforeSmell[nr][nc] && !nowSmell[nr][nc]
							&& !((nr == sharkR) && (nc == sharkC))) {
						flag = true;
						canMove[k] = true;
					} else {
						canMove[k] = false;
					}
				}

				if (!flag) {
					for (int k = 0; k < 8; k++) {
						moveMap[i][j][k] += fishMap[i][j][k];
					}
					continue;
				}

				for (int k = 0; k < 8; k++) {
					dir = k;
					for (int l = 0; l < 8; l++) {
						if (canMove[dir]) {
							moveMap[i + fishDeltas[dir][0]][j + fishDeltas[dir][1]][dir] += fishMap[i][j][k];
							fishSumMap[i][j] -= fishMap[i][j][k];
							fishSumMap[i + fishDeltas[dir][0]][j + fishDeltas[dir][1]] += fishMap[i][j][k];
							break;
						}
						dir = (dir + 7) % 8;
					}
				}
			}
		}
	}

	static void copy() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 8; k++) {
					copyMap[i][j][k] = fishMap[i][j][k];
					copySumMap[i][j] = fishSumMap[i][j];
				}
			}
		}
	}
}
