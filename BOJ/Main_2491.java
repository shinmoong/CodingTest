import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2491 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] sequence = new int[N][2];
		int[] nums = new int[N];
		boolean up = false; // 수열 증가중이면 true, 아니면 false
		String[] line = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(line[i]);
		}

		sequence[0][0] = 1; // 수열 만족하는 갯수
		sequence[0][1] = 0; // 같은 갯수

		for (int i = 1; i < N; i++) {
			if (nums[0] < nums[i]) {
				up = true;
				break;
			}
			if (nums[0] > nums[i]) {
				break;
			}
		}

		int max = 0; // 최고 길이 수열 구하는 변수
		for (int i = 1; i < N; i++) {
			if (nums[i - 1] == nums[i]) {
				sequence[i][0] = sequence[i - 1][0] + 1;
				if (sequence[i-1][1] == 0) // 연속 숫자가 처음 나왔으면
					sequence[i][1] = 2;
				else // 연속 숫자가 이어서 나오는 중이면
					sequence[i][1] = sequence[i - 1][1] + 1;
			} else if (nums[i - 1] < nums[i]) {
				if (up) { // 계속 증가중이었으면
					sequence[i][0] = sequence[i - 1][0] + 1;
					sequence[i][1] = 0;
				} else { // 감소하다 증가하는 거면
					up = true;
					max = Math.max(max, sequence[i - 1][0]);
					sequence[i][0] = sequence[i - 1][1] + 1;
					sequence[i][1] = 0;
					if(nums[i-2] > nums[i-1])
						sequence[i][0] = 2;
				}
			} else { // nums[i - 1] > nums[i]

				if (!up) { // 계속 감소중이었으면
					sequence[i][0] = sequence[i - 1][0] + 1;
					sequence[i][1] = 0;
				} else { // 증가하다 감소하는 거면
					up = false;
					max = Math.max(max, sequence[i - 1][0]);
					sequence[i][0] = sequence[i - 1][1] + 1;
					sequence[i][1] = 0;
					if(nums[i-2] < nums[i-1])
						sequence[i][0] = 2;
				}
			}
		}
		max = Math.max(max, sequence[N - 1][0]);
		System.out.println(max);
	}

}
