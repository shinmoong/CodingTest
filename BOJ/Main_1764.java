import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1764 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		HashSet<String> nameSet = new HashSet<>();
		
		for(int i=0; i<N; i++) {
			nameSet.add(br.readLine());
		}
		
		PriorityQueue<String> pq = new PriorityQueue<>();
		int cnt=0;
		String tmp;
		for(int i=0; i<M; i++) {
			tmp = br.readLine();
			if(nameSet.contains(tmp)) {
				cnt++;
				pq.offer(tmp);
			}
		}
		
		System.out.println(cnt);
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}

}
