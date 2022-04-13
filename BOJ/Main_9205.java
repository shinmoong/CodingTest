import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9205 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		int n, current;
		boolean[][] adjMatrix;
		Point[] place;
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			adjMatrix = new boolean[n + 2][n + 2];
			place = new Point[n + 2];
			for (int i = 0; i < n + 2; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				place[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			for (int i = 0; i < n + 2; i++) {
				for (int j = i+1; j < n + 2; j++) {
					if(Math.abs(place[i].x-place[j].x)+Math.abs(place[i].y-place[j].y)<=1000) {
						adjMatrix[i][j] = true;
						adjMatrix[j][i] = true;
					}
				}
			}
			
			Queue<Integer> queue = new LinkedList<Integer>();
			boolean[] visited = new boolean[n+2];
			queue.offer(0);
			while(!queue.isEmpty()) {
				current = queue.poll();
				for(int i=0; i<n+2; i++) {
					if(adjMatrix[current][i] && !visited[i]) {
						visited[i] = true;
						queue.offer(i);
					}
				}
			}
			
			if(visited[n+1])
				System.out.println("happy");
			else
				System.out.println("sad");
		}
	}

}
