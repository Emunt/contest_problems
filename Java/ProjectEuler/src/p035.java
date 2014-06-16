
public class p035 {
	public static void main(String[] args) {
		long sum = 0;
		for(int i = 2; i < 1000000; i++) {
			if(isCircular(i)) {
				sum++;
			}
		}
		System.out.println(sum);
	}
	
	private static boolean isCircular(int n) {
		String nStr = Integer.toString(n);
		
		for(int start = 0; start < nStr.length(); start++) {
			String currentPrime = "";
			for(int i = 0; i < nStr.length(); i++) {
				currentPrime += nStr.charAt((i + start) % nStr.length());
			}
			if(!isPrime(Integer.parseInt(currentPrime))) return false;
		}
		return true;
	}
	
	private static boolean isPrime(int n) {
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n%i == 0) return false;
		}
		return true;
	}

}
