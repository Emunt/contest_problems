import java.util.Scanner;

//2/2/14
//Calculate Fib(N) % 2^M

public class p10229 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		while (kb.hasNextInt()) {
			System.out.println(bigfib(new long[] { 1, 1, 1, 0 }, kb.nextLong(),
					1<<kb.nextLong())[2]);
		}

	}

	// Calculates fib using its matrix property and the rule:
	// (A*B*C) mod n = (A mod n * B mod n * C mod n) mod n;
	private static long[] bigfib(long[] mat, long N, long M) {
		if (N == 0)
			return new long[] { 0, 0, 0, 0 };
		if (N == 1)
			return new long[] { 1, 1, 1, 0 };
		if (N % 2 == 0) {
			long[] temp = mod(bigfib(mat, N/2, M), M);
			return mod(mult(temp,temp, M), M);
		} else {
			return mod(mult(new long[] {1,1,1,0},mod(bigfib(mat, N-1,M),M), M), M);
		}
	}

	private static long[] mult(long[] a, long[] b, long M) {
		return new long[] { (((a[0]% M) * (b[0] % M)) % M) + (((a[1]% M) * (b[2] % M)) % M),
				(((a[0]% M) * (b[1] % M)) % M) + (((a[1]% M) * (b[3] % M)) % M),
				(((a[2]% M) * (b[0] % M)) % M) + (((a[3]% M) * (b[2] % M)) % M),
				(((a[2]% M) * (b[1] % M)) % M) + (((a[3]% M) * (b[3] % M)) % M) };
	}

	private static long[] mod(long[] a, long M) {
		a[0] = a[0] % M;
		a[1] = a[1] % M;
		a[2] = a[2] % M;
		a[3] = a[3] % M;
		return a;
	}
}
