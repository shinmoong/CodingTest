import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1225 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int tc = sc.nextInt();
			Queue<Integer> q = new LinkedList<>();
			
			for(int i=0; i<8; i++) {
				q.offer(sc.nextInt());
			}
			int cnt = 1;
			while(true) {
				int num = q.poll()-cnt++;
				if(cnt == 6) {
					cnt = 1;
				}
				if(num <= 0) {
					num = 0;
					q.offer(num);
					break;
				}
				else {
					q.offer(num);
				}
			}
			System.out.print("#"+tc+" ");
			for(int i=0; i<8; i++) {
				System.out.print(q.poll()+" ");
			}
			System.out.println();
		}
	}

}
