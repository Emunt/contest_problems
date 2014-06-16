import java.util.Scanner;


public class B {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int cases = kb.nextInt();
		
		for(int c = 1; c <= cases; c++) {
			int n = kb.nextInt();
			
			int[] numbers = new int[n];
			
			for(int i = 0; i < n; i++) {
				numbers[i] = kb.nextInt();
			}
			
			int output = 0;
			
			
			
			System.out.println("Case #" + c + ": " + output);
			
		}

	}

}
