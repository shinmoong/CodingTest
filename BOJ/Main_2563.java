import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2563 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int bN = 10, wN = 100;
		int[][] whitePaper = new int[wN][wN];
		int cnt = 0;
		
		for(int t=0; t<T; t++) {
			String[] line = br.readLine().split(" ");
			int c = Integer.parseInt(line[0]);
			int r = Integer.parseInt(line[1]);
			
			for(int i=0; i<bN; i++) {
				for(int j=0; j<bN; j++) {
					if(whitePaper[r+i][c+j] == 0) {
						cnt++;
						whitePaper[r+i][c+j] = 1;
					}
				}
			}
		}
		
		System.out.println(cnt);
	}
}
