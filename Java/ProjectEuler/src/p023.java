
public class p023 {
	public static void main(String[] args) {
		boolean[] abundant = new boolean[28124];
		
		for(int i = 2; i < abundant.length; i++) {
			abundant[i] = isAbundant(i);
		}
		int sum = 0;
		for(int i = 1; i <= 28123; i++) {
			//Is i the sum of two abundant numbers?
			boolean isAbundant = false;
			for(int j = 12; j <= i/2; j++) {
				if(!abundant[j]) continue;
				if(abundant[i-j]) {
					isAbundant = true;
					break;
				}
			}
			if(!isAbundant) sum += i;
		}
		System.out.println(sum);
	}
	
	private static boolean isAbundant(int n) {
		int sum = 1;
		
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n % i == 0) {
				sum += i;
				if(i != Math.sqrt(n)) {
					sum += n/i;
				}
			}
		}	
		return sum > n;
	}

}
