import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2578 {

	public static void main(String[] args) throws IOException {
		int[][] bingo = new int[5][5];
		int[] numbs = new int[25];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line;
		int cnt = 0;

		for (int i = 0; i < 5; i++) {
			line = br.readLine().split(" ");
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(line[j]);
			}
		}

		for (int i = 0; i < 5; i++) {
			line = br.readLine().split(" ");
			for (int j = 0; j < 5; j++) {
				numbs[5 * i + j] = Integer.parseInt(line[j]);
			}
		}

		for (int i = 0; i < 25; i++) {
			search: for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					if (bingo[j][k] == numbs[i]) {
						bingo[j][k] = 0;

						for (int l = 0; l < 5; l++) {
							if(bingo[j][l] != 0)
								break;
							if(l==4)
								cnt++;
						}
						for (int l = 0; l < 5; l++) {
							if(bingo[l][k] != 0)
								break;
							if(l==4)
								cnt++;
						}
						
						if(j+k == 4) { // 우상 대각선
							for(int l=0; l<5; l++) {
								if(bingo[l][4-l] != 0)
									break;
								if(l==4)
									cnt++;
							}
						}
						if(j==k) { // 우하 대각선
							for(int l=0; l<5; l++) {
								if(bingo[l][l] != 0)
									break;
								if(l==4)
									cnt++;
							}
						}
						break search;
					}
				}
			}
			if(cnt >= 3) {
				System.out.println(i+1);
				break;
			}
		}
	}

}
