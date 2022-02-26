import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14696 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		
		int a, b;
		int[] inputA = new int[5]; 
		int[] inputB = new int[5];
		
		for(int t=0; t<N; t++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			Arrays.fill(inputA, 0);
			Arrays.fill(inputB, 0);
			for(int i=0; i<a; i++) {
				inputA[Integer.parseInt(st.nextToken())]++;
			}
			st = new StringTokenizer(br.readLine()," ");
			b = Integer.parseInt(st.nextToken());
			for(int i=0; i<b; i++) {
				inputB[Integer.parseInt(st.nextToken())]++;
			}
			
			if(inputA[4]==inputB[4]) {
				if(inputA[3]==inputB[3]) {
					if(inputA[2]==inputB[2]) {
						if(inputA[1]==inputB[1]) {
							System.out.println("D");
						}
						else {
							if(inputA[1]>inputB[1])
								System.out.println("A");
							else
								System.out.println("B");
						}
					}
					else {
						if(inputA[2]>inputB[2])
							System.out.println("A");
						else
							System.out.println("B");
					}
				}
				else {
					if(inputA[3]>inputB[3])
						System.out.println("A");
					else
						System.out.println("B");
				}
			}else {
				if(inputA[4]>inputB[4])
					System.out.println("A");
				else
					System.out.println("B");
			}
		}
		
	}

}
