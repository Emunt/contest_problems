
public class p021 {
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 2; i < 10000; i++) {
			if(isAmicable(i)){
				System.out.println(i);
				sum += i; 
			}
		}
		System.out.println(sum);
	}
	
	private static boolean isAmicable(int n) {
		int sum = getDivisorSum(n);
		return sum != n && n == getDivisorSum(sum);
	}
	
	private static int getDivisorSum(int n) {
		int sum = 1;
		
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n % i == 0) {
				sum += i;
				if(n/i != i)
				sum += n / i;
			}
		}
		
		return sum;
	}

}
