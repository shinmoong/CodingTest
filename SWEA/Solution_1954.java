import java.util.Scanner;

public class Solution_1954 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			////////////////
			int N = sc.nextInt();
			int[][] snail = new int[N][N];
			int count = 1;
			
			for(int i=0; i<N/2; i++) {
				for(int j=0; j<=N-2-2*i; j++) {
					snail[i][i+j] = count;
					snail[i+j][N-1-i] = count+N-1-2*i;
					snail[N-1-i][N-1-i-j] = count+2*(N-1-2*i);
					snail[N-1-i-j][i] = count+3*(N-1-2*i);
					count++;
				}
				
				count = count+3*(N-1-2*i);
			}
			if(N%2 == 1) {
				snail[N/2][N/2] = count;
			}
			
			System.out.println("#"+test_case);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(snail[i][j]+" ");
				}
				System.out.println();
			}
			////////////////
		}
	}

}
