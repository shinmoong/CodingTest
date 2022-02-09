import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution_1224 {

	static Stack<Character> stack = new Stack<Character>();
	static Stack<Integer> stack2 = new Stack<Integer>();
	static Queue<Character> queue = new LinkedList<Character>();
	static HashMap<Character, Integer> priority = new HashMap<Character, Integer>();
	static HashMap<Character, Integer> priority_in = new HashMap<Character, Integer>();
	

	public static void makeHashMap() {
		priority.put('(', -1);
		priority.put('+', 0);
		priority.put('*', 1);
		
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
					while(!stack.isEmpty() && priority.get(c)<= priority.get(stack.peek())) {
						queue.offer(stack.pop());
					}
					stack.push(c);
				}
			}
			else if(c == '(') {
				stack.push(c);
			}
			else if(c== ')') {
				while(!stack.isEmpty() && stack.peek()!='(') {
					queue.offer(stack.pop());
				}
				stack.pop();
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
			makeHashMap();
			makePostFix(N, s);
			calculate();
			System.out.println("#"+test_case+" "+stack2.pop());
		}
	}
}
