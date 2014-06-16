package startbreak;

import java.util.Scanner;

public class Cube {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int cases = kb.nextInt();
		
		for(int i = 0 ; i < cases; i++) {
			int cube = kb.nextInt();
			calculate(cube);
		}
	}
	
	private static void calculate(int cube) {
		int start = (cube * cube) - (cube - 1);
		System.out.println(start + " " + (start + ((cube - 1) * 2)));
	}
}
