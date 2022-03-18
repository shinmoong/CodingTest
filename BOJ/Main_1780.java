import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1780 {
	static int[][] arr;
	static int N;
	static int[] ans = new int[3];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		splitPaper(0, 0, N);
		
		System.out.println(ans[0]);
		System.out.println(ans[1]);
		System.out.println(ans[2]);
	}
	
	static int splitPaper(int r, int c, int size) {
		int check = arr[r][c];
		int splitSize = 0;
		
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(arr[i][j] != check) {
					splitSize = size/3;
					for(int a=0; a<3; a++) {
						for(int b=0; b<3; b++) {
							splitPaper(r+a*splitSize, c+b*splitSize, splitSize);
						}
					}
					return -2;
				}
			}
		}
		
		ans[check+1]++;
		
		return check;
	}
}
