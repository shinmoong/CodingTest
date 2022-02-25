import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2116 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] dices = new int[N][6];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 6; j++) {
				dices[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int ans = 0;
		for (int i = 0; i < 6; i++) {
			int topIdx = i;
			int bottomIdx = 0;
			int topVal = dices[0][i];
			int bigger = 0, smaller = 0, max = 0, sum = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 6; k++) {
					if (topVal == dices[j][k]) {
						bottomIdx = k;
					}
				}
				switch (bottomIdx) {
				case 0:
					topIdx = 5;
					break;
				case 1:
					topIdx = 3;
					break;
				case 2:
					topIdx = 4;
					break;
				case 3:
					topIdx = 1;
					break;
				case 4:
					topIdx = 2;
					break;
				case 5:
					topIdx = 0;
					break;
				}
				topVal = dices[j][topIdx];
				bigger = Math.max(dices[j][topIdx], dices[j][bottomIdx]);
				smaller = Math.min(dices[j][topIdx], dices[j][bottomIdx]);
				max = 6;
				if (bigger == 6)
					max = 5;
				if (smaller == 5)
					max = 4;

				sum += max;
			}
			ans = Math.max(ans, sum);
		}
		
		System.out.println(ans);
	}

}
