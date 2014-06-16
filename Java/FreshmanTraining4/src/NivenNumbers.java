import java.util.Scanner;


public class NivenNumbers {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		while(true) {
			int base = kb.nextInt();
			if(base == 0) break;
			
			String number = kb.next();
			
			if(getNumber(number, base) % getDigitSum(number) == 0) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
	
	private static int getNumber(String number, int base) {
		int sum = 0;
		
		for(int i = 0; i < number.length();i++) {
			sum += (number.charAt(i) - '0') * (int) Math.pow(base, number.length() - i - 1);
		}
		
		return sum;
	}
	
	private static int getDigitSum(String number) {
		int output = 0;
		
		for(int i = 0; i < number.length(); i++) {
			output += number.charAt(i) - '0';
		}
		
		return output;
	}

}
