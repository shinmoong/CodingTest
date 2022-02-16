import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_6808 {
	static int[] kyuCards = new int[9];
	static int[] inCards = new int[9];
	static boolean[] isSelected = new boolean[19];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		String[] line;
		for (int test_case = 1; test_case <= T; test_case++) {
			Arrays.fill(isSelected, false);
			line = br.readLine().split(" ");

			for (int i = 0; i < 9; i++) {
				kyuCards[i] = Integer.parseInt(line[i]);
				isSelected[kyuCards[i]] = true;
			}
			
			int cnt = 0;
			for(int i=1; i<=18; i++) {
				if(!isSelected[i]) {
					inCards[cnt] = i;
					cnt++;
				}
			}
			
			int win = 0;
			int lose = 0;
			int kyuScore, inScore;
			
			do {
				kyuScore = 0;
				inScore = 0;
				for(int i=0; i<9; i++) {
					if(kyuCards[i] > inCards[i]) {
						kyuScore += (kyuCards[i]+inCards[i]);
					}
					else {
						inScore += (kyuCards[i]+inCards[i]);
					}
				}
				if(kyuScore < inScore){
					lose++;
				}
				if(kyuScore > inScore){
					win++;
				}
			}while(nextPermutation());
			
			System.out.println("#"+test_case+" "+win+" "+lose);
		}
	}
	
	public static boolean nextPermutation() {
		int i=8;
		while(i>0 && inCards[i-1] >= inCards[i]) {
			i--;
		}
		
		if(i==0)
			return false;
		
		int j=8;
		
		while(inCards[i-1] >= inCards[j]) {
			j--;
		}
		
		swap(i-1, j);
		
		int k = 8;
		while(i < k) {
			swap(i++, k--);
		}
		
		return true;
	}

	public static void swap(int i, int j) {
		int tmp = inCards[i];
		inCards[i] = inCards[j];
		inCards[j] = tmp;
	}
}
