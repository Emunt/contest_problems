package pun;

import java.util.Scanner;

public class Robots {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		loop: while(true) {
			boolean map[][] = new boolean[24][24];
			int number = 0;
			while(true) {
				int x = kb.nextInt();
				int y = kb.nextInt();
				if(x == -1 && y == -1) break loop;
				if(x == 0 && y == 0) break;
				map[x-1][y-1] = true;
				number++;
			}
			
			System.out.println(cost(map, number));
			
		}
	}
	
	private static int cost(boolean[][] table, int n) {
		int output = 0;
		while(n > 0) {
			output++;
			int pos = 0;
			for(int i = 0; i < 24; i++) {
				for(int j = pos; j < 24; j++) {
					if(table[i][j]) {
						pos = j;
					}
				}
				if(table[i][pos]) {
					table[i][pos] = false;
					n--;
					break;
				}
				
			}
		}
		return output;
	}
}
