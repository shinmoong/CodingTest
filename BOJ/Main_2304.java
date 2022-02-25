import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2304 {

	static class Pillar implements Comparable<Pillar> {
		int x, y;

		public Pillar(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pillar o) {
			return this.x - o.x;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Pillar[] pillars = new Pillar[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			pillars[i] = new Pillar(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(pillars);

		int maxIdx = 0;
		for (int i = 0; i < N; i++) {
			if (pillars[i].y > pillars[maxIdx].y)
				maxIdx = i;
		}

		int maxY = pillars[0].y;
		int prevX = pillars[0].x;
		int sum = 0;
		sum += pillars[maxIdx].y;
		for (int i = 1; i <= maxIdx; i++) {
			sum += (maxY * (pillars[i].x - prevX));

			if (pillars[i].y > maxY) {
				maxY = pillars[i].y;
			}
			prevX = pillars[i].x;
		}

		maxY = pillars[N - 1].y;
		prevX = pillars[N - 1].x;
		for (int i = N - 2; i >= maxIdx; i--) {
			sum += (maxY * (prevX - pillars[i].x));

			if (pillars[i].y > maxY) {
				maxY = pillars[i].y;
			}
			prevX = pillars[i].x;
		}

		System.out.println(sum);
	}
}
