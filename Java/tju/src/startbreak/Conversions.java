package startbreak;

import java.util.Scanner;

public class Conversions {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int cases = kb.nextInt();
		
		for(int i = 0; i < cases; i++) {
			double n = kb.nextDouble();
			String command = kb.next();
			System.out.print(i+1 + " ");
			if(command.equals("kg")) {
				System.out.printf("%.4f lb\n" , n * 2.2046);
			} else if(command.equals("lb")) {
				System.out.printf("%.4f kg\n" , n * .4536);
			} else if(command.equals("l")) {
				System.out.printf("%.4f g\n" , n * .2642);
			} else {
				System.out.printf("%.4f l\n" , n * 3.7854);
			}
		}

	}

}
