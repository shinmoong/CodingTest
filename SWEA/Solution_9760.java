import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9760 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		String tmp;
		char tmp2;
		for (int t = 1; t <= T; t++) {
			int[] suit = new int[4];
			int[] rank = new int[14];
			boolean one = false, two = false, three = false, straight = false, flush = false, fullHouse = false,
					four = false, straightFlush = false;
			int cnt = 0;
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 5; i++) {
				tmp = st.nextToken();
				switch (tmp.charAt(0)) {
				case 'S':
					suit[0]++;
					break;
				case 'D':
					suit[1]++;
					break;
				case 'H':
					suit[2]++;
					break;
				case 'C':
					suit[3]++;
					break;
				}
				tmp2 = tmp.charAt(1);
				if (tmp2 >= '2' && tmp2 <= '9') {
					rank[tmp2 - '0']++;
				} else {
					switch (tmp2) {
					case 'A':
						rank[1]++;
						break;
					case 'T':
						rank[10]++;
						break;
					case 'J':
						rank[11]++;
						break;
					case 'Q':
						rank[12]++;
						break;
					case 'K':
						rank[13]++;
						break;
					}
				}
			}
			for (int i = 0; i < 4; i++) {
				if (suit[i] == 5)
					flush = true;
			}
			for (int i = 1; i <= 13; i++) {
				if (one == true && rank[i] == 2)
					two = true;
				else if (rank[i] == 2)
					one = true;
				else if (rank[i] == 3)
					three = true;
				else if (rank[i] == 4)
					four = true;

				if (rank[i] == 1)
					cnt++;
				else if (cnt != 5)
					cnt = 0;
			}
			if (cnt == 5 || (cnt == 4 && rank[1] == 1))
				straight = true;

			if (straight && flush)
				System.out.println("#" + t + " " + "Straight Flush");
			else if (four)
				System.out.println("#" + t + " " + "Four of a Kind");
			else if (three && one)
				System.out.println("#" + t + " " + "Full House");
			else if (flush)
				System.out.println("#" + t + " " + "Flush");
			else if (straight)
				System.out.println("#" + t + " " + "Straight");
			else if (three)
				System.out.println("#" + t + " " + "Three of a kind");
			else if (two)
				System.out.println("#" + t + " " + "Two pair");
			else if (one)
				System.out.println("#" + t + " " + "One pair");
			else
				System.out.println("#" + t + " " + "High card");
		}
	}

}
