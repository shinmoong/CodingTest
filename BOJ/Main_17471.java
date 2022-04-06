import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17471 {
	static int[] population;
	static boolean[][] adjMatrix;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		population = new int[N];
		adjMatrix = new boolean[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}

		int a, x;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			if (a == 0)
				continue;
			for (int j = 0; j < a; j++) {
				x = Integer.parseInt(st.nextToken()) - 1;
				adjMatrix[i][x] = true;
				adjMatrix[x][i] = true;
			}
		}

		int tmp = (int) Math.pow(2, N-1);
		int min = Integer.MAX_VALUE;
		int sum = -1;
		for (int i = 1; i < tmp; i++) {
			if (bfs(i) && bfs((int) Math.pow(2, N) - 1-i)) { // i를 visited로 사용
				sum = getAns(i);
				min = Math.min(sum, min);
			}
		}
		if (sum == -1)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	private static int getAns(int visited) {
		int sumA = 0;
		int sumB = 0;
		for (int i = 0; i < N; i++) {
			if ((visited & (1 << i)) == 0) {
				sumA += population[i];
			} else {
				sumB += population[i];
			}
		}
		return Math.abs(sumA - sumB);
	}

	private static boolean bfs(int visited) {
		int startIdx = 0;
		Queue<Integer> queue = new LinkedList<>();
	
		for (int i = 0; i < N; i++) {
			if ((visited & (1 << i)) == 0) {
				startIdx = i;
				break;
			}
		}

		queue.offer(startIdx);
		visited = (visited | (1 << startIdx));

		int current;
		while (!queue.isEmpty()) {
			current = queue.poll();

			for (int i = 0; i < N; i++) {
				if (adjMatrix[current][i] && (visited & (1 << i)) == 0) {
					queue.offer(i);
					visited = (visited | (1 << i));
				}
			}
		}

		if (visited == (int) Math.pow(2, N) - 1)
			return true;
		else
			return false;
	}
}
