import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5525 {
	static char[] arr;
	static int N, M, startIdx;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		arr = br.readLine().toCharArray();
		int ans = 0;
		if(!getNextI(0)) {
			System.out.println(0);
		}else {
			char lastChar = 'I';
			int pn = 0;
			startIdx++;
			while(startIdx<M) {
				if(lastChar==arr[startIdx]) {
					if(!getNextI(startIdx)) {
						break;
					}else {
						pn=0;
					}
				}else {
					if(arr[startIdx] == 'I') {
						pn++;
						if(pn==N) {
							ans++;
						}else if(pn==N+1) {
							ans++;
							pn--;
						}
					}
				}
				lastChar=arr[startIdx];
				startIdx++;
			}
			
			System.out.println(ans);
		}
	}

	static boolean getNextI(int start) {
		for (int i = start; i < M; i++) {
			if (arr[i] == 'I') {
				startIdx = i;
				return true;
			}
		}
		
		return false;
	}
}
