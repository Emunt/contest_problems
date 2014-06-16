import java.util.Scanner;


public class CantoringAlong {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		char[][] bList= new char[13][];
		for(int i = 0; i <= 12; i++) {
			int n = (int) Math.pow(3, i);
			char[] b = new char[n];
			
			cantor(b, 0, b.length);
			bList[i] = b;
		}
		
		while(kb.hasNextInt()) {
			char[] b = bList[kb.nextInt()];
			
			System.out.println(b);
		}
	}
	
	static void cantor(char[] b, int start, int end) {
		if(start + 1== end) {
			b[start] = '-';
			return;
		}
		int range = end - start;
		
		cantor(b, start, start + range / 3);
		
		for(int i = start + range / 3; i < start + (2*range) / 3; i++) {
			b[i] = ' ';
		}
		
		cantor(b, start + (2*range) / 3, end);
	}
}
