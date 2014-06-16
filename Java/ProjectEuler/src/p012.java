
public class p012 {
	public static void main(String[] args) {
		long tri = 1;
		long  i = 1;
		
		while(numDivisors(tri) <= 500) {
			i++;
			tri += i;
			//System.out.println(tri);
		}
		System.out.println(tri);

	}

	
	private static int numDivisors(long n) {
		int sum = 0;
		for(int i = 1; i <= (int) Math.sqrt(n); i++) {
			if(n% i == 0) sum++;
			if(n % i == 0 && i != Math.sqrt(n)) sum++;
		}
		return sum;
	}
}
