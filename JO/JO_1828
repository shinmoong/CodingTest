import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class JO_1828 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] materials = new int[N][2];
		String[] line;
		for (int i = 0; i < N; i++) {
			line = br.readLine().split(" ");
			materials[i][0] = Integer.parseInt(line[0]);
			materials[i][1] = Integer.parseInt(line[1]);
		}

		Arrays.sort(materials, new Comparator<int[]>() {
			@Override
			public int compare(int[] m1, int[] m2) {
				return m1[1] != m2[1] ? m1[1] - m2[1] : m1[0] - m2[0];
			}
		});
		
		int cnt = 0;
		int end = -270;
		for(int i=0; i<N; i++) {
			if(end < materials[i][0]) {
				cnt++;
				end = materials[i][1];
			}
		}
		System.out.println(cnt);
	}

}
