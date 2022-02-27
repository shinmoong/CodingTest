import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9095 {
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			ans = 0;
			combination(Integer.parseInt(br.readLine()), 0);
			System.out.println(ans);
		}
	}

	static void combination(int num, int sum) {
		if(sum > num)
			return;
		if(sum==num) {
			ans++;
			return;
		}
		for(int i=1; i<=3; i++) {
			combination(num, sum+i);
		}
	}
}
