import java.util.Scanner;

public class Solution_3499 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			/////////////////////////////////////////////////////////////////////////////////////////////
			int N = sc.nextInt();
			String[] cards = new String[N];
			String[] shuffle = new String[N];

			for (int i = 0; i < N; i++) {
				cards[i] = sc.next();
			}

			for (int i = 0; i < N / 2; i++) {
				shuffle[i*2] = cards[i];
				if (N % 2 == 1)
					shuffle[i * 2 + 1] = cards[i + N / 2 + 1];
				else
					shuffle[i * 2 + 1] = cards[i + N / 2];
			}
			if (N % 2 == 1)
				shuffle[N - 1] = cards[N / 2];
			
			System.out.print("#"+test_case+" ");
			
			for(int i=0; i<N; i++) {
				System.out.print(shuffle[i]+" ");
			}
			System.out.println();
			/////////////////////////////////////////////////////////////////////////////////////////////

		}
	}

}
