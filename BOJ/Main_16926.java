import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926 {
	static int N, M, R;
	static int[][] map, board;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		board = new int[N][M];
		for(int i = 0; i< N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j< M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 원본 배열
		
		for(int rcnt = 0; rcnt < Math.min(N, M)/2 ; rcnt++) { //큰배열, 작은 배열 --- 갯수
			search(N-2*rcnt, M-2*rcnt, rcnt);
		}
		
		for(int i = 0; i< N; i++) {
			for(int j = 0;j<M; j++) {
				System.out.print(board[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
	public static void search(int n, int m, int rstart) { // n x m rstart  배열 시작점
		int rotate = R % ((n-1+m-1)*2); // 돌아야 될 횟수
		int b_delta = 0; //delta % 4
		int [][] dxdy = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // 반시계 방향
		int b_nx = rstart, b_ny = rstart;
		
		int n_delta = 0;
		int n_nx = rstart, n_ny = rstart;
		
		for(int i = 0; i < rotate; i++) {
			b_nx = b_nx + dxdy[b_delta][0];
			b_ny = b_ny + dxdy[b_delta][1];	
			if(( b_nx == rstart && b_ny == (rstart+m-1) ) || (b_nx == (rstart) && b_ny == rstart) || 
					(b_nx == (rstart+n-1) && b_ny == rstart+m-1) || (b_nx == rstart+n-1 && b_ny == (rstart))) { // 꼭짓점일 때
				b_delta = (b_delta+1)%4;
			}
		}
		board[b_nx][b_ny] = map[rstart][rstart]; //2,0   0,0 
		
		for(int i = 0 ; i < ((n-1+m-1)*2)-1; i++) {
			
			b_nx = b_nx + dxdy[b_delta][0];
			b_ny = b_ny + dxdy[b_delta][1];	
			if(( b_nx == rstart && b_ny == (rstart+m-1) ) || (b_nx == rstart && b_ny == rstart) || 
					(b_nx == (rstart+n-1) && b_ny == rstart+m-1) || (b_nx == rstart+n-1 && b_ny == (rstart))) { // 꼭짓점일 때
				b_delta = (b_delta+1)%4;
			}
			n_nx = n_nx + dxdy[n_delta][0];
			n_ny = n_ny + dxdy[n_delta][1];	
			if(( n_nx == rstart && n_ny == (rstart+m-1) ) || (n_nx == rstart && n_ny == rstart) || 
					(n_nx == (rstart+n-1) && n_ny == rstart+m-1) || (n_nx == rstart+n-1 && n_ny == (rstart))) { // 꼭짓점일 때
				n_delta = (n_delta+1)%4;
			}
			board[b_nx][b_ny] = map[n_nx][n_ny];
		}
		
	}

}



