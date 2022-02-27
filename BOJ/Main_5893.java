import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5893 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] input0 = br.readLine().toCharArray();

		char[] input1 = new char[input0.length + 4];
		char[] input2 = new char[input1.length];

		for (int i = 0; i < 4; i++) {
			input1[input1.length - 1 - i] = input2[i] = '0';
		}
		for (int i = 0; i < input0.length; i++) {
			input1[i] = input0[i];
			input2[i + 4] = input0[i];
		}

		int carry = 0, sum = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = input1.length - 1; i >= 0; i--) {
			sum = carry + input1[i] - '0' + input2[i] - '0';
			carry = sum / 2;
			sum = sum % 2;

			sb.insert(0, sum);
		}
		if (carry == 1) {
			sb.insert(0, carry);
		}
		System.out.println(sb);
	}

}
