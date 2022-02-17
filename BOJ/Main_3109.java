import java.util.*;
import java.io.*;

public class Main_3109 {
	static int R, C;
	static int r[];
	static char map[][];
	static int sum;
	static boolean trues[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][];
		r = new int[C];
		trues = new boolean[R];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// (-1,1) (0,1) (1,1)
		for(int i=0; i<R; i++) {
			r[0] = i;
			map[i][0] = 'x';
			dfs(1);
		}
		
		System.out.println(sum);
	}

	static void dfs(int colNo) {
		// x 거나 배열 밖이면 안됨.
		
		if (colNo >= C) {
			sum++;
			trues[r[0]] = true;
			/*
			 * for (int i = 0; i < C; i++) { map[r[i]][i] = 'x'; }
			 */
			return;
		}
		for (int i = -1; i < 2; i++) {
			r[colNo] = r[colNo-1]+i;
			if(r[colNo]<0 || r[colNo] >= R)
				continue;
			if (isAvailable(colNo) && !trues[r[0]]) {
				map[r[colNo]][colNo] = 'x';
				dfs(colNo + 1);
			}
		}
	}

// 현재까지 가능한 colNo는 colNo-1
	static boolean isAvailable(int colNo) {
		if (colNo <= 0)
			return true;
		if (map[r[colNo]][colNo] != 'x')
			return true;

		return false;
	}
}
