import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2559 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		int[] temperature = new int[N];
		for (int i = 0; i < N; i++) {
			temperature[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0, max;
		for (int i = 0; i < K; i++) {
			sum += temperature[i];
		}
		max = sum;
		for(int i=K; i<N; i++) {
			sum = sum - temperature[i-K]+temperature[i];
			if(sum > max)
				max = sum;
		}
		System.out.println(max);
	}

}
