import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1931 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Conference[] confs = new Conference[N];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			confs[i] = new Conference(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(confs);

		int endT = 0;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (endT <= confs[i].start) {
				endT = confs[i].end;
				cnt++;
			}
		}

		System.out.println(cnt);
	}

	static class Conference implements Comparable<Conference> {
		int start, end;

		public Conference(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Conference o) {
			return (this.end == o.end) ? this.start - o.start : this.end - o.end;
		}
	}
}
