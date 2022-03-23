import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1107 {
	static boolean[] buttons; // 0~9번 버튼
	static int N; // 채널 N
	static int ans; // 최소 클릭 수
	static int clickNum; // 숫자 누르는 횟수

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		buttons = new boolean[10];
		Arrays.fill(buttons, true);
		N = Integer.parseInt(br.readLine());
		int digit = 1;
		int digitNum = 1;
		if (N != 0) {
			while (true) {
				if (N / digitNum != 0 && N / (digitNum * 10) == 0) {
					break;
				}
				digit++;
				digitNum*=10;
			}
		}
		int M = Integer.parseInt(br.readLine());

		if (M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				buttons[Integer.parseInt(st.nextToken())] = false;
			}
		}

		ans = Math.abs(N - 100);
		// 여기서 N 자릿수에 따라 수행 -1~+1자릿수?

		for (int i = Math.max(digit - 1, 1); i <= digit + 1; i++) {
			clickNum = i;
			getAns(0, 0);
		}
		
		System.out.println(ans);
	}

	static void getAns(int cnt, int num) {
		if (cnt == clickNum) {
			int tmp = Math.abs(num - N) + cnt;
			ans = Math.min(tmp, ans);
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (buttons[i])
				getAns(cnt + 1, 10 * num + i);
		}
	}
}
