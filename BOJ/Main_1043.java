import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1043 {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().split(" ");

		int N = Integer.parseInt(line[0]); // 사람 수
		int M = Integer.parseInt(line[1]); // 파티 수
		int cnt = 0;
		boolean flag;
		line = br.readLine().split(" ");
		int trueNum = Integer.parseInt(line[0]); // 진실을 아는 사람 수
		int[] trues = new int[trueNum]; // trues에 true인 index 집어넣음.
		int[][] partyTmp = new int[M][]; // party 내용 저장할 배열
		parent = new int[N + 1]; // 부모를 저장(union, find)

		for (int i = 1; i <= trueNum; i++) {
			trues[i-1] = Integer.parseInt(line[i]);
		}
		for (int i = 1; i <= N; i++) { // 자기자신을 부모로 참조하도록 초기화
			parent[i] = i;
		}

		for (int i = 0; i < M; i++) {
			line = br.readLine().split(" ");
			int partyPNum = Integer.parseInt(line[0]); // 한 party당 사람 수
			int[] tmp = new int[partyPNum]; // party 내용을 저장하기 위한 배열

			tmp[0] = Integer.parseInt(line[1]);
			if (partyPNum == 1) { // 하나밖에 없으면 union할 일이 없음.
				partyTmp[i] = tmp;
				continue;
			}

			for (int j = 2; j <= partyPNum; j++) {
				union(tmp[0], Integer.parseInt(line[j]));
				tmp[j - 1] = Integer.parseInt(line[j]);
			}

			partyTmp[i] = tmp;
		}

		for (int i = 0; i < M; i++) {
			flag = false; // 한 명이라도 진실을 알면 진실을 말해야 한다.
			for (int person : partyTmp[i]) {
				for (int truePerson : trues) {
					if (getParent(truePerson) == getParent(person)) {
						flag = true;
						break;
					}
				}
				if (flag == true)
					break;
			}
			if (flag == false)
				cnt++;
		}
		System.out.println(cnt);
	}

	public static int getParent(int x) {
		if (x == parent[x])
			return x;
		else
			return parent[x] = getParent(parent[x]);
	}

	public static void union(int a, int b) {
		a = getParent(a);
		b = getParent(b);

		if (a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}
}
