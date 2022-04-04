import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_5658 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		int N, K, idx, tmpN, sum;
		char tmpC;
		char[] nums;
		String ans16 = null;
		
		HashSet<String> hs = new HashSet<>();
		PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			nums = new char[N];
			nums = br.readLine().toCharArray();
			
			hs.clear();
			pq.clear();
			for(int i=0; i<N/4; i++) {
				idx = i;
				for(int j=0; j<4; j++) {
					sb.setLength(0);
					for(int k=0; k<N/4; k++) {
						sb.append(nums[idx]);
						idx = (idx+1)%N;
					}
					if(!hs.contains(sb.toString())) {
						hs.add(sb.toString());
						pq.offer(sb.toString());
					}
				}
			}
			
			for(int i=0; i<K; i++) {
				ans16 = pq.poll();
			}
			
			sum = 0;
			for(int i=0; i<N/4; i++) {
				tmpC = ans16.charAt(i);
				if(tmpC >= 'A' && tmpC <= 'F') {
					tmpN = tmpC-'A'+10;
				}else {
					tmpN = tmpC-'0';
				}
				sum = sum*16+tmpN;
			}
			
			System.out.println("#"+t+" "+sum);
		}
	}

}
