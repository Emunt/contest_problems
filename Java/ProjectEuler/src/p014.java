import java.util.HashMap;


public class p014 {
	private static HashMap<Long, Long> hash = new HashMap<>();
	
	public static void main(String[] args) {
		long max = Integer.MIN_VALUE;
		long number = 0;
		for(int i = 1; i < 1000000; i++) {
			long length = getLength(i);
			
			if(length > max) {
				max = length;
				number = i;
			}
		}
		
		System.out.println(number);
	}
	
	private static long getLength(long n) {
		if(n == 1) return 1;
		
		if(hash.containsKey(n)) return hash.get(n);
		
		long length;
		if(n % 2 == 0) {
			length = getLength(n/2) + 1;
		} else {
			length = getLength(3 * n + 1) + 1;
		}
		
		hash.put(n, length);
		return length;
	}

}
