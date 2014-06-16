
public class p010 {
	public static void main(String[] args) {
		boolean[] primes = new boolean[2000001];
		primes[0] = true;
		primes[1] = true;
		long sum = 0;
		for(int i = 2; i < primes.length; i++) {
			if(!primes[i]) {
				sum += i;
				for(int j = i * 2; j < primes.length; j += i) {
					primes[j] = true;
				}
			}
		}
		System.out.println(sum);
	}
}
