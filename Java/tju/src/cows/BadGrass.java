package cows;

import java.awt.Point;
import java.util.Scanner;
import java.util.Stack;

public class BadGrass {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int rows = kb.nextInt();
		int cols = kb.nextInt();
		boolean[][] table = new boolean[cols][rows];
		for(int y = 0; y < rows; y++) {
			for(int x = 0; x < cols; x++) {
				table[x][y] = (kb.nextInt() > 0);
			}
		}
		int counter = 0;
		for(int y = 0; y < rows; y++) {
			for(int x = 0; x < cols; x++) {
				if(table[x][y]) {
					counter++;
					floodFill(table,x,y);
				}
			}
		}
		System.out.println(counter);
	}
	
	
	private static void floodFill(boolean[][] table, int x, int y) {
		Stack<Point> q = new Stack<Point>();
		q.push(new Point(x, y));
		
		while(!q.isEmpty()) {
			Point N = q.pop();
			if(N.x < 0 || N.y < 0) continue;
			if(N.x >= table.length || N.y >= table[0].length) continue;
			if(table[N.x][N.y]){
				table[N.x][N.y] = false;
				q.push(new Point(N.x-1,N.y));
				q.push(new Point(N.x+1,N.y));
				q.push(new Point(N.x,N.y+1));
				q.push(new Point(N.x,N.y-1));
				q.push(new Point(N.x-1,N.y-1));
				q.push(new Point(N.x+1,N.y+1));
				q.push(new Point(N.x-1,N.y+1));
				q.push(new Point(N.x+1,N.y-1));
			}
		}
	}

}
