import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());

		int wT = t % (2 * w);
		int hT = t % (2 * h);
		int pDir = 1;
		int qDir = 1;
		for (int i = 0; i < wT; i++) {
			if (p == 0 && pDir == -1)
				pDir = 1;
			if (p == w && pDir == 1)
				pDir = -1;

			p += pDir;
		}
		for (int i = 0; i < hT; i++) {
			if (q == 0 && qDir == -1)
				qDir = 1;
			if (q == h && qDir == 1)
				qDir = -1;

			q += qDir;
		}
		System.out.println(p + " " + q);
	}

}
