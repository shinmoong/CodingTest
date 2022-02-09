import java.util.Scanner;
import java.util.Stack;

public class Solution_1218 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		for (int test_case = 1; test_case <= T; test_case++) {
			/////////////////////////////////////////////////////////////////////////////////////////////
			Stack<Character> st = new Stack<>();
			int len = sc.nextInt();
			String line = sc.next();
			int flag = 1;

			for (int i = 0; i < len; i++) {
				char bracket = line.charAt(i);

				if (bracket == '{' || bracket == '[' || bracket == '(' || bracket == '<') {
					st.push(bracket);
				} else {
					if (st.isEmpty()) {
						flag = 0;
						break;
					} else {
						if (bracket == '}' && st.pop() != '{') {
							flag = 0;
							break;
						} else if (bracket == ']' && st.pop() != '[') {
							flag = 0;
							break;
						} else if (bracket == ')' && st.pop() != '(') {
							flag = 0;
							break;
						} else if (bracket == '>' && st.pop() != '<'){
							flag = 0;
							break;
						}
					}
				}
			}

			System.out.println("#" + test_case + " " + flag);
			/////////////////////////////////////////////////////////////////////////////////////////////

		}
	}

}
