import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260 {
	
	static int N, M, V;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		int[][] adjMatrix = new int[N][N];
		
		for(int i = 0; i< M ; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			adjMatrix[to][from] = adjMatrix[from][to] = 1;
		}
		
		dfs(adjMatrix, new boolean[N], V-1);
		sb.append("\n");
		bfs(adjMatrix, V-1);
		System.out.println(sb.toString());
		
		
	}
	public static void bfs(int [][] adjMatrix, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			sb.append(current+1).append(" ");
			
			//current 정점의 인접정점 처리(단, 방문하지 않은 인접정점만)
			for(int j = 0; j < N; j++) {
				if(!visited[j] && adjMatrix[current][j] != 0) {
					queue.offer(j);
					visited[j] = true;
				}
			}
			
		}
	}
	public static void dfs(int[][] adjMatrix, boolean[] visited, int current) {
		
		//current : 현재 탐색 점
		visited[current] = true;
		sb.append(current+1).append(" ");
		//재귀를 타고올 때 마다 현재 정점이 됨
		
		// current 정점의 인접정점 처리(단, 방문하지 않은 인접정점만)
		for(int j = 0; j < N; j++) {
			if(!visited[j] && adjMatrix[current][j] != 0) {
				//if문에 만족하지 않으면 알아서 종료되므로 이 if문이 기저조건이 된다.
				dfs(adjMatrix, visited, j);
			}
		}
		
	}
	

}
