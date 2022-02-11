import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1233 {
	static char[] tree;
	static int N, check;
	static boolean flag;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			tree = new char[N + 1];

			for (int i = 1; i <= N; i++) {
				tree[i] = br.readLine().split(" ")[1].charAt(0);
			}
			check = 0;
			flag = true;
			isvalid(1);
			System.out.print("#" + test_case + " ");
			if (flag)
				System.out.println(1);
			else
				System.out.println(0);
		}
	}

	public static void isvalid(int start) {
		if (start * 2 <= N)
			isvalid(start * 2);
		
		// check가 0이면 숫자, 1이면 연산기호
		if (check == 1 && tree[start] >= '0' && tree[start] <= '9') {
			flag = false;
		}
		if (check == 0 && (tree[start] < '0' || tree[start] > '9')) {
			flag = false;
		}
		check = (check + 1) % 2;
		
		if (start * 2 + 1 <= N)
			isvalid(start * 2 + 1);
	}
}
