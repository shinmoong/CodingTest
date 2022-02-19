import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2564 {

	public static void main(String[] args) throws IOException {
		int[] storeDir;
		int[][] storePos;
		int R, C, dongDir;
		int[] dongPos = new int[2];
		int ans = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().split(" ");

		C = Integer.parseInt(line[0]);
		R = Integer.parseInt(line[1]);

		int T = Integer.parseInt(br.readLine());
		storeDir = new int[T];
		storePos = new int[T][2];
		for (int i = 0; i < T; i++) {
			line = br.readLine().split(" ");
			storeDir[i] = Integer.parseInt(line[0]);
			switch (storeDir[i]) {
			case 1:
				storePos[i][0] = 0;
				storePos[i][1] = Integer.parseInt(line[1]);
				break;
			case 2:
				storePos[i][0] = R;
				storePos[i][1] = Integer.parseInt(line[1]);
				break;
			case 3:
				storePos[i][0] = Integer.parseInt(line[1]);
				storePos[i][1] = 0;
				break;
			case 4:
				storePos[i][0] = Integer.parseInt(line[1]);
				storePos[i][1] = C;
				break;
			}
		}

		line = br.readLine().split(" ");
		dongDir = Integer.parseInt(line[0]);
		switch (dongDir) {
		case 1:
			dongPos[0] = 0;
			dongPos[1] = Integer.parseInt(line[1]);
			break;
		case 2:
			dongPos[0] = R;
			dongPos[1] = Integer.parseInt(line[1]);
			break;
		case 3:
			dongPos[0] = Integer.parseInt(line[1]);
			dongPos[1] = 0;
			break;
		case 4:
			dongPos[0] = Integer.parseInt(line[1]);
			dongPos[1] = C;
			break;
		}

		for (int i = 0; i < T; i++) {
			if (storeDir[i] == dongDir) // 같은 위치
				ans += Math.max(Math.abs(storePos[i][0] - dongPos[0]), Math.abs(storePos[i][1] - dongPos[1]));
			else if (Math.abs(storePos[i][0] - dongPos[0]) == R) // 위 아래
				ans += (R + Math.min(storePos[i][1] + dongPos[1], 2 * C - (storePos[i][1] + dongPos[1])));
			else if (Math.abs(storePos[i][1] - dongPos[1]) == C) // 오 왼
				ans += (C + Math.min(storePos[i][0] + dongPos[0], 2 * R - (storePos[i][0] + dongPos[0])));
			else
				ans += (Math.abs(storePos[i][0] - dongPos[0]) + Math.abs(storePos[i][1] - dongPos[1]));
		}
		
		System.out.println(ans);
	}

}
