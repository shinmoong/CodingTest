import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17144 {

	public static int R, C, T;
	public static int[][] map;
	public static int[] air = new int[2];
	public static int[][] dxdy = {{1,0}, {0,-1}, {-1,0}, {0,1}};
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C  = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		int idx = 0;
		for(int i = 0 ; i< R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j< C ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					air[idx++] = i;
				}
			}
		}
		
		for(int i =0; i< T; i++) {
			diffuse();
			clean();
		}
		int sum = 0;
		for(int i = 0 ; i< R; i++) {
			for(int j =0  ; j< C; j++) {
				sum += map[i][j];
			}
		}
		
		System.out.println(sum+2);

	}
	
	public static void diffuse() {
		
		int[][] temp = new int[R][C];
		for(int i =0; i< R; i++) {
			for(int j = 0; j< C; j++) {
				int amount = map[i][j] / 5;
				if(map[i][j] != 0 && map[i][j] != -1) {
					for(int k = 0; k < 4; k++) {
						int nr = i + dxdy[k][0];
						int nc = j + dxdy[k][1];
						if(nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != -1) {
							temp[nr][nc] += amount;
							map[i][j] -= amount;
						}
						
					}
				}
			}
		}
		
		for(int i =0; i< R; i++) {
			for(int j = 0; j< C; j++) {
				map[i][j] += temp[i][j];
			}
		}
		
	}
	
	private static void clean() {
		for(int r = air[0]-1; r >= 0 ; r--) {
			map[r+1][0] = map[r][0];
		}
		for(int c = 1 ; c < C; c++) {
			map[0][c-1] = map[0][c];
		}
		for(int r = 0; r < air[0] ; r++) {
			map[r][C-1] = map[r+1][C-1];
		}
		for(int c = C-1 ; c > 1; c--) {
			map[air[0]][c] = map[air[0]][c-1];
		}
		map[air[0]][1] = 0;
		map[air[0]][0] = -1;

		for(int r = air[1]; r < R-1 ; r++) {
			map[r][0] = map[r+1][0];
		}
		
		for(int c = 0 ; c < C-1; c++) {
			map[R-1][c] = map[R-1][c+1];
		}
		
		for(int r = R-1; r > air[1] ; r--) {
			map[r][C-1] = map[r-1][C-1];
		}
		
		for(int c = C-1 ; c > 1; c--) {
			map[air[1]][c] = map[air[1]][c-1];
		}
		map[air[1]][1] = 0;
		map[air[1]][0] = -1;
	}

}


