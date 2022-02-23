import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10163 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[1001][1001];
		int[] areas = new int[N + 1];

		StringTokenizer st;
		Point p1 = new Point();
		Point p2 = new Point();
		for (int t = 1; t <= N; t++) {
			st = new StringTokenizer(br.readLine());
			p1.x = Integer.parseInt(st.nextToken());
			p1.y = Integer.parseInt(st.nextToken());
			p2.x = p1.x + Integer.parseInt(st.nextToken()) - 1;
			p2.y = p1.y + Integer.parseInt(st.nextToken()) - 1;

			for (int i = p1.y; i <= p2.y; i++) {
				for (int j = p1.x; j <= p2.x; j++) {
					arr[i][j] = t;
				}
			}
		}

		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				areas[arr[i][j]]++;
			}
		}

		for (int i = 1; i <= N; i++) {
			System.out.println(areas[i]);
		}
	}

}
