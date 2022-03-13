import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_11279 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int num;
		for(int i=0; i<N; i++) {
			num = Integer.parseInt(br.readLine());
			
			if(num==0) {
				if(pq.isEmpty()) {
					System.out.println(0);
				}else {
					System.out.println(pq.poll());
				}
			}else {
				pq.offer(num);
			}
		}
	}

}
