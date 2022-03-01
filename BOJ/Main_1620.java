import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_1620 {

	public static void main(String[] args) throws IOException {
		HashMap<String, Integer> nameMap = new HashMap<String, Integer>();
		HashMap<Integer, String> numMap = new HashMap<Integer, String>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String name;
		for(int i=1; i<=N; i++) {
			name = br.readLine();
			nameMap.put(name, i);
			numMap.put(i, name);
		}
		
		int num;
		for(int i=0; i<M; i++) {
			name = br.readLine();
			if(isNum(name)) {
				System.out.println(numMap.get(Integer.valueOf(name)));
			}else {
				System.out.println(nameMap.get(name));
			}
		}
	}

	static boolean isNum(String str) {
		try {
			Integer.valueOf(str);
		} catch(NumberFormatException e) {
			return false;
		}
		
		return true;
	}
}
