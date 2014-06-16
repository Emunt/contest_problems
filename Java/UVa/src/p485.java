
//2/3/14
//Calculate Pascal's triangle until a term is greater than or equal
//to 10^60

public class p485 {
	public static void main(String[] args) {
		boolean done = false;
		int width = 1;
		String[] previous = new String[] {"1"};
		System.out.println("1");
		
		while(!done) {
			width++;
			String[] current = new String[width];
			
			for(int i = 0; i < current.length; i++) {
				String a = "0";
				if(i - 1 >= 0) {
					a = previous[i-1];
				}
				
				String b = "0";
				if(i < previous.length) {
					b = previous[i];
				}
				
				current[i] = strAdd(a, b);
				
				System.out.print(current[i]);
				if(i != current.length - 1) System.out.print(" ");
				
				if(current[i].length() > 60) done = true;
			}
			System.out.println();
			previous = current;
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
