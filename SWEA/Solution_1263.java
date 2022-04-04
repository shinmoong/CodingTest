import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1263 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		int N, min, sum;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			int[][] adjMatrix = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					adjMatrix[i][j] = Integer.parseInt(st.nextToken());
					if (i != j && adjMatrix[i][j] == 0) {
						adjMatrix[i][j] = 1000;
					}
				}
			}
			
			for(int k=0; k<N; k++) {
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						adjMatrix[i][j] = Math.min(adjMatrix[i][k]+adjMatrix[k][j],adjMatrix[i][j]);
					}
				}
			}
			
			min = Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				sum = 0;
				for(int j=0; j<N; j++) {
					if(i == j)
						continue;
					sum += adjMatrix[i][j];
				}
				if(sum < min)
					min = sum;
			}
			
			System.out.println("#"+t+" "+min);
		}
	}

}
