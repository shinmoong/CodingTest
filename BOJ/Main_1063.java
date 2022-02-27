import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1063 {
	static int[][] deltas = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 1 }, { -1, 1 }, { 1, -1 }, { -1, -1 } };
	// deltas는 {가로, 세로}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		String str = st.nextToken();
		int kingX = str.charAt(0) - 'A' + 1;
		int kingY = str.charAt(1) - '0';

		str = st.nextToken();
		int stoneX = str.charAt(0) - 'A' + 1;
		int stoneY = str.charAt(1) - '0';

		int T = Integer.parseInt(st.nextToken());

		int kingNX, kingNY;
		int stoneNX, stoneNY;
		int[] dir = new int[2];
		for (int t = 0; t < T; t++) {
			dir = getDir(br.readLine());
			kingNX = kingX+dir[0];
			kingNY = kingY+dir[1];
			stoneNX = stoneX+dir[0];
			stoneNY = stoneY+dir[1];
			if(isAvailable(kingNX, kingNY)) {
				if(kingNX == stoneX && kingNY == stoneY) {
					if(isAvailable(stoneNX, stoneNY)) {
						kingX = kingNX;
						kingY = kingNY;
						stoneX = stoneNX;
						stoneY = stoneNY;
					}
				}else {
					kingX = kingNX;
					kingY = kingNY;
				}
			}
		}
		
		System.out.println((char)(kingX+'A'-1)+""+kingY);
		System.out.println((char)(stoneX+'A'-1)+""+stoneY);
	}

	static int[] getDir(String str) {
		switch (str) {
		case "R":
			return deltas[0];
		case "L":
			return deltas[1];
		case "B":
			return deltas[2];
		case "T":
			return deltas[3];
		case "RT":
			return deltas[4];
		case "LT":
			return deltas[5];
		case "RB":
			return deltas[6];
		case "LB":
			return deltas[7];
		default:
			return null;
		}
	}

	static boolean isAvailable(int x, int y) {
		if (x >= 1 && x <= 8 && y >= 1 && y <= 8)
			return true;

		return false;
	}
}
