import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1389 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[][] adj = new boolean[N+1][N+1];
		
		int from, to;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			adj[from][to] = true;
			adj[to][from] = true;
		}
		
		boolean visited[] = new boolean[N+1];
		Queue<Node> queue = new LinkedList<Node>();
		int min = Integer.MAX_VALUE, sum, ans = 0;
		Node current;
		for(int t=1; t<=N; t++) {
			sum=0;
			Arrays.fill(visited, false);
			
			queue.offer(new Node(t, 0));
			visited[t] = true;
			
			while(!queue.isEmpty()) {
				current = queue.poll();
				
				for(int i=1; i<=N; i++) {
					if(!visited[i] && adj[current.idx][i]) {
						sum+=(current.depth+1);
						visited[i] = true;
						queue.offer(new Node(i, current.depth+1));
					}
				}
			}
			
			if(sum < min) {
				ans = t;
				min = sum;
			}
		}
		
		System.out.println(ans);
	}

	static class Node{
		int idx, depth;

		public Node(int idx, int depth) {
			this.idx = idx;
			this.depth = depth;
		}
	}
}
