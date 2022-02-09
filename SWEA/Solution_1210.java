import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1210 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		int N = 100;
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		for (int test_case = 1; test_case <= T; test_case++) {

			/////////////////////////////////////////////////////////////////////////////////////////////
			char[][] arr = new char[N][N];
			int r = 0, c = 0;
			int[] dir = { -1, 0 };
			br.readLine();
			for (int i = 0; i < N; i++) {
				String[] tmp = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = tmp[j].charAt(0);
				}
				
				if (i == N - 1) {
					for (int j = 0; j < N; j++) {
						if (arr[i][j] == '2') {
							r = i;
							c = j;
						}
					}
				}
			}

			while (true) {
				if (r == 0)
					break;

				if (dir[0] == -1 && dir[1] == 0) { // 위로
					if (c - 1 >= 0 && c - 1 < N && arr[r][c - 1] == '1') {
						c--;
						dir[0] = 0;
						dir[1] = -1;
					} else if (c + 1 >= 0 && c + 1 < N && arr[r][c + 1] == '1') {
						c++;
						dir[0] = 0;
						dir[1] = 1;
					} else {
						r--;
					}
				} else if (dir[0] == 0 && dir[1] == -1) { // 왼쪽
					if (c - 1 >= 0 && c - 1 < N && arr[r][c - 1] == '1') {
						c--;
					} else {
						r--;
						dir[0] = -1;
						dir[1] = 0;
					}
				} else { // 오른쪽
					if (c + 1 >= 0 && c + 1 < N && arr[r][c + 1] == '1') {
						c++;
					} else {
						r--;
						dir[0] = -1;
						dir[1] = 0;
					}
				}
			}

			System.out.println("#" + test_case + " " + c);
			/////////////////////////////////////////////////////////////////////////////////////////////

		}
	}

}
