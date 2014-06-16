import java.util.Scanner;


public class p10183 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		while(true) {
			String a = kb.next();
			String b = kb.next();
			
			if(a.equals("0") && b.equals("0")) break;
			
			int output = 0;
			String first = "1";
			String second = "0";
			while(true) {
				String temp = strAdd(first, second);
				if(compare(temp, b) > 0) break;
				if(compare(temp, a) >= 0) output++;
				
				second = first;
				first = temp;
			}
			
			System.out.println(output);
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
	
	private static int compare(String a, String b) {
		if(a.length() != b.length()) return a.length() - b.length();
		
		for(int i = 0; i < a.length(); i++) {
			if(a.charAt(i) != b.charAt(i)) return a.charAt(i) - b.charAt(i); 
		}
		
		return 0;
	}
}
