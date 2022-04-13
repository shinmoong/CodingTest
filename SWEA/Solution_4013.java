import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_4013 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		int K, cnt, startIdx, ans;
		boolean startRotate;
		boolean[] rotateDir = new boolean[5];
		int[] isConnected = new int[5];

		for (int t = 1; t <= T; t++) {
			ans = 0;
			K = Integer.parseInt(br.readLine());
			Deque<Boolean>[] board = new Deque[5];
			for (int i = 1; i <= 4; i++) {
				board[i] = new LinkedList<Boolean>();
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 8; j++) {
					if (st.nextToken().charAt(0) == '0') {
						board[i].offerLast(false);
					} else {
						board[i].offerLast(true);
					}
				}
			}

			for (int x = 0; x < K; x++) {
				st = new StringTokenizer(br.readLine(), " ");
				startIdx = Integer.parseInt(st.nextToken());
				if (Integer.parseInt(st.nextToken()) == 1) {
					startRotate = true;
				} else {
					startRotate = false;
				}
				isConnected[1] = 0;
				cnt = 0;
				for (int i = 1; i <= 4; i++) {
					if (Math.abs(startIdx - i) % 2 == 0) {
						rotateDir[i] = startRotate;
					}else {
						rotateDir[i] = (!startRotate);
					}
				}
				for (int i = 1; i <= 3; i++) {
					if ((boolean) ((LinkedList) board[i]).get(2) ^ (boolean) ((LinkedList) board[i + 1]).get(6)) {
						isConnected[i + 1] = cnt;
					} else {
						isConnected[i + 1] = ++cnt;
					}
				}
				for (int i = 1; i <= 4; i++) {
					if (isConnected[i] == isConnected[startIdx]) {
						if(rotateDir[i]) {
							board[i].offerFirst(board[i].pollLast());
						}else {
							board[i].offerLast(board[i].pollFirst());
						}
					}
				}
			}
			
			for(int i=1; i<=4; i++) {
				if((boolean) ((LinkedList) board[i]).get(0))
					ans += Math.pow(2, i-1);
			}
			System.out.println("#"+t+" "+ans);
		}

	}

}
