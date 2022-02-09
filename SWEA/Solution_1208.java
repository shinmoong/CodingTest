import java.util.Scanner;

public class Solution_1208 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int dump = sc.nextInt();
			int[] boxes = new int[100];
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;

			for (int i = 0; i < 100; i++) {
				boxes[i] = sc.nextInt();
			}

			for (int i = 0; i < dump; i++) {
				max = Integer.MIN_VALUE;
				min = Integer.MAX_VALUE;
				int maxIdx = -1;
				int minIdx = -1;

				for (int x = 0; x < 100; x++) {
					if (boxes[x] > max) {
						max = boxes[x];
						maxIdx = x;
					}
					if (boxes[x] < min) {
						min = boxes[x];
						minIdx = x;
					}
				}

				if (max - min <= 1)
					break;
				
				max = --boxes[maxIdx];
				min = ++boxes[minIdx];
				
			}

			for(int x=0; x<100; x++) {
				if (boxes[x] > max) {
					max = boxes[x];
				}
				if (boxes[x] < min) {
					min = boxes[x];
				}
			}
			System.out.println("#" + test_case + " " + (max - min));
		}
	}

}
