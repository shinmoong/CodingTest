import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1753_adjList {
	public static class Node{
		int to, weight;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		List<Node>[] adjList = new LinkedList[V + 1];
		for (int i = 1; i <= V; i++) {
			adjList[i] = new LinkedList<>();
		}

		boolean[] visited = new boolean[V + 1];
		int start = Integer.parseInt(br.readLine());

		int from, to, weight;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			adjList[from].add(0, new Node(to, weight));
		}

		int[] distance = new int[V + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		distance[start] = 0;

		int toWeight;
		for (int i = 1; i <= V; i++) {
			int min = Integer.MAX_VALUE, current = 0;

			for (int j = 1; j <= V; j++) {
				if (!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}

			visited[current] = true;

			if (adjList[current] == null)
				continue;

			for (Node node : adjList[current]) {
				to = node.to;
				toWeight = node.weight;
				if (!visited[to] && distance[to] > distance[current] + toWeight) {
					distance[to] = distance[current] + toWeight;
				}
			}
		}

		for (int i = 1; i <= V; i++) {
			if (distance[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(distance[i]);
		}
	}

}
