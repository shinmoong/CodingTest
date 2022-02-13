import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5576 {
	static int[] scores;
	static int max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		scores = new int[10];
		max = 0;
		for(int i=0; i<10; i++) {
			scores[i] = Integer.parseInt(br.readLine());
		}
		Combination(0, 0, 0);
		System.out.print(max+" ");
		max = 0;
		for(int i=0; i<10; i++) {
			scores[i] = Integer.parseInt(br.readLine());
		}
		Combination(0, 0, 0);
		System.out.print(max);
	}
	public static void Combination(int cnt, int start, int sum) {
		if(cnt == 3) {
			if(sum > max) {
				max = sum;
			}
			return;
		}
		
		for(int i=start; i<10; i++) {
			Combination(cnt+1, i+1, sum+scores[i]);
		}
	}
}
