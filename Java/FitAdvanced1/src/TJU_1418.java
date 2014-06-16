import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TJU_1418 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int cases = Integer.parseInt(reader.readLine());
		
		for(int c = 0; c < cases; c++) {
			if(c != 0) System.out.println();
			
			String[] line = reader.readLine().split(" ");
			
			int height = Integer.parseInt(line[0]);
			int width = Integer.parseInt(line[1]);
			int days = Integer.parseInt(line[2]);
			
			char[][] board = new char[height][width];
			
			for(int y = 0; y < height; y++) {
				String l = reader.readLine();
				for(int x = 0; x < width; x++) {
					board[y][x] = l.charAt(x);
				}
			}
			
			int[] xDiff = new int[] {1,-1, 0, 0};
			int[] yDiff = new int[] {0,0,1,-1};
			
			for(int day = 0; day < days; day++) {
				//Update
				
				char[][] newBoard = new char[height][width];
				
				for(int y = 0; y < height; y++) {
					for(int x = 0; x < width; x++) {
						char current = board[y][x];
						char winner;
						
						if(current == 'R') {
							winner = 'P';
						} else if(current == 'P') {
							winner = 'S';
						} else {
							winner = 'R';
						}
						boolean winnerFound = false;
						for(int i = 0; i < 4; i++) {
							int newX = x + xDiff[i];
							int newY = y + yDiff[i];
							
							if(newY >= 0 && newY < height && newX >= 0 && newX < width) {
								if(board[newY][newX] == winner)  {
									winnerFound = true;
									break;
								}
							}
						}
						
						if(winnerFound) {
							newBoard[y][x] = winner;
						} else {
							newBoard[y][x] = current;
						}
						
					}
				}
				board = newBoard;
			}
			
			for(int y = 0; y < height; y++) {
				System.out.println(board[y]);
			}
		}

	}

}
