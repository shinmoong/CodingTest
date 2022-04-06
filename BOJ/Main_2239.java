import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_2239 {
	static int[][] sudoku = new int[9][9];
	static ArrayList<Point> zeroList = new ArrayList<>();
	static int num;
	static boolean getAns;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] line;
		boolean flag = false;
		for (int i = 0; i < 9; i++) {
			line = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = line[j] - '0';
				if (sudoku[i][j] == 0) {
					zeroList.add(new Point(i, j));
				}
			}
		}
		num = zeroList.size();
		zeroList.add(new Point(0, 0)); // 마지막에 cnt가 하나 더 증가하면서 읽게될 배열
		makeSudoku(zeroList.get(0).x, zeroList.get(0).y, 0);
	}

	private static void makeSudoku(int startR, int startC, int cnt) {
		if (getAns)
			return;

		if (!getAns && cnt == num) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(sudoku[i][j]);
				}
				System.out.println();
			}
			getAns = true;
			return;
		}

		int sr, sc;
		loop: for (int n = 1; n <= 9; n++) {
			for (int i = 0; i < 9; i++) {
				if (sudoku[startR][i] == n) {
					continue loop;
				}
				if (sudoku[i][startC] == n) {
					continue loop;
				}
			}
			sr = startR - startR % 3;
			sc = startC - startC % 3;
			for (int i = sr; i < sr + 3; i++) {
				for (int j = sc; j < sc + 3; j++) {
					if (sudoku[i][j] == n) {
						continue loop;
					}
				}
			}

			sudoku[startR][startC] = n;
			makeSudoku(zeroList.get(cnt + 1).x, zeroList.get(cnt + 1).y, cnt + 1);
			sudoku[startR][startC] = 0;
		}
	}

}
