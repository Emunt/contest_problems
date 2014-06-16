//Calculates the largest palendrome that is the product of two 3 digit
//numbers
public class p004 {
	public static void main(String[] args) {
		int max = Integer.MIN_VALUE;
		for(int i = 100; i < 999; i++) {
			for(int j = 100; j < 999; j++) {
				int p = i * j;
				if(isPalendrome(p)) {
					max = Math.max(max, p);
				}
			}
		}
		System.out.println(max);
	}
	
	private static boolean isPalendrome(int a) {
		String strA = Integer.toString(a);
		for(int i = 0; i < strA.length()/2; i++) {
			if(strA.charAt(i) != strA.charAt(strA.length() - i - 1)) return false;
		}
		return true;
	}
	
}
