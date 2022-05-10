import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main_9375 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			HashSet<String> hs = new HashSet<>();
			HashMap<String, Integer> hm = new HashMap<>();
			
			int n = Integer.parseInt(br.readLine());
			for(int i=0; i<n; i++) {
				line = br.readLine().split(" ");
				if(hs.contains(line[1])) {
					hm.put(line[1], hm.get(line[1])+1);
				}else {
					hm.put(line[1], 1);
					hs.add(line[1]);
				}
			}
			
			int ans = 1;
			for(Entry<String, Integer> entry : hm.entrySet()) {
				ans *= (entry.getValue()+1);
			}
			
			System.out.println(ans-1);
		}
	}

}
