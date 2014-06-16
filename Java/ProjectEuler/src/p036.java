
public class p036 {
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 1; i < 1000000; i++) {
			if(isDoubleP(i)) sum += i;
		}
		
		System.out.println(sum);
	}
	
	public static boolean isDoubleP(int n) {
		String d = Integer.toString(n);
		String b = Integer.toBinaryString(n);
		
		for(int i = 0; i < d.length() / 2; i++) {
			if(d.charAt(i) != d.charAt(d.length() - i - 1)) return false;
		}
		for(int i = 0; i < b.length() / 2; i++) {
			if(b.charAt(i) != b.charAt(b.length() - i - 1)) return false;
		}
		return true;
	}

}
