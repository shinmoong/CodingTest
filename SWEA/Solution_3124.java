import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_3124 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st = null;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			ArrayList<Edge>[] adjList = new ArrayList[V];
			for (int i = 0; i < V; i++) {
				adjList[i] = new ArrayList<Edge>();
			}

			boolean[] visited = new boolean[V];

			int a, b, c;
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				a = Integer.parseInt(st.nextToken())-1;
				b = Integer.parseInt(st.nextToken())-1;
				c = Integer.parseInt(st.nextToken());
				adjList[a].add(new Edge(b, c));
				adjList[b].add(new Edge(a, c));
			}

			PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
			pq.offer(new Edge(0, 0));
			long ans = 0;
			int cnt = -1;
			Edge current;
			while (!pq.isEmpty()) {
				current = pq.poll();

				if (visited[current.to])
					continue;

				visited[current.to] = true;
				ans += current.w;
				cnt++;

				if (cnt == V - 1)
					break;

				for (Edge e : adjList[current.to]) {
					if (!visited[e.to])
						pq.offer(e);
				}
			}

			System.out.println("#" + t + " " + ans);
		}
	}

	static class Edge implements Comparable<Edge> {
		int to, w;

		public Edge(int to, int w) {
			this.to = to;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}
}
