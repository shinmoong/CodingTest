import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2527 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Point[] a = new Point[4];
		Point[] b = new Point[4];

		for(int i=0; i<4; i++) {
			a[i] = new Point();
			b[i] = new Point();
		}
		String[] line;
		for (int i = 0; i < 4; i++) {
			line = br.readLine().split(" ");
			
			a[0].x = Integer.parseInt(line[0]);
			a[0].y = Integer.parseInt(line[1]);
			a[3].x = Integer.parseInt(line[2]);
			a[3].y = Integer.parseInt(line[3]);
			b[0].x = Integer.parseInt(line[4]);
			b[0].y = Integer.parseInt(line[5]);
			b[3].x = Integer.parseInt(line[6]);
			b[3].y = Integer.parseInt(line[7]);
			a[1].x = a[3].x;
			a[1].y = a[0].y;
			a[2].x = a[0].x;
			a[2].y = a[3].y;
			b[1].x = b[3].x;
			b[1].y = b[0].y;
			b[2].x = b[0].x;
			b[2].y = b[3].y;

			if (a[1].x < b[0].x || a[2].y < b[0].y || b[1].x < a[0].x || b[2].y < a[0].y)
				System.out.println("d");
			else if ((a[0].x == b[3].x && a[0].y == b[3].y) || (a[1].x == b[2].x && a[1].y == b[2].y) || (a[2].x == b[1].x && a[2].y == b[1].y) || (a[3].x == b[0].x && a[3].y == b[0].y))
				System.out.println("c");
			else if(a[1].x==b[0].x || a[2].y==b[0].y || a[0].x == b[1].x || a[0].y==b[2].y)
				System.out.println("b");
			else
				System.out.println("a"); 
		}
	}
}
