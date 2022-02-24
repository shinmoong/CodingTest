import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753_adjList_PQ {
	static class Node {
		int to, weight;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	static class Vertex implements Comparable<Vertex> {
		int no, minDistance;

		public Vertex(int no, int minDistance) {
			this.no = no;
			this.minDistance = minDistance;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.minDistance - o.minDistance;
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
		PriorityQueue<Vertex> pQueue = new PriorityQueue<>();
		pQueue.offer(new Vertex(start, distance[start]));
		int toWeight;
		while(!pQueue.isEmpty()) {
			int min = Integer.MAX_VALUE;

			Vertex current = pQueue.poll();

			if (visited[current.no])
				continue;

			visited[current.no] = true;

			if (adjList[current.no] == null)
				continue;

			for (Node node : adjList[current.no]) {
				to = node.to;
				toWeight = node.weight;
				if (!visited[to] && distance[to] > distance[current.no] + toWeight) {
					distance[to] = distance[current.no] + toWeight;
					pQueue.offer(new Vertex(to, distance[to]));
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
