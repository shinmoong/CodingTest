import java.util.Scanner;

public class Solution_3238 {

	public static void main(String[] args) {
		long n, r, p, x, y, ans;
		long[] fac = new long[100001];
		Scanner scann = new Scanner(System.in);
		int T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			n = scann.nextLong();
			r = scann.nextLong();
			p = scann.nextLong();

			fac[0] = 1;
			for (int i = 1; i <= p; i++) {
				fac[i] = fac[i - 1] * i % p;
			}

			ans = 1;
			while (!(r == 0 && n == 0)) {
				x = n % p;
				y = r % p;

				if (x < y) {
					ans = 0;
					break;
				}

				ans = ans * fac[(int) x] % p;
				for (int i = 0; i < p - 2; i++) {
					ans = ans * fac[(int) (x - y)] * fac[(int) y] % p;
				}
				n /= p;
				r /= p;
			}
			ans %= p;
			
			System.out.printf("#%d %d\n", t, ans);
		}
	}

}
