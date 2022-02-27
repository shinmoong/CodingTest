import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1002 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st = null;
		double x1, y1, r1, x2, y2, r2, dist;
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine(), " ");

			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			r1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());
			dist = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2); // 거리 제곱
			if (dist == 0) {
				if (r1 == r2)
					System.out.println(-1);
				else
					System.out.println(0);
			} else {
				if (dist == (r1 + r2) * (r1 + r2))
					System.out.println(1);
				else if (dist > (r1 + r2) * (r1 + r2))
					System.out.println(0);
				else if (dist == (r1 - r2) * (r1 - r2))
					System.out.println(1);
				else if (dist < (r1 - r2) * (r1 - r2))
					System.out.println(0);
				else
					System.out.println(2);

			}
		}
	}

}
