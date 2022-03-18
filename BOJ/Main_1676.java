import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1676 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		int ans=0, cnt2=0, cnt5=0, cur;
		
		for(int i=1; i<=N; i++) {
			cur = i;
			while(cur % 2 == 0) {
					cur /= 2;
					cnt2++;
			}
			while(cur % 5 == 0) {
				cur /= 5;
				cnt5++;
			}
		}
		
		System.out.println(Math.min(cnt2, cnt5));
	}

}
