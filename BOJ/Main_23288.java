import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_23288 {
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // 시계 방향 delta
	static int[][] map, scoreMap;
	static int N, M, K;
	static int[] dice = { 2, 4, 1, 3, 5, 6 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		K = Integer.parseInt(st.nextToken()); // 이동횟수

		map = new int[N][M]; // 입력 map
		scoreMap = new int[N][M]; // 점수 map

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) { // scoreMap 구함
			for (int j = 0; j < M; j++) {
				if (scoreMap[i][j] == 0)
					bfs(i, j);
			}
		}
		
		int dir = 0; // 이동방향 0~3까지 시계방향 +1, 반시계 -1
		int r = 0, c = 0;
		int nr, nc;
		long score = 0;
		for (int i = 0; i < K; i++) {
			nr = r+deltas[dir][0];
			nc = c+deltas[dir][1];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M) {
				dir = (dir+2)%4;
				r = r+deltas[dir][0];
				c = c+deltas[dir][1];
			}else {
				r = nr;
				c = nc;
			}
			
			mvDice(dir);
			
			if(dice[5] > map[r][c]) {
				dir = (dir+1)%4;
			}else if(dice[5] < map[r][c]) {
				dir = (dir+3)%4;
			}
			
			score += scoreMap[r][c];
		}
		
		System.out.println(score);
	}

	private static void bfs(int r, int c) {
		int num = map[r][c]; // 좌표값
		Queue<Node> queue = new LinkedList<>();
		ArrayList<Node> list = new ArrayList<>(); // 인접한 칸들 저장할 배열
		boolean visited[][] = new boolean[N][M];

		queue.offer(new Node(r, c));
		visited[r][c] = true;
		Node current;
		int nr, nc;
		while (!queue.isEmpty()) {
			current = queue.poll();
			list.add(current);

			for (int i = 0; i < 4; i++) {
				nr = current.r + deltas[i][0];
				nc = current.c + deltas[i][1];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == num && !visited[nr][nc]) {
					queue.offer(new Node(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}

		int val = num * list.size();

		for (Node node : list) {
			scoreMap[node.r][node.c] = val;
		}
	}

	static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static void mvDice(int dir) {
		int tmp0 = 0, tmp1 = 0, tmp2 = 0, tmp3 = 0, tmp4 = 0, tmp5 = 0;

		switch (dir) {
		case 0:
			tmp0 = dice[0];
			tmp1 = dice[5];
			tmp2 = dice[1];
			tmp3 = dice[2];
			tmp4 = dice[4];
			tmp5 = dice[3];
			break;
		case 1:
			tmp0 = dice[5];
			tmp1 = dice[1];
			tmp2 = dice[0];
			tmp3 = dice[3];
			tmp4 = dice[2];
			tmp5 = dice[4];
			break;

		case 2:
			tmp0 = dice[0];
			tmp1 = dice[2];
			tmp2 = dice[3];
			tmp3 = dice[5];
			tmp4 = dice[4];
			tmp5 = dice[1];
			break;
		case 3:
			tmp0 = dice[2];
			tmp1 = dice[1];
			tmp2 = dice[4];
			tmp3 = dice[3];
			tmp4 = dice[5];
			tmp5 = dice[0];
			break;
		}
		
		dice[0] = tmp0;
		dice[1] = tmp1;
		dice[2] = tmp2;
		dice[3] = tmp3;
		dice[4] = tmp4;
		dice[5] = tmp5;
	}
}
