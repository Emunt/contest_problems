import java.util.Scanner;

//Calculates the largest product of consecutive digits in a string

public class p008 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String s = "";
		while(kb.hasNextLine()) {
			s += kb.nextLine();
		}
		System.out.println(largestSum(s));

	}
	
	private static int largestSum(String s) {
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < s.length() - 5; i++) {
			int product = 1;
			for(int j = 0 ; j < 5; j++) {
				product *= s.charAt(i + j) - '0';
			}
			max = Math.max(product, max);
		}
		return max;
	}
}
