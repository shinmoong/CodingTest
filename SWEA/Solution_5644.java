import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_5644 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int M, A, N = 10, max, xA, xB, yA, yB; // N : map 크기
		int[] moveA, moveB, PList;
		boolean[][][] map;

		String[] line;
		for (int test_case = 1; test_case <= T; test_case++) {
			line = br.readLine().split(" ");
			M = Integer.parseInt(line[0]); // 총 이동시간
			A = Integer.parseInt(line[1]); // BC 갯수
			moveA = new int[M]; // A 이동 정보
			moveB = new int[M]; // B 이동 정보

			line = br.readLine().split(" ");
			for (int i = 0; i < M; i++) {
				moveA[i] = Integer.parseInt(line[i]);
			}
			line = br.readLine().split(" ");
			for (int i = 0; i < M; i++) {
				moveB[i] = Integer.parseInt(line[i]);
			}

			map = new boolean[N + 1][N + 1][A + 1]; // existBC[][] 에 BC가 존재하는 갯수
			PList = new int[A + 1]; // BC의 성능 저장할 배열

			for (int i = 1; i <= A; i++) {
				line = br.readLine().split(" ");
				switch (line[2]) {
				case "1":
					makeRange(map, N, Integer.parseInt(line[0]), Integer.parseInt(line[1]), 1, i);
					break;
				case "2":
					makeRange(map, N, Integer.parseInt(line[0]), Integer.parseInt(line[1]), 2, i);
					break;
				case "3":
					makeRange(map, N, Integer.parseInt(line[0]), Integer.parseInt(line[1]), 3, i);
					break;
				case "4":
					makeRange(map, N, Integer.parseInt(line[0]), Integer.parseInt(line[1]), 4, i);
					break;
				}
				PList[i] = Integer.parseInt(line[3]);
			}
			// 여기까지 데이터 생성 완료

			max = 0; // 최대값 저장할 변수
			xA = yA = 1;
			xB = yB = N;
			max += getMax(map, xA, yA, xB, yB, PList, A);
			for (int i = 0; i < M; i++) {
				switch (moveA[i]) {
				case 1: // 상
					yA -= 1;
					break;
				case 2: // 우
					xA += 1;
					break;
				case 3: // 하
					yA += 1;
					break;
				case 4: // 좌
					xA -= 1;
					break;
				}
				switch (moveB[i]) {
				case 1: // 상
					yB -= 1;
					break;
				case 2: // 우
					xB += 1;
					break;
				case 3: // 하
					yB += 1;
					break;
				case 4: // 좌
					xB -= 1;
					break;
				}

				max += getMax(map, xA, yA, xB, yB, PList, A);
			}

			System.out.println("#" + test_case + " " + max);
		}
	}

	public static void makeRange(boolean[][][] map, int N, int x, int y, int range, int num) {
		for (int i = -range; i <= range; i++) {
			if (x + i >= 1 && x + i <= N) {
				map[x + i][y][num] = true;
			}
		}
		for (int i = 1; i <= range; i++) {
			for (int j = -range + i; j <= range - i; j++) {
				if (x + j >= 1 && x + j <= N && y + i >= 1 && y + i <= N) {
					map[x + j][y + i][num] = true;
				}
				if (x + j >= 1 && x + j <= N && y - i >= 1 && y - i <= N) {
					map[x + j][y - i][num] = true;
				}
			}
		}
	}

	public static int getMax(boolean[][][] map, int xA, int yA, int xB, int yB, int[] PList, int A) {
		int max = 0;
		int tmp;

		for (int i = 1; i <= A; i++) {
			for (int j = 1; j <= A; j++) {
				if (map[xA][yA][i] && map[xB][yB][j]) {
					tmp = PList[i] + PList[j];
					if (i == j) {
						tmp /= 2;
					}
					if (tmp > max) {
						max = tmp;
					}
				} else if (map[xA][yA][i]) {
					tmp = PList[i];
					if (tmp > max)
						max = tmp;
				} else if (map[xB][yB][j]) {
					tmp = PList[j];
					if (tmp > max)
						max = tmp;
				}
			}
		}
		
		return max;
	}
}
