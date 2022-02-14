import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().split(" ");
		int N = Integer.parseInt(line[0]);
		int K = Integer.parseInt(line[1]);
		Queue<Integer> input = new LinkedList<>();
		Queue<Integer> output = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			input.offer(i);
		}

		int cnt = 0;
		while (!input.isEmpty()) {
			if (cnt == K - 1)
				output.offer(input.poll());
			else
				input.offer(input.poll());

			cnt = (cnt + 1) % K;
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for (int e : output) {
			sb.append(e + ", ");
		}
		sb.setLength(sb.length() - 2);
		sb.append(">");
		System.out.println(sb);
	}

}
