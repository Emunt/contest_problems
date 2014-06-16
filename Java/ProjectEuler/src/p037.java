
public class p037 {
	public static void main(String[] args) {
		int sum = 0;
		int found = 0;
		int i = 10;
		while(found < 11) {
			if(isTrunc(i)) {
				sum += i;
				found++;
				System.out.println(i);
			}
			i++;
		}
		System.out.println();
		System.out.println(sum);

	}
	
	private static boolean isTrunc(int n) {
		String nStr = Integer.toString(n);
		//left
		for(int i = 0 ; i < nStr.length(); i++) {
			if(!isPrime(Integer.parseInt(nStr.substring(i)))) return false;
		}
		for(int i = nStr.length(); i > 0; i--) {
			if(!isPrime(Integer.parseInt(nStr.substring(0, i)))) return false;
		}
		return true;
	}
	private static boolean isPrime(int n) {
		if(n==1 || n == 0) return false;
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n%i == 0) return false;
		}
		return true;
	}

}
