import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1992 {
	static int N;
	static String[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new String[N][];
		
		String[] line;
		for (int i = 0; i < N; i++) {
			line = br.readLine().split("");
			arr[i] = line.clone();
		}
		System.out.println(getResult(0, 0, N));
	}

	public static String getResult(int r, int c, int n) {
		if (n == 1) {
			return arr[r][c];
		}

		String lu = getResult(r, c, n / 2);
		String ru = getResult(r, c + n / 2, n / 2);
		String ld = getResult(r + n / 2, c, n / 2);
		String rd = getResult(r + n / 2, c + n / 2, n / 2);

		if ((lu.equals("0") && ru.equals("0") && ld.equals("0") && rd.equals("0")) || (lu.equals("1") && ru.equals("1") && ld.equals("1") && rd.equals("1")))
			return lu;
		else
			return "(" + lu + ru + ld + rd + ")";
	}
}
