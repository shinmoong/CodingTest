import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_5430 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		boolean dir = false; // false 면 앞에서부터, true면 뒤에서부터
		char[] commands;
		int n, commandLen;
		String[] numsTmp;
		String line;
		tc: for (int t = 1; t <= T; t++) {
			Deque<Integer> deque = new LinkedList<Integer>();

			commands = br.readLine().toCharArray();
			n = Integer.parseInt(br.readLine());
			line = br.readLine();
			numsTmp = line.substring(1, line.length() - 1).split(",");

			for (int i = 0; i < n; i++) {
				deque.offerLast(Integer.parseInt(numsTmp[i]));
			}

			commandLen = commands.length;
			dir = false;
			for (int i = 0; i < commands.length; i++) {
				if (commands[i] == 'R') {
					dir = !dir;
				} else {
					if (deque.isEmpty()) {
						System.out.println("error");
						continue tc;
					}

					if (!dir) {
						deque.pollFirst();
					} else {
						deque.pollLast();
					}
				}
			}

			if (deque.isEmpty()) {
				System.out.println("[]");
			} else {
				StringBuilder sb = new StringBuilder();
				sb.append('[');
				while (!deque.isEmpty()) {
					if (!dir) {
						sb.append(deque.pollFirst()).append(',');
					} else {
						sb.append(deque.pollLast()).append(',');
					}
				}
				sb.setLength(sb.length() - 1);
				sb.append(']');
				System.out.println(sb);
			}
		}
	}

}
