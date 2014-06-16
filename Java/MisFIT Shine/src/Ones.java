import java.math.BigInteger;
import java.util.Scanner;


public class Ones {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		while(kb.hasNext()) {
			int n = kb.nextInt();
			System.out.println(getLength(n));
		}
	}
	
	private static int getLength(int n) {
		if(n == 1) return 1;
		int x = 1;
		while(true) {
			if(bigMod(x,n*9) == 1) return x;
			x++;
		}
	}
	
	private static long bigMod(long x, long mod) {
		if(x == 1) return 10 % mod;
		if(x % 2 == 0) {
			long n = bigMod(x/2, mod) % mod;
			return (n*n) % mod;
		} else {
			return (10 % mod * bigMod(x -1, mod)) % mod;
		}
	}
}
