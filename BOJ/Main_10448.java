import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10448 {
	static int[] list;
	static boolean flag;
	static int num;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		list = new int[44]; // 삼각수 list
		list[0] = 1;
		for (int i = 1; i < 44; i++) {
			list[i] = list[i - 1] + i + 1;
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			num=Integer.parseInt(br.readLine());
			flag = false;
			combination(0, 0);
			if(flag)
				System.out.println(1);
			else
				System.out.println(0);
		}
	}

	static void combination(int cnt, int sum) {
		if(cnt==3) {
			if(sum==num)
				flag = true;
			return;
		}
		for(int i=0; i<44; i++) {
			combination(cnt+1, sum+list[i]);
		}
	}
}
