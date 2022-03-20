import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2579 {
	static int N, max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		int curStair = 0;
		int x = 0, o = 0, o2 = 0, tmpx, tmpo, tmpo2;

		for (int i = 0; i < N; i++) {
			curStair = Integer.parseInt(br.readLine());
			tmpx = x;
			tmpo = o;
			tmpo2 = o2;
			x = Math.max(tmpo, tmpo2);
			o = tmpx + curStair;
			o2 = tmpo + curStair;
		}

		System.out.println(Math.max(o, o2));
	}
}
