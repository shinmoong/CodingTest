import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2606 {
	static int[] parents;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		parents = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}

		StringTokenizer st = null;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		int ans = 0;
		for(int i=2; i<=N; i++) {
			if(find(i) == find(1))
				ans++;
		}
		System.out.println(ans);
	}

	static int find(int a) {
		if (parents[a] == a)
			return a;

		return parents[a] = find(parents[a]);
	}

	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA > rootB) 
			parents[rootA] = rootB;
		else
			parents[rootB] = rootA;
	}
}
