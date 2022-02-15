import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2839 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int w3 = 0;
		int w5 = 0;

		while (5 * w5 < N) {
			w5++;
		}
		
		while(true) {
			if(w5 == -1) {
				System.out.println(-1);
				break;
			}
			
			while(3*w3+5*w5<N) {
				w3++;
			}
			
			if(5*w5+3*w3 == N) {
				System.out.println(w5+w3);
				break;
			}
			w5--;
		}
	}

}
