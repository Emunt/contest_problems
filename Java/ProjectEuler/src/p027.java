
public class p027 {
	public static void main(String[] args) {
		int max = Integer.MIN_VALUE;
		int maxProduct = 0;
		
		for(int a = -999; a <= 999; a++) {
			for(int b = -999; b <= 999; b++) {
				int n = 0;
				while(true) {
					if(!isPrime(n * n + (a * n) + b)) break;
					n++;
				}
				
				if(n > max) {
					max = n;
					maxProduct = a*b;
				}
			}
		}
		
		System.out.println(maxProduct);
	}
	
	private static boolean isPrime(int n) {
		if(n <= 1) return false;
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n%i==0) return false;
		}
		return true;
	}

}
