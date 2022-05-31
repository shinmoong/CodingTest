import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2644 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		boolean[][] adjMatrix = new boolean[N+1][N+1];
		boolean[] visited = new boolean[N+1];
		
		String[] line = br.readLine().split(" ");
		int p1 = Integer.parseInt(line[0]);
		int p2 = Integer.parseInt(line[1]);
		
		int m = Integer.parseInt(br.readLine());
		int from, to;
		for(int i=0; i<m; i++) {
			line = br.readLine().split(" ");
			from = Integer.parseInt(line[0]);
			to = Integer.parseInt(line[1]);
			adjMatrix[from][to] = true;
			adjMatrix[to][from] = true;
		}
		
		visited[p1] = true;
		Queue<Node> queue = new LinkedList<>();
		
		queue.offer(new Node(p1, 0));
		
		Node current = null;
		while(!queue.isEmpty()) {
			current = queue.poll();
			
			if(current.idx == p2) {
				break;
			}
			for(int i=1; i<=N;i++) {
				if(adjMatrix[current.idx][i] && !visited[i]) {
					visited[i] = true;
					queue.offer(new Node(i, current.level+1));
				}
			}
		}
		
		if(current.idx == p2) {
			System.out.println(current.level);
		}else {
			System.out.println("-1");
		}
	}
	
	static class Node{
		int idx, level;

		public Node(int idx, int level) {
			this.idx = idx;
			this.level = level;
		}
	}
}
