import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1708 {
	static Point start = new Point(Long.MAX_VALUE, Long.MAX_VALUE);

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int x, y, startIdx = 0;
		ArrayList<Point> points = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			points.add(new Point(x, y));

			if (start.y > y) {
				start = points.get(i);
				startIdx = i;
			} else if (start.y == y) {
				if (start.x > x) {
					start = points.get(i);
					startIdx = i;
				}
			}
		}

		points.remove(startIdx);
		Collections.sort(points);
		
		Stack<Point> stack = new Stack<>();
		stack.add(start);
		int size = points.size();
		for(int i=0; i<size; i++) {
			while(stack.size()>=2 && ccw(stack.get(stack.size()-2), stack.get(stack.size()-1), points.get(i))<=0) {
				stack.pop();
			}
			stack.add(points.get(i));
		}
		
		System.out.println(stack.size());
	}

	static long ccw(Point a, Point b, Point c) {
		return a.x * b.y + b.x * c.y + c.x * a.y - b.x * a.y - c.x * b.y - a.x * c.y;
	}

	static class Point implements Comparable<Point> {
		long x, y;

		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			long val = ccw(start, this, o);
			if (val > 0)
				return -1;
			else if (val < 0)
				return 1;
			else {
				if ((start.x - this.x) * (start.x - this.x) + (start.y - this.y) * (start.y - this.y)
						> (start.x - o.x) * (start.x - o.x) + (start.y - o.y) * (start.y - o.y))
					return 1;
				else
					return -1;

			}
		}
	}
}
