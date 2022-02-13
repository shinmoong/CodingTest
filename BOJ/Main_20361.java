import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_20361 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().split(" ");

		int X = Integer.parseInt(line[1]);
		int K = Integer.parseInt(line[2]);

		for (int i = 0; i < K; i++) {
			line = br.readLine().split(" ");

			if (Integer.parseInt(line[0]) == X) {
				X = Integer.parseInt(line[1]);
			} else if (Integer.parseInt(line[1]) == X) {
				X = Integer.parseInt(line[0]);
			}
		}

		System.out.println(X);
	}

}
