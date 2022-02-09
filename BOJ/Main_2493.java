import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

//아이디어 : stack 이용해서 하나씩 pop 하면서 넣으면 될듯. index와 높이를 같이 넣자.
public class Main_2493 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<int[]> st = new Stack<int[]>();
		int N = Integer.parseInt(br.readLine());
		String[] numberString = br.readLine().split(" ");
		int[] numbers = Arrays.stream(numberString).mapToInt(Integer::parseInt).toArray();
		int[] answer = new int[N];
		for(int i=N-1; i>=0; i--) { // 뒤에서부터 앞으로, 탑에 닿았을 때 그 탑 위치는 i+1임!
			if(st.isEmpty()) {
				st.add(new int[] {i, numbers[i]});
				continue;
			}
			while(true) {
				if(st.isEmpty() || st.peek()[1] > numbers[i]) {
					st.add(new int[] {i, numbers[i]});
					break;
				}
				int[] tmp = st.pop();
				answer[tmp[0]] = i+1;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(answer[i]+" ");
		}
		System.out.println(sb);
	}

}
