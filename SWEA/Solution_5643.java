import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5643 {
	static ArrayList<Integer>[] adjList;
	static int N;
	static boolean[][] cntLink; // 키 비교 가능함을 체크하기 위한 변수
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		int M, ans;
		boolean flag;
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			M= Integer.parseInt(br.readLine());
			adjList = new ArrayList[N+1];
			cntLink = new boolean[N+1][N+1];
			for(int i=1; i<=N; i++) {
				adjList[i] = new ArrayList<>();
			}
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine()," ");
				adjList[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
			}
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					cntLink[i][j] = false;
					if(i == j) {
						cntLink[i][j] = true;
					}
				}
			}
			for(int i=1; i<=N; i++) {
				bfs(i);
			}
			
			ans = 0;
			for(int i=1; i<=N; i++) {
				flag = true;
				for(int j=1; j<=N; j++) {
					if(!cntLink[i][j]) {
						flag = false;
						break;
					}
				}
				if(flag)
					ans++;
			}

			System.out.println("#"+t+" "+ans);
		}
	}

	private static void bfs(int start) {
		boolean[] visited = new boolean[N+1];
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(start);
		visited[start] = true;
		
		int current;
		while(!queue.isEmpty()) {
			current = queue.poll();
			if(adjList[current].isEmpty())
				continue;
			for(int to : adjList[current]) {
				if(!visited[to]) {
					visited[to] = true;
					queue.offer(to);
					cntLink[start][to] = true;
					cntLink[to][start] = true;
				}
			}
		}
	}

}
