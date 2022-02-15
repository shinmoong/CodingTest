import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1005 {
	static boolean[][] graph;
	static boolean[] isVisited;
	static int[] buildTime, ansTime;
	static Stack<Integer> stack;
	static int N, K, W;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line;
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 0; test_case < T; test_case++) {
			line = br.readLine().split(" ");
			N = Integer.parseInt(line[0]); // N : 건물의 개수
			K = Integer.parseInt(line[1]); // K : 건물간의 건설순서 규칙 개수

			graph = new boolean[N + 1][N + 1]; // 간선 표시 인덱스 1부터
			isVisited = new boolean[N + 1]; // 방문 표시
			buildTime = new int[N + 1]; // 건물 건설 시간
			ansTime = new int[N + 1]; // 정답 저장할 배열
			stack = new Stack<>(); // 위상 정렬 저장 스택

			line = br.readLine().split(" ");
			for (int i = 1; i <= N; i++) {
				buildTime[i] = Integer.parseInt(line[i - 1]);
			}

			for (int i = 0; i < K; i++) {
				line = br.readLine().split(" ");
				graph[Integer.parseInt(line[0])][Integer.parseInt(line[1])] = true;
			}

			topologicalSort();
			getBuildTimes();

			W = Integer.parseInt(br.readLine());
			System.out.println(ansTime[W]);
		}
	}

	public static void topologicalSort() {
		for (int i = 1; i <= N; i++) {
			if (!isVisited[i]) {
				DFS(i);
			}
		}

	}

	public static void DFS(int node) {
		isVisited[node] = true;

		for (int i = 1; i <= N; i++) {
			if(graph[node][i]) {
				graph[i][0] = true; // 자신한테 오는 게 있으면 true
			}
			if (!isVisited[i] && graph[node][i]) {
				DFS(i);
			}
		}

		stack.push(node);
	}

	public static void getBuildTimes() {
		int node;

		while (!stack.isEmpty()) {
			node = stack.pop();
			if (!graph[node][0]) {// 자신한테 오는 것이 없다.
				ansTime[node] = buildTime[node];
			} else {
				for (int i = 1; i <= N; i++) {
					if (graph[i][node])
						ansTime[node] = Math.max(ansTime[node], buildTime[node] + ansTime[i]);
				}
			}
		}
	}
}
