import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1149 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] result = new int[3];
		String[] line;
		int r, g, b, tmp0, tmp1, tmp2;

		for (int i = 0; i < N; i++) {
			line = br.readLine().split(" ");
			r = Integer.parseInt(line[0]);
			g = Integer.parseInt(line[1]);
			b = Integer.parseInt(line[2]);

			tmp0 = r + Math.min(result[1], result[2]);
			tmp1 = g + Math.min(result[0], result[2]);
			tmp2 = b + Math.min(result[0], result[1]);

			result[0] = tmp0;
			result[1] = tmp1;
			result[2] = tmp2;
		}

		System.out.println(Math.min(Math.min(result[0], result[1]), result[2]));
	}

}
