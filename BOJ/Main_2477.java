import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2477 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] lens = new int[6];
		int val = Integer.parseInt(br.readLine());

		int max1 = 0, max2 = 0, idx1 = 0, idx2 = 0, min1 = 0, min2 = 0;
		for (int i = 0; i < 6; i++) {
			lens[i] = Integer.parseInt(br.readLine().split(" ")[1]);
		}

		for (int i = 0; i < 3; i++) {
			if (max1 < lens[2 * i]) {
				max1 = lens[2 * i];
				idx1 = 2 * i;
			}
			if (max2 < lens[2 * i + 1]) {
				max2 = lens[2 * i + 1];
				idx2 = 2 * i + 1;
			}
		}

		if ((idx1 + 1) % 6 == idx2) {
			min1 = lens[(idx1 + 3) % 6];
			min2 = lens[(idx1 + 4) % 6];
		} else {
			min1 = lens[(idx2 + 3) % 6];
			min2 = lens[(idx2 + 4) % 6];
		}
		
		System.out.println(val*(max1*max2-min1*min2));
	}

}
