//Calculates the 10 001 prime
public class p007 {
	public static void main(String[] args) {
		System.out.println(nthPrime(1000000));

	}
	
	private static int nthPrime(int n) {
		int prime = 0;
		int i = 1;
		while(prime < n) {
			i++;
			if(isPrime(i)) prime++;
		}
		
		return i;
	}
	
	private static boolean isPrime(int n) {
		for(int i = 2; i < (int) (Math.sqrt(n) + 1); i++) {
			if(n % i == 0) return false;
		}
		return true;
	}

}
