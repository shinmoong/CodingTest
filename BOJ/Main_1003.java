import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1003 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] fibos = new int[41];
		fibos[1] = 1;
		
		for(int i=2; i<41; i++) {
			fibos[i] = fibos[i-1]+fibos[i-2];
		}
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				sb.append("1 0\n");
			}else {
				sb.append(fibos[num-1]+" "+fibos[num]+"\n");
			}
		}
		System.out.print(sb);
	}

}