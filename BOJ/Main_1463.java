import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1463 {
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int X = Integer.parseInt(br.readLine());

		int[] num = new int[1000001];

		for (int i = 2; i <= X; i++) {
			num[i] = num[i - 1] + 1;
			if (i % 3 == 0)
				num[i] = Math.min(num[i], num[i / 3] + 1);
			if (i % 2 == 0)
				num[i] = Math.min(num[i], num[i / 2] + 1);
		}
		
		System.out.println(num[X]);
	}
}
