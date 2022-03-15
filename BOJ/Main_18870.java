import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_18870 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Pos> pq = new PriorityQueue<>();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] ans = new int[N];
		for (int i = 0; i < N; i++) {
			pq.offer(new Pos(Integer.parseInt(st.nextToken()),i));
		}
		
		Pos current = pq.poll();
		int cnt=0;
		int prev = current.x;
		ans[current.idx] = cnt;
		for(int i=1; i<N; i++) {
			current = pq.poll();
			if(current.x > prev) {
				ans[current.idx] = ++cnt;
				prev = current.x;
			}else {
				ans[current.idx] = cnt;
			}
		}
		
		StringBuilder sb= new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(ans[i]).append(" ");
		}
		
		System.out.println(sb);
	}

	static class Pos implements Comparable<Pos> {
		int x, idx;

		public Pos(int x, int idx) {
			this.x = x;
			this.idx = idx;
		}

		@Override
		public int compareTo(Pos o) {
			return this.x - o.x;
		}

	}
}
