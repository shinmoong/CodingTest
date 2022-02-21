import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_1759 {
	static int L, C;
	static char[] arr;
	static char[] num;
	static HashSet<Character> aeiou= new HashSet<Character>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		num = new char[L];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) {
			arr[i] = st.nextToken().charAt(0); 
		}
		Arrays.sort(arr);
		aeiou.add('a');
		aeiou.add('e');
		aeiou.add('i');
		aeiou.add('o');
		aeiou.add('u');
		combination(0,0);
	}
	public static void combination(int cnt, int start) {
		if(cnt == L) {
			int count_aeiou = 0;
			for(int i=0;i<L;i++) {
				if(aeiou.contains(num[i])) {
					count_aeiou++;
				}
			}
			if(1<=count_aeiou && 2<=(L-count_aeiou)) {
				for(int i=0;i<L;i++) {
					System.out.print(num[i]);
				}
				System.out.println();
			}
			return;
		}
		for(int i=start;i<C;i++) {
			num[cnt] = arr[i];
			combination(cnt+1, i+1);
		}
	}

}
