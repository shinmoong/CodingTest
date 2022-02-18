import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15683 {
	static int N, M;
	static int count_zero, count, cctv_cover;
	static int [] num;
	static int [][] arr;
	static boolean [][] temp;
	static ArrayList<CCTV> CCTV_list = new ArrayList<CCTV>();
	static int [][] delta = {{-1, 0}, {1, 0}, {0,-1}, {0,1}};
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		temp = new boolean[N][M];
		count_zero = 0;
		cctv_cover = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0;k<M;k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
				if(1<=arr[i][k] && arr[i][k] <= 5) {
					CCTV_list.add(new CCTV(i, k, arr[i][k]));
				}
				else if(arr[i][k] == 0) {
					count_zero++;
				}
			}
		}
		num = new int[CCTV_list.size()];
		for(int i=0; i<CCTV_list.size();i++) {
			CCTV temp = CCTV_list.get(i);
			calculate(temp, 0);
		}

		perm(0);
		System.out.println(count_zero - cctv_cover);

	}
	public static class CCTV{
		int r;
		int c;
		int num;
		public CCTV(int r, int c, int num) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
		}
		
	}
	public static void change_one_dir(int r, int c, int dir) {
		while(0<=r && r<N && 0<=c && c<M && arr[r][c]!=6) {
			if(arr[r][c] == 0) {
				temp[r][c] = true;	//-1은 #을 뜻한다.
			}
			r +=delta[dir][0];
			c +=delta[dir][1];
		}
	}
	public static void calculate(CCTV cctv, int dir) {	//CCTV_num 은 1~5, dir은 0~3
		switch(cctv.num) {
			case 1:
				change_one_dir(cctv.r, cctv.c, dir);
				break;
			case 2:	//CCTV num이 2인 경우는 상하 or 좌우만 가능하니까, dir은 0~1개만 올 수 있음.
				if(dir <= 1) {
					change_one_dir(cctv.r, cctv.c, 2*dir);
					change_one_dir(cctv.r, cctv.c, 2*dir+1);
				}
				break;
			case 3:
				change_one_dir(cctv.r, cctv.c, dir/2);
				change_one_dir(cctv.r, cctv.c, 2+(dir%2));
				break;
			case 4:
				for(int i=1; i<=3; i++) {
					change_one_dir(cctv.r, cctv.c, (dir+i)%4);
				}
				break;
			case 5:
				for(int i=0; i<=3; i++) {
					change_one_dir(cctv.r, cctv.c, i);
				}
				break;
		}
	}
	public static void perm(int cnt) {
		if(cnt == CCTV_list.size()) {
			for(int i=0;i<N;i++) {
				Arrays.fill(temp[i], false);
			}
			for(int i=0; i<CCTV_list.size();i++) {
				calculate(CCTV_list.get(i),num[i]);
			}
			count = 0;
			for(int i=0;i<N;i++) {
				for(int k=0;k<M;k++) {
					if(temp[i][k]) {
						count++;
					}
				}
			}
			cctv_cover = Math.max(cctv_cover, count);
			return;
		}
		for(int i=0; i<4; i++) {
			num[cnt] = i;
			perm(cnt+1);
		}	
	}
}
