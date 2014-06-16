package startbreak;

import java.util.Scanner;

public class TicTacToe {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int cases = kb.nextInt();

		
		for(int i = 0 ; i < cases; i++) {
			char[][] table = new char[3][3];
			for(int y = 0; y < 3; y++) {
				String line = kb.next();
				for(int x = 0; x < 3; x++) {
					table[x][y] = line.charAt(x);
				}
			}
			
			//Solve here
			
			if(getValid(table)) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
	
	private static boolean getValid(char[][] table) {
		int X = getNumber(table, 'X');
		int O = getNumber(table, 'O');
		if(O > X) return false;
		if(O < X && O != X - 1) return false;
		if(isWinner(table, 'X') && isWinner(table, 'O')) return false;
		
		if(isWinner(table, 'X')) {
			if(O != X -1) return false;
		}
		
		if(isWinner(table, 'O')) {
			if(O != X) return false;
		}
		
		return true;
	}
	
	private static boolean isWinner(char[][] table, char player) {
		if(table[0][0] == player && table[0][1] == player && table[0][2] == player) return true;
		if(table[1][0] == player && table[1][1] == player && table[1][2] == player) return true;
		if(table[2][0] == player && table[2][1] == player && table[2][2] == player) return true;
		
		if(table[0][0] == player && table[1][0] == player && table[2][0] == player) return true;
		if(table[0][1] == player && table[1][1] == player && table[2][1] == player) return true;
		if(table[0][2] == player && table[1][2] == player && table[2][2] == player) return true;
		
		if(table[0][0] == player && table[1][1] == player && table[2][2] == player) return true;
		if(table[0][2] == player && table[1][1] == player && table[2][0] == player) return true;
		
		return false;
	}
	
	private static int getNumber(char[][] table, char player) {
		int output = 0;
		for(int i = 0 ; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(table[i][j] == player) output++;
			}
		}
		
		return output;
	}

}
