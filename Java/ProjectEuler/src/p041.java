
public class p041 {
	public static void main(String[] args) {
		int i;
		
		for(i = 7654321; i >= 2; i--) {
			if(isPrime(i) && isNPandigital(i)) break;
			System.out.println(i);
		}
		
		System.out.println(i);
	}
	
	private static boolean isPrime(int n) {
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n%i == 0) return false;
		}
		return true;
	}
	
	private static boolean isNPandigital(int n) {
		String nStr = Integer.toString(n);
		int i;
		for(i = 1; i < 10; i++) {
			if(!nStr.contains(Integer.toString(i))) break;
		}
		
		return nStr.length() == i-1;
	}

}
