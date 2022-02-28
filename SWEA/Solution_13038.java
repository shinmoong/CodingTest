import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_13038 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		int n, min;
		int[] week = new int[7];
		StringTokenizer st;
		for(int test_case=1; test_case<=TC; test_case++) {
			n = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<7; i++) {
				week[i] = Integer.parseInt(st.nextToken());
			}
			
			min = Integer.MAX_VALUE;
			
			for(int start=0; start<7; start++) { //시작점
				int day = start, cnt = 0;
				while(true) {
					if(week[day%7]==1) cnt++;
					
					if(cnt==n) {
						break;
					}
					
					++day;
				}
				
				min = Math.min(min, day-start+1);
			}
			System.out.println("#"+test_case+" "+min);
		}
	}

}
