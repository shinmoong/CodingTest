import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_3289 {
	static int n;
	static int[] parents;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		String[] line;
		int m;
		for (int test_case = 1; test_case <= T; test_case++) {
			line = br.readLine().split(" ");
			n = Integer.parseInt(line[0]);
			m = Integer.parseInt(line[1]);

			parents = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				parents[i] = i;
			}

			System.out.print("#" + test_case + " ");
			for (int i = 0; i < m; i++) {
				line = br.readLine().split(" ");

				if (Integer.parseInt(line[0]) == 0) {
					union(Integer.parseInt(line[1]), Integer.parseInt(line[2]));
				} else {
					if (find(Integer.parseInt(line[1])) == find(Integer.parseInt(line[2])))
						System.out.print(1);
					else
						System.out.print(0);
				}
			}
			System.out.println();
		}
	}

	public static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA > rootB) // 루트 값 작은 쪽으로 union
			parents[rootA] = rootB;
		else
			parents[rootB] = rootA;
	}

	public static int find(int a) {
		if (parents[a] == a)
			return a;

		return parents[a] = find(parents[a]);
	}
}
