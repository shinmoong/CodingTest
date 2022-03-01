import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		System.out.println(bfs(N, K));
	}

	static int bfs(int N, int K) {
		Queue<Node> queue = new LinkedList<Node>();
		boolean[] visited = new boolean[100001];

		queue.offer(new Node(N, 0));
		visited[N] = true;

		Node current;
		while (!queue.isEmpty()) {
			current = queue.poll();

			if (current.x == K) {
				return current.depth;
			}
			if (current.x - 1 >= 0 && !visited[current.x - 1]) {
				visited[current.x - 1] = true;
				queue.offer(new Node(current.x - 1, current.depth + 1));
			}
			if (current.x + 1 <= 100000 && !visited[current.x + 1]) {
				visited[current.x + 1] = true;
				queue.offer(new Node(current.x + 1, current.depth + 1));
			}
			if (current.x * 2 <= 100000 && !visited[current.x * 2]) {
				visited[current.x * 2] = true;
				queue.offer(new Node(current.x * 2, current.depth + 1));
			}
		}
		
		return -1;
	}

	static class Node {
		int x, depth;

		public Node(int x, int depth) {
			this.x = x;
			this.depth = depth;
		}
	}
}
