import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution_1223 {
	
	static Stack<Character> stack = new Stack<Character>();
	static Stack<Integer> stack2 = new Stack<Integer>();
	static Queue<Character> queue = new LinkedList<Character>();
	static HashMap<Character, Integer> priority = new HashMap<Character, Integer>();
	static HashMap<Character, Integer> priority_in = new HashMap<Character, Integer>();
	
//	map.put('*', 1);
//	map.put('(', 2);
	public static void makeHashMap() {
		priority.put('+', 0);
		priority.put('*', 1);
		priority.put('(', 2);
		
		priority_in.put('(', 0);
		priority_in.put('+', 1);
		priority_in.put('+', 2);
	}
	public static int simple_cal(int a, int b, char c) {
		if(c=='+')	return a+b;
		else if(c=='*') return a*b;
		else	return 0;
	}
	
	public static void makePostFix(int N, String s) {
		for(int i=0; i<N; i++) {
			char c = s.charAt(i);
			if(c == '+' || c=='*') {
				if(stack.isEmpty()) {
					stack.push(c);
				}
				else {
					while(!stack.isEmpty() && stack.peek() <= c) {
						queue.offer(stack.pop());
					}
					stack.push(c);
				}
			}
			else {
				queue.offer(c);
			}
		}
		while(!stack.isEmpty()) {
			queue.offer(stack.pop());
		}
	}
	public static void calculate() {
		while(!queue.isEmpty()) {
			char c = queue.poll();
			if(c == '+' || c=='*') {
				int a = stack2.pop();
				int b = stack2.pop();
				stack2.push(simple_cal(a,b,c));
			}
			else {
				stack2.push(c - '0');
			}
		}
	}
	
	public static void main(String args[]) throws Exception
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for(int test_case=1; test_case<=T;test_case++) {
			int N = Integer.parseInt(br.readLine());
			String s = br.readLine();
			stack.clear();
			stack2.clear();
			queue.clear();
			makePostFix(N, s);
			calculate();
			System.out.println("#"+test_case+" "+stack2.pop());
		}
	}
}
