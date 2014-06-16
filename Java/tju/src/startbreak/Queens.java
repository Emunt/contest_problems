package startbreak;

import java.util.Scanner;

public class Queens {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		while(true) {
			int height = kb.nextInt();
			int width = kb.nextInt();
			
			if(height == 0 && width == 0) break;
			
			char[][] board = new char[width][height];
			
			int queens = kb.nextInt();
			
			for(int i = 0; i < queens; i++) {
				int y = kb.nextInt() - 1;
				int x = kb.nextInt() - 1;
				
				board[x][y] = 'Q';
			}
			
			int knights = kb.nextInt();
			
			for(int i = 0; i < knights; i++) {
				int y = kb.nextInt() - 1;
				int x = kb.nextInt() - 1;
				
				board[x][y] = 'K';
			}
			
			int pawns = kb.nextInt();
			
			for(int i = 0; i < pawns; i++) {
				int y = kb.nextInt() - 1;
				int x = kb.nextInt() - 1;
				
				board[x][y] = 'P';
			}
			
			
			System.out.println(solve(board, width, height));
		}
		
	}

	private static int solve(char[][] board, int width, int height) {
		
		return 0;
	}
	
	private static void queen(char[][] board, int width, int height, int xPos, int yPos) {
		
		//up
		for(int y = yPos; y >= 0; y--) {
			if(board[xPos][y] == 'Q' || board[xPos][y] == 'K' || board[xPos][y] == 'P') break;
			board[xPos][y] = '!';
		}
		
		//down
		for(int y = yPos; y < height; y++) {
			if(board[xPos][y] == 'Q' || board[xPos][y] == 'K' || board[xPos][y] == 'P') break;
			board[xPos][y] = '!';
		}

		//left
		for(int x = xPos; x >= 0; x--) {
			if(board[x][yPos] == 'Q' || board[x][yPos] == 'K' || board[x][yPos] == 'P') break;
			board[x][yPos] = '!';
		}
		
		//Right
		for(int x = xPos; x >= 0; x--) {
			if(board[x][yPos] == 'Q' || board[x][yPos] == 'K' || board[x][yPos] == 'P') break;
			board[x][yPos] = '!';
		}
		
		//Up diag
		int i;
		while(true) {
			
		}
	}
	
	private static void knight(char[][] board, int width, int height, int x, int y) {
		
	}
}
