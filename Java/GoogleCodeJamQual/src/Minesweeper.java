import java.util.Scanner;


public class Minesweeper {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int cases = kb.nextInt();
		
		for(int c = 1; c <= cases; c++) {
			int rows = kb.nextInt();
			int columns = kb.nextInt();
			int mines = kb.nextInt();
			
			char[][] output = solve(rows, columns, mines);
			System.out.println("Case #" + c + ":");
			if(output == null) {
				System.out.println("Impossible");
			} else {
				for(int y = 0; y < output.length; y++) {
					System.out.println(output[y]);
				}
			}
		}
	}
	
	private static char[][] solve(int height, int width, int mines) {
		char[][] output = new char[height][width];
		
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				output[y][x] = '*';
			}
		}
		output[0][0] = 'c';
		
		int totalMines = width*height;
		
		if(mines + 1 == totalMines) return output;
		
		if(width == 1) {
			fill(1,totalMines - mines,output);
			return output;
		}
		if(height == 1) {
			fill(totalMines - mines,1, output);
			return output;
		}
		
		for(int w1 = 2; w1 <= width; w1++) {
			for(int h1 = 2; h1 <= height; h1++) {
				for(int w2 = 2; w2 <= width; w2++) {
					for(int h2 = 2; h2 <= height; h2++) {
						int area1 = w1*h1;
						int area2 = w2*h2;
						int extraArea = Math.min(w1, w2)*Math.min(h1, h2);
						if(area1+area2-extraArea == totalMines-mines) {
							fill(w1,h1,output);
							fill(w2,h2,output);
							return output;
						}
					}
				}

			}
		}
		
		return null;
	}
	
	private static void fill(int width, int height, char[][] table) {
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				if(x != 0 || y!=0) {
					table[y][x] = '.';
				}
			}
		}
	}
}
