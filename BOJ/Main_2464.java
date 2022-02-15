import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_2464 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long A = Long.parseLong(br.readLine());
		int[] arr = new int[60];

		for (int i = 0; i < 60; i++) {
			if (A == 0)
				break;
			if ((A & 1) != 0) {
				arr[59 - i] = 1;
			}
			A = A >> 1;
		}
		
		int[] nextTmp = arr.clone();
		int[] prevTmp = nextTmp.clone();

		if (!prevPermutation(prevTmp)) {
			System.out.print(0 + " ");
		} else {
			System.out.print(getVal(prevTmp) + " ");
		}

		nextPermutation(nextTmp);
		System.out.println(getVal(nextTmp));
	}

	public static boolean nextPermutation(int[] nextTmp) {
		int i = 59;

		while (i > 0 && nextTmp[i - 1] >= nextTmp[i]) {
			i--;
		}

		if (i == 0)
			return false;

		int j = 59;

		while (nextTmp[i - 1] >= nextTmp[j]) {
			j--;
		}
		swap(nextTmp, i - 1, j);
		int k = 59;
		while (i < k) {
			swap(nextTmp, i++, k--);
		}

		return true;
	}

	public static boolean prevPermutation(int[] prevTmp) {
		int i = 59;

		while (i > 0 && prevTmp[i - 1] <= prevTmp[i]) {
			i--;
		}

		if (i == 0)
			return false;

		int j = 59;

		while (prevTmp[i - 1] <= prevTmp[j]) {
			j--;
		}

		swap(prevTmp, i - 1, j);

		int k = 59;
		while (i < k) {
			swap(prevTmp, i++, k--);
		}

		return true;
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static long getVal(int[] arr) {
		long sum = 0;
		for (int i = 0; i < 60; i++) {
			sum *= 2;
			if (arr[i] == 1) {
				sum += 1;
			}
		}
		return sum;
	}
}
