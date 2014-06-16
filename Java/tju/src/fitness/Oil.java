package fitness;

import java.awt.Point;
import java.util.Scanner;
import java.util.Stack;



public class Oil {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		while(true) {
			int lines = kb.nextInt();
			int characters = kb.nextInt();
			
			if(lines == 0 && characters == 0) break;
			
			boolean[][] table = new boolean[characters][lines];
			kb.nextLine();
			
			for(int i = 0; i < lines; i++) {
				String line = kb.nextLine();
				for(int j = 0; j < characters; j++) {
					table[j][i] = (line.charAt(j) == '@');
				}
			}
			int sum = 0;
			for(int i = 0; i < lines; i++) {
				for(int j = 0; j < characters; j++) {
					if(table[j][i]) {
						floodFill(table, j, i);
						sum++;
					}
				}
			}
			System.out.println(sum);
		}

	}

	private static void floodFill(boolean[][] table, int x, int y) {
		Stack<Point> stack = new Stack<Point>();
		
		
		stack.push(new Point(x,y));
		
		while(!stack.isEmpty()) {
			Point p = stack.pop();
			if(p.x < 0 || p.y < 0) continue;
			if(p.x >= table.length || p.y >= table[0].length) continue;
			if(!table[p.x][p.y]) continue;
			
			table[p.x][p.y] = false;
			
			stack.push(new Point(p.x+1,p.y));
			stack.push(new Point(p.x,p.y+1));
			stack.push(new Point(p.x-1,p.y));
			stack.push(new Point(p.x,p.y-1));
			stack.push(new Point(p.x+1,p.y+1));
			stack.push(new Point(p.x-1,p.y-1));
			stack.push(new Point(p.x+1,p.y-1));
			stack.push(new Point(p.x-1,p.y+1));
			
		}
	}

}
