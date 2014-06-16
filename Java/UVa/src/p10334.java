import java.util.Scanner;


public class p10334 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String[] fib = new String[1001];
		fib[0] = "1";
		fib[1] = "2";
		for(int i = 2; i < fib.length; i++) {
			fib[i] = strAdd(fib[i-1], fib[i-2]);
		}
		
		while(kb.hasNextInt()) {
			System.out.println(fib[kb.nextInt()]);
		}
		
	}
	
	private static String strAdd(String a, String b) {
		StringBuilder out = new StringBuilder();
		int carry = 0;
		for(int i = 0; i < Math.max(a.length(), b.length()); i++) {
			int digitA = 0;
			if(i < a.length()) {
				digitA = a.charAt(a.length() - i - 1) - '0';
			}
			
			int digitB = 0;
			if(i < b.length()) {
				digitB = b.charAt(b.length() - i - 1) - '0';
			}
			
			int sum = digitB + digitA + carry;
			out.append(sum % 10);
			carry = sum / 10;
		}
		if(carry != 0) out.append(carry);
		return out.reverse().toString();
	}

}
