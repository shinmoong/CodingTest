import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206 {
	static int N, M, ans=-1;
	static boolean[][] map;
	static int[][] deltas = {{1, 0},{-1, 0},{0, -1},{0, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		
		char[] line;
		for(int i=0; i<N; i++) {
			line = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				if(line[j]=='1')
					map[i][j] = true;
			}
		}
		
		bfs(); // r, c, 벽 부순 여부
		
		System.out.println(ans);
	}

	private static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(0,0,1, 0));
		Node current = null;
		int nr, nc;
		boolean visited[][][] = new boolean[N][M][2];
		visited[0][0][0] = true;
		while(!queue.isEmpty()) {
			current = queue.poll();
			
			if(current.r == N-1 && current.c == M-1) {
				ans = current.depth;
				return;
			}
			for(int d=0; d<4; d++) {
				nr = current.r+deltas[d][0];
				nc = current.c+deltas[d][1];
				if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc][current.breaked]) {
					if(!map[nr][nc]){ // 벽 아님
						queue.offer(new Node(nr, nc, current.depth+1, current.breaked));
						visited[nr][nc][current.breaked] = true;
					} else if(current.breaked == 0) {
						queue.offer(new Node(nr, nc, current.depth+1, 1));
						visited[nr][nc][1] = true;
					}
				}
			}
		}
	}

	static class Node{
		int r, c, depth, breaked;
		public Node(int r, int c, int depth, int breaked) {
			this.r = r;
			this.c = c;
			this.depth = depth;
			this.breaked = breaked;
		}
	}
}
