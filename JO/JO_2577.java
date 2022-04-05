import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_2577 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken()); // 접시 수
		int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		int[] sushiBelt = new int[N]; // 초밥 벨트
		int[] sushiCnt = new int[d+1]; // dp 이용. 현재 위치부터 시작하는 연속 초밥 갯수. i는 몇번째 종류 초밥인지 표시
		int sushiNums = 0; // 연속 선택 안에 든 초밥 가짓수
		int max; // 초밥 가짓수 최대값
		int sum; // sushiNums를 통해 구한 초밥 가짓수에 쿠폰을 고려한 값.
		
		for(int i=0; i<N; i++) {
			sushiBelt[i] = Integer.parseInt(br.readLine());
		}
		for(int i=0; i<k; i++) {
			if(sushiCnt[sushiBelt[i]] == 0) {
				sushiNums++;
			}
			sushiCnt[sushiBelt[i]]++;
		}
		if(sushiCnt[c]== 0) {
			sum = sushiNums+1;
		}else {
			sum = sushiNums;
		}
		max = sum;
		
		int in, out;
		for(int i=1; i<N; i++) {
			in = (i+k-1)%N; // 추가되는 지점
			out = (i-1)%N; // 빠지는 지점
			
			sushiCnt[sushiBelt[out]]--;
			if(sushiCnt[sushiBelt[out]] == 0) {
				sushiNums--;
			}
			
			if(sushiCnt[sushiBelt[in]] == 0) {
				sushiNums++;
			}
			sushiCnt[sushiBelt[in]]++;
			
			if(sushiCnt[c]== 0) {
				sum = sushiNums+1;
			}else {
				sum = sushiNums;
			}
			
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}

}
