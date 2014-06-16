package startbreak;

import java.util.Scanner;

public class TheQuadraticEquation {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		
		for(int i = 0; i < n; i++) {
			double a = kb.nextDouble();
			double b = kb.nextDouble();
			double c = kb.nextDouble();
			
			double sqr = Math.sqrt(Math.pow(b, 2) - (4 * a * c));
			double outputA = (-b - sqr) / (2 * a);
			double outputB = (-b + sqr) / (2 * a);
			if(Double.isNaN(outputA) || Double.isNaN(outputB)) {
				System.out.println("No solution!");
			} else if(outputA == outputB) {
				System.out.printf("%.3f\n", outputA);
			} else {
				System.out.printf("%.3f %.3f\n", outputA, outputB);
			}
		}
	}
}
