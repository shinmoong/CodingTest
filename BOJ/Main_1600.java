import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600 {
	static int[][] deltas = {{1, 0},{-1, 0},{0, 1},{0, -1}};
	static int[][] knightDeltas = {{-1, -2},{-2, -1},{-2, 1},{-1, 2}, {1, 2},{2, 1},{2, -1},{1, -2}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine()); // 나이트처럼 움직일 수 있는 횟수
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int W = Integer.parseInt(st.nextToken()); // 가로길이
		int H = Integer.parseInt(st.nextToken()); // 세로길이
		
		int[][] map = new int[H][W];
		boolean[][][] visitedKnight = new boolean[H][W][31]; // knight 이동 횟수에 따른 분류
		
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(new Node(0, 0, 0, 0));
		visitedKnight[0][0][0] = true;
		
		Node current = null;
		while(!queue.isEmpty()) {
			current = queue.poll();
			
			if(current.r == H-1 && current.c == W-1)
				break;
			
			for(int i=0; i<4; i++) {
				int nr = current.r+deltas[i][0];
				int nc = current.c+deltas[i][1];
				
				if(nr>=0 && nr<H && nc>=0 && nc<W && map[nr][nc] == 0 && !visitedKnight[nr][nc][current.knightCnt]) {
					queue.offer(new Node(nr, nc, current.level+1, current.knightCnt));
					visitedKnight[nr][nc][current.knightCnt] = true;
				}
			}
			
			if(current.knightCnt == K) {
				continue;
			}
			
			for(int i=0; i<8; i++) {
				int nr = current.r+knightDeltas[i][0];
				int nc = current.c+knightDeltas[i][1];
				
				if(nr>=0 && nr<H && nc>=0 && nc<W && map[nr][nc] == 0 && !visitedKnight[nr][nc][current.knightCnt+1]) {
					queue.offer(new Node(nr, nc, current.level+1, current.knightCnt+1));
					visitedKnight[nr][nc][current.knightCnt+1] = true;
				}
			}
		}
		
		if(current.r == H-1 && current.c == W-1)
			System.out.println(current.level);
		else
			System.out.println(-1);
	}

	static class Node{
		int r, c, level, knightCnt;

		public Node(int r, int c, int level, int knightCnt) {
			this.r = r;
			this.c = c;
			this.level = level;
			this.knightCnt = knightCnt;
		}
	}
}
