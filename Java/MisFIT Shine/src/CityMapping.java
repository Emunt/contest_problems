import java.util.Scanner;


public class CityMapping {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = 1;
		while(true) {
			int height = kb.nextInt();
			int width = kb.nextInt();
			int instructions = kb.nextInt();
			
			if(height == 0 && width == 0 && instructions == 0) break;
			
			System.out.println("Scenario #" + n + ":");
			
			char[][] table = new char[width][height];
			
			for(int x = 0; x < table.length; x++) {
				for(int y = 0; y < table[0].length; y++) {
					table[x][y] = '.';
				}
			}
			
			table[0][0] = '+';
			
			int posX = 0;
			int posY = 0;
			for(int i = 0 ; i < instructions; i++) {
				String instruction = kb.next();
				int length = kb.nextInt();
				char fill;
				int dx = 0;
				int dy = 0;
				if(instruction.equals("South")) {
					fill = '|';
					dy = 1;
				} else if(instruction.equals("North")) {
					fill = '|';
					dy = -1;
				} else if(instruction.equals("East")) {
					fill = '-';
					dx = 1;
				} else { //West
					fill = '-';
					dx = -1;
				}
				
				for(int j = 0 ; j < length; j++) {
					posX += dx;
					posY += dy;
					if(table[posX][posY] != '.') {
						table[posX][posY] = '+';
					} else {
						table[posX][posY] = fill;
					}
				}
				table[posX][posY] = '+';
			}
			
			for(int y = 0 ; y < table[0].length; y++) {
				for(int x = 0; x < table.length; x++) {
					System.out.print(table[x][y]);
				}
				System.out.println();
			}
			n++;
		}
	}
}
