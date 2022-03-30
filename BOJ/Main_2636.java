import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636 {
	static int[][] deltas = {{1, 0},{-1, 0},{0, 1},{0, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R][C];
		boolean[][] visited = new boolean[R][C];
		
		int cheeseCnt = 0; // cheese 총 갯수
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)
					cheeseCnt++;
			}
		}
		
		Queue<Node> bfsQ = new LinkedList<>();
		Queue<Node> tmpQ = new LinkedList<>();
		Node current;
		int nr, nc, level = 0, remain = cheeseCnt;
		while(cheeseCnt != 0) { // while문 마다 bfs
			level++;
			remain = cheeseCnt;
			for(int i=0; i<R; i++) {
				Arrays.fill(visited[i], false); // visited 초기화
			}
			bfsQ.offer(new Node(0, 0));
			visited[0][0] = true;
			while(!bfsQ.isEmpty()) {
				current = bfsQ.poll();
				
				for(int i=0; i<4; i++) {
					nr = current.r+deltas[i][0];
					nc = current.c+deltas[i][1];
					if(nr>=0 && nr<R && nc>=0 && nc<C && !visited[nr][nc]) {
						if(map[nr][nc] == 0) {
							bfsQ.offer(new Node(nr, nc));
							visited[nr][nc] = true;
						} else { // 1인 경우, 즉 공기와 접촉된 경우
							tmpQ.offer(new Node(nr, nc));
							visited[nr][nc] = true;
						}
					}
				}
			}
			
			while(!tmpQ.isEmpty()) {
				current = tmpQ.poll();
				map[current.r][current.c] = 0;
				cheeseCnt--;
			}
		}
		
		System.out.println(level);
		System.out.println(remain);
	}

	static class Node{
		int r, c;
		
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
