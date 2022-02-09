import java.util.Scanner;

public class Solution_9229 {
	public static int N, M, max;
	public static int[] weights;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			max = -1;
			weights = new int[N];
			for (int i = 0; i < N; i++) {
				weights[i] = sc.nextInt();
			}
			
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					if(weights[i]+weights[j] > max&& weights[i]+weights[j] <= M) {
						max = weights[i]+weights[j];
					}
				}
			}
			System.out.println("#" + test_case + " " + max);
		}
	}
}