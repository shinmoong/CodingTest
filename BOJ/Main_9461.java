import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9461 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		long[] arr = new long[101];
		arr[0] = arr[1] = arr[2] = 1;
		arr[3] = arr[4] = 2;
		arr[5] = 3;
		arr[6] = 4;
		arr[7] = 5; 
		arr[8] = 7; 
		arr[9] = 9;
		for(int i=10; i<=100; i++) {
			arr[i] = arr[i-1] + arr[i-5];
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			System.out.println(arr[Integer.parseInt(br.readLine())-1]);
		}
	}

}
