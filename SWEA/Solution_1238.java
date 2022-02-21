import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1238 {
	static int max, curLevel;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10, M, V, from, to;
		boolean[][] adjMatrix = new boolean[101][101];
		String[] line;
		for (int test_case = 1; test_case <= T; test_case++) {
			line = br.readLine().split(" ");
			M = Integer.parseInt(line[0]);
			V = Integer.parseInt(line[1]);

			for (int i = 1; i <= 100; i++) {
				Arrays.fill(adjMatrix[i], false);
			}

			line = br.readLine().split(" ");

			for (int i = 0; i < M / 2; i++) {
				from = Integer.parseInt(line[2 * i]);
				to = Integer.parseInt(line[2 * i + 1]);

				adjMatrix[from][to] = true;
			}

			max = curLevel = 0;

			bfs(adjMatrix, V);
			System.out.println("#"+test_case+" "+max);
		}
	}

	public static void bfs(boolean[][] adjMatrix, int start) {
		boolean[] visited = new boolean[101];
		visited[start] = true;
		Queue<Element> queue = new LinkedList<>();

		queue.offer(new Element(start, 1));

		while (!queue.isEmpty()) {
			Element current = queue.poll();
			if (current.level > curLevel) {
				curLevel = current.level;
				max = current.index;
			} else if (current.level == curLevel) {
				max = Math.max(current.index, max);
			}

			for (int i = 1; i <= 100; i++) {
				if (!visited[i] && adjMatrix[current.index][i]) {
					queue.offer(new Element(i, current.level + 1));
					visited[i] = true;
				}
					
			}
		}
	}

	static class Element {
		int index;
		int level;

		public Element(int index, int level) {
			this.index = index;
			this.level = level;
		}
	}
}
