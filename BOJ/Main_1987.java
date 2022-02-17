import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1987 {
	static int R, C, max;
	static char[][] board;
	static boolean[][] isVisited;
	static boolean[] isUsed;
	static int[][] deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().split(" ");

		R = Integer.parseInt(line[0]);
		C = Integer.parseInt(line[1]);

		board = new char[R][];
		isVisited = new boolean[R][C];
		isUsed = new boolean[26]; // 알파벳 갯수 26개, index : 나온 알파벳 - 'A'
									// 이 알파벳이 사용됐으면 true
		
		for(int i=0; i<R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		dfs(0, 0, 1);
		
		System.out.println(max);
	}

	public static void dfs(int r, int c, int cnt) {
		isVisited[r][c] = true;
		isUsed[board[r][c]-'A'] = true;
		
		boolean flag = false;
		
		for(int[] delta : deltas) {
			int nr = r+delta[0];
			int nc = c+delta[1];
			
			if(isAvailable(nr, nc)) {
				dfs(nr, nc, cnt+1);
				flag = true;
			}
		}
		
		if(!flag)
			max = Math.max(max, cnt);
		
		isVisited[r][c] = false;
		isUsed[board[r][c]-'A'] = false;
	}

	public static boolean isAvailable(int r, int c) {
		if (r >= 0 && r < R && c >= 0 && c < C && !isVisited[r][c] && !isUsed[board[r][c]-'A'])
			return true;

		return false;
	}
}
