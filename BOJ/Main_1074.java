import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1074 {
	static int N, index, r, c;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		r = Integer.parseInt(line[1]);
		c = Integer.parseInt(line[2]);
		makeArr(N, 0, 0);

	}

	public static void makeArr(int n, int row, int column) {
		if (n == 0) {
			if (row == r && column == c) {
				System.out.println(index);
			}
			return;
		}
		if (r >= row && r < row + (int) Math.pow(2, n - 1)) { // 위쪽
			if (c >= column && c < column + (int) Math.pow(2, n - 1)) { // 왼쪽
				makeArr(n - 1, row, column);
			} else { // 오른쪽
				index += (int) Math.pow(2, n - 1) * (int) Math.pow(2, n - 1);
				makeArr(n - 1, row, column + (int) Math.pow(2, n - 1));
			}
		} else { // 아래쪽
			if (c >= column && c < column + (int) Math.pow(2, n - 1)) { // 왼쪽
				index += 2 * (int) Math.pow(2, n - 1) * (int) Math.pow(2, n - 1);
				makeArr(n - 1, row + (int) Math.pow(2, n - 1), column);
			} else { // 오른쪽
				index += 3 * (int) Math.pow(2, n - 1) * (int) Math.pow(2, n - 1);
				makeArr(n - 1, row + (int) Math.pow(2, n - 1), column + (int) Math.pow(2, n - 1));
			}
		}
	}
}
