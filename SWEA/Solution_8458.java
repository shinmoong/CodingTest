import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8458 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		boolean isOE, canMove;
		int max, tmp, cnt, tmp2;
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			max = 0;
			canMove = true;
			st = new StringTokenizer(br.readLine(), " ");
			max = Math.abs(Integer.parseInt(st.nextToken())) + Math.abs(Integer.parseInt(st.nextToken()));
			if (max % 2 == 1) // 홀 : false, 짝 : true
				isOE = false;
			else
				isOE = true;
			for (int i = 1; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				tmp = Math.abs(Integer.parseInt(st.nextToken())) + Math.abs(Integer.parseInt(st.nextToken()));
				max = Math.max(tmp, max);
				if ((tmp % 2 == 1 && isOE) || (tmp % 2 == 0 && !isOE)) {
					canMove = false;
				}
			}

			if (!canMove) {
				System.out.println("#" + t + " " + -1);
			} else {
				cnt = 0;
				tmp = 0;
				while(true) {
					tmp += cnt;
					if(tmp >= max && ((tmp%2 == 0) == isOE))
						break;
					cnt++;
				}
				System.out.println("#" + t + " " + cnt);
			}
		}
	}

}
