import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15686 {

	public static int N, M, answer;
	public static int[] choose;
	static ArrayList<int[]> homeList = new ArrayList<>();
	static ArrayList<int[]> chickenList = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i< N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j =0; j< N; j++) {
				int a = Integer.parseInt(st.nextToken());
				switch(a) {
				case 1: 
					homeList.add(new int[] {i, j});
					break;
				case 2: 
					chickenList.add(new int[] {i, j});
					break;
				}
			}
		}
		answer = Integer.MAX_VALUE;
		choose = new int[M];
		combination(0, 0);
		System.out.println(answer);

	}
	public static void combination(int cnt, int start) {
		
		if(cnt == M) {
			int sum = 0;
			for(int k = 0; k < homeList.size(); k++) {
				int temp = 0;
				int min_temp = Integer.MAX_VALUE;
				for(int j = 0; j < M; j++) {
					temp = (Math.abs(homeList.get(k)[0] - chickenList.get(choose[j])[0]) + 
							Math.abs(homeList.get(k)[1] - chickenList.get(choose[j])[1]));
					//최솟값
					if(min_temp > temp) {
						min_temp = temp;
					}
				}
				//결과 저장 sum
				sum += min_temp;
			}
			answer = Math.min(answer, sum);
			return;
		}
		
		for(int i =start; i< chickenList.size(); i++) {
			choose[cnt] = i;
			combination(cnt+1, i+1);
		}
		
	}

}