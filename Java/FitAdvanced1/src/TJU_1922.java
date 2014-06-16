import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class TJU_1922 {
	private static int[] xDiff = new int[]{0,0,1,-1,1,-1,1,-1};
	private static int[] yDiff = new int[]{1,-1,0,0,1,-1,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] line = reader.readLine().split(" ");
			int height = Integer.parseInt(line[0]);
			int width = Integer.parseInt(line[1]);
			int yClick = Integer.parseInt(line[2]);
			int xClick = Integer.parseInt(line[3]);
			
			if(height == 0 && width == 0 && yClick == 0 && xClick == 0) break;
			
			char[][] grid = new char[height][width];
			char[][] staticGrid = new char[height][width];
			
			
			for(int y = 0; y < height; y++) {
				String l = reader.readLine();
				for(int x = 0; x < width; x++) {
					grid[y][x] = l.charAt(x);
					staticGrid[y][x] = l.charAt(x);
				}
			}
			
			System.out.println(solve(grid, staticGrid, yClick-1,xClick-1));
		}
	}

	private static int solve(char[][] grid, char[][] staticGrid, int yClick, int xClick) {
		Stack<Point> stk = new Stack<Point>();
		
		stk.push(new Point(xClick,yClick));
		grid[yClick][xClick] = '.';
		int sum = 0;
		
		while(!stk.isEmpty()) {
			Point current = stk.pop();

			
			//Get perim
			for(int i = 0; i < 4; i++) {
				int newX = current.x + xDiff[i];
				int newY = current.y + yDiff[i];
				if(newX >= 0 && newX < grid[0].length && newY >= 0 && newY < grid.length) {
					if(staticGrid[newY][newX] != 'X') sum++;
				} else {
					sum++;
				}
			}
			
			for(int i = 0; i < 8; i++) {
				int newX = current.x + xDiff[i];
				int newY = current.y + yDiff[i];
				if(newX >= 0 && newX < grid[0].length && newY >= 0 && newY < grid.length) {
					if(grid[newY][newX] == 'X') {
						stk.push(new Point(newX,newY));
						grid[newY][newX] = '.';
					}
				}
			}
		}
		
		return sum;
	}
	

}
