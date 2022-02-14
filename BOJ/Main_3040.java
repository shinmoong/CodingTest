import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3040 {
	static int[] arr;
	static boolean[] isSelected = new boolean[9];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = new int[9];
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		getDwarf(0, 0, 0);
	}

	public static void getDwarf(int cnt, int start, int sum) {
		if (cnt == 7) {
			if (sum == 100) {
				for (int i = 0; i < 9; i++) {
					if (isSelected[i])
						System.out.println(arr[i]);
				}
			}
			return;
		}

		for (int i = start; i < 9; i++) {
			isSelected[i] = true;
			getDwarf(cnt + 1, i + 1, sum + arr[i]);
			isSelected[i] = false;
		}
	}
}
