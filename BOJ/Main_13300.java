import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13300 {

	public static void main(String[] args) throws IOException {
		int[][] students = new int[2][6];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			students[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())-1]++;
		}

		int sum = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				sum += students[i][j] / K;
				if (students[i][j] % K != 0)
					sum++;
			}
		}
		System.out.println(sum);
	}

}
