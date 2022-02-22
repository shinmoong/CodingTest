import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2669 {

	public static void main(String[] args) throws IOException {
		boolean[][] arr = new boolean[100][100];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int cnt = 0;
		for (int t = 0; t < 4; t++) {
			st = new StringTokenizer(br.readLine(), " ");

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++) {
					if (!arr[i][j]) {
						cnt++;
						arr[i][j] = true;
					}
				}
			}
		}
		System.out.println(cnt);
	}

}
