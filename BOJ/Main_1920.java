import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1920 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		String[] line = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(line[i]);
		}
		Arrays.sort(arr);

		int M = Integer.parseInt(br.readLine());

		line = br.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			if(binarySearch(arr, N, Integer.parseInt(line[i])))
				System.out.println(1);
			else
				System.out.println(0);
		}
		
		
	}

	public static boolean binarySearch(int[] arr, int N, int num) {
		int low = 0, high = N - 1, mid;

		while (low <= high) {
			mid = (low + high) / 2;

			if (num > arr[mid]) {
				low = mid + 1;
			} else if (num < arr[mid]) {
				high = mid - 1;
			} else {
				return true;
			}
		}

		return false;
	}

}
