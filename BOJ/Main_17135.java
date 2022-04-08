import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_17135 {
	static int N, M, D, max;
	static ArrayList<Enemy> enemyList = new ArrayList<>();
	static int[] archerList = new int[3];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				if (st.nextToken().charAt(0) == '1') {
					enemyList.add(new Enemy(i, j));
				}
			}
		}
		Collections.sort(enemyList);

		LinkedList<Enemy> copyEnemyList;
		for (int i = 0; i < M; i++) {
			archerList[0] = i;
			for (int j = 0; j < M; j++) {
				if (i >= j)
					continue;
				archerList[1] = j;
				for (int k = 0; k < M; k++) {
					if (j >= k)
						continue;
					archerList[2] = k;

					copyEnemyList = new LinkedList<>();
					for (Enemy enemy : enemyList) {
						copyEnemyList.add(new Enemy(enemy.r, enemy.c));
					}

					defense(copyEnemyList);
				}
			}
		}
		System.out.println(max);
	}

	private static void defense(LinkedList<Enemy> copyEnemyList) {
		int minD0, minD1, minD2;
		int curD0, curD1, curD2;
		Enemy[] selectEnemy = new Enemy[3];
		int deleteCnt = 0;

		while (!copyEnemyList.isEmpty()) {
			selectEnemy[0] = selectEnemy[1] = selectEnemy[2] = null;
			minD0 = minD1 = minD2 = Integer.MAX_VALUE;
			for (Enemy enemy : copyEnemyList) {
				curD0 = Math.abs(N - enemy.r) + Math.abs(archerList[0] - enemy.c);
				curD1 = Math.abs(N - enemy.r) + Math.abs(archerList[1] - enemy.c);
				curD2 = Math.abs(N - enemy.r) + Math.abs(archerList[2] - enemy.c);

				if (curD0 <= D && curD0 < minD0) {
					minD0 = curD0;
					selectEnemy[0] = enemy;
				}
				if (curD1 <= D && curD1 < minD1) {
					minD1 = curD1;
					selectEnemy[1] = enemy;
				}
				if (curD2 <= D && curD2 < minD2) {
					minD2 = curD2;
					selectEnemy[2] = enemy;
				}
			}

			if (selectEnemy[0] != null) {
				copyEnemyList.remove(selectEnemy[0]);
				deleteCnt++;
			}
			if (selectEnemy[1] != null && selectEnemy[1] != selectEnemy[0]) {
				copyEnemyList.remove(selectEnemy[1]);
				deleteCnt++;
			}
			if (selectEnemy[2] != null && selectEnemy[2] != selectEnemy[0] && selectEnemy[2] != selectEnemy[1]) {
				copyEnemyList.remove(selectEnemy[2]);
				deleteCnt++;
			}

			copyEnemyList.removeIf(enemy -> (enemy.r == N - 1));
			for (Enemy enemy : copyEnemyList) {
				enemy.r++;
			}
		}

		if (deleteCnt > max)
			max = deleteCnt;
	}

	static class Enemy implements Comparable<Enemy> {
		int r, c;

		public Enemy(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Enemy o) {
			return this.c == o.c ? o.r - this.r : this.c - o.c;
		}
	}
}
