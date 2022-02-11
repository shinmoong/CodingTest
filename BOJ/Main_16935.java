import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().split(" ");

		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		int R = Integer.parseInt(line[2]);
		int[][] arr = new int[N][M];
		int[][] tmp = new int[N][M];
		int x;

		for (int i = 0; i < N; i++) {
			line = br.readLine().split(" ");

			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		line = br.readLine().split(" ");

		for (int i = 0; i < R; i++) {
			switch (Integer.parseInt(line[i])) {
			case 1:
				for (int r = 0; r < N / 2; r++) {
					for (int c = 0; c < M; c++) {
						tmp[r][c] = arr[N - r - 1][c];
						tmp[N - r - 1][c] = arr[r][c];
					}
				}
				
				for(int j=0; j<N; j++) {
					for(int k=0; k<M; k++) {
						arr[j][k] = tmp[j][k];
					}
				}
				break;
			case 2:
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < M / 2; c++) {
						tmp[r][c] = arr[r][M - c - 1];
						tmp[r][M - c - 1] = arr[r][c];
					}
				}
				
				for(int j=0; j<N; j++) {
					for(int k=0; k<M; k++) {
						arr[j][k] = tmp[j][k];
					}
				}
				break;
			case 3:
				if (M != N) {
					tmp = new int[M][N];
				}
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < M; c++) {
						tmp[c][N - 1 - r] = arr[r][c];
					}
				}
				
				x = M;
				M = N;
				N = x;
				arr = new int[N][M];
				for(int j=0; j<N; j++) {
					for(int k=0; k<M; k++) {
						arr[j][k] = tmp[j][k];
					}
				}
				break;
			case 4:
				if (M != N) {
					tmp = new int[M][N];
				}
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < M; c++) {
						tmp[M - 1 - c][r] = arr[r][c];
					}
				}
				
				x = M;
				M = N;
				N = x;
				arr = new int[N][M];
				for(int j=0; j<N; j++) {
					for(int k=0; k<M; k++) {
						arr[j][k] = tmp[j][k];
					}
				}
				break;
			case 5:
				for(int r=0; r<N/2; r++) {		
					for(int c=0; c<M/2; c++) {
						tmp[r][c+M/2] = arr[r][c]; // 1번
						tmp[r+N/2][c+M/2] = arr[r][c+M/2]; // 2번
						tmp[r+N/2][c] = arr[r+N/2][c+M/2]; // 3번
						tmp[r][c] = arr[r+N/2][c]; // 4번
					}
				}
				
				for(int j=0; j<N; j++) {
					for(int k=0; k<M; k++) {
						arr[j][k] = tmp[j][k];
					}
				}
				break;
			case 6:
				for(int r=0; r<N/2; r++) {		
					for(int c=0; c<M/2; c++) {
						tmp[r+N/2][c] = arr[r][c]; // 1번
						tmp[r][c] = arr[r][c+M/2]; // 2번
						tmp[r][c+M/2] = arr[r+N/2][c+M/2]; // 3번
						tmp[r+N/2][c+M/2] = arr[r+N/2][c]; // 4번
					}
				}
				
				for(int j=0; j<N; j++) {
					for(int k=0; k<M; k++) {
						arr[j][k] = tmp[j][k];
					}
				}
				break;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}
