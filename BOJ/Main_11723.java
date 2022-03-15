import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;

public class Main_11723 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int M = Integer.parseInt(br.readLine());
		int idx;
		String cal;
		String[] line;
		int bm = 0;
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < M; t++) {
			line = br.readLine().split(" ");
			cal = line[0];

			switch (cal) {
			case "add":
				idx = Integer.parseInt(line[1]);
				bm = (bm | (1 << idx));
				break;
			case "remove":
				idx = Integer.parseInt(line[1]);
				bm = (bm & (~(1 << idx)));
				break;
			case "check":
				idx = Integer.parseInt(line[1]);
				if ((bm & (1 << idx)) != 0) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
				break;
			case "toggle":
				idx = Integer.parseInt(line[1]);
				bm = (bm ^ (1 << idx));
				break;
			case "all":
				bm = (bm | (~0));
				break;
			case "empty":
				bm = (bm & 0);
				break;
			}

		}
		
		System.out.println(sb);
	}

}
