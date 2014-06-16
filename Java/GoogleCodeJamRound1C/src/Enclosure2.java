import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Scanner;


public class Enclosure2 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int cases = kb.nextInt();
		
		for(int c = 1; c <= cases; c++) {
			
			int height = kb.nextInt();
			int width = kb.nextInt();
			int enclosed = kb.nextInt();
			
			System.out.println("Case #" + c + ": " + solve(height,width, enclosed));
		}
	}
	private static int minStones;
	private static int[] xDiff = new int[] {0,0,1,-1};
	private static int[] yDiff = new int[] {1,-1,0,0};
	
	private static int solve(int height, int width, int enclosed) {
		minStones = Integer.MAX_VALUE;
		boolean[][] board = new boolean[width][height];
		
		 recurse(board, 0, 0, 0, enclosed);
		 return minStones;
	}
	
	private static void recurse(boolean[][] board, int x, int y, int stones, int target) {
		for(int tempX = x; tempX < board.length; tempX++) {
			for(int tempY = y; tempY < board[0].length; tempY++) {
				board[tempX][tempY] = true;
				recurse(board,y+1,x,stones+1,target);
				board[tempX][tempY] = false;
			}
		}
		
		int enclosed = getEnclosed(board) + stones;
		
		if(enclosed == target) minStones = Math.min(minStones, stones);
	}
	
	private static int getEnclosed(boolean[][] board) {
		int sum = 0;
		for(int x = 0; x < board.length; x++) {
			for(int y = 0; y < board[0].length; y++) {
				if(!board[x][y]) {
					sum += flood(board, x,y);
				}
			}
		}
		
		return sum;
	}
	
	private static int flood(boolean[][] board, int x, int y) {
		ArrayDeque<Point> queue = new ArrayDeque<Point>();
		int sum = 1;
		boolean works = true;
		
		queue.addFirst(new Point(x, y));
		board[x][y] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.pollFirst();
			board[p.x][p.y] = true;
			sum++;
			if(p.x == 0 || p.x == board.length - 1 || p.y == 0 || p.y == board[0].length - 1) works = false;
			
			for(int i = 0; i < 4; i++) {
				int newX = p.x + xDiff[i];
				int newY = p.y + yDiff[i];
				
				if(newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
					if(!board[newX][newY]) {
						queue.addFirst(new Point(newX, newY));
					}
				}
				
			}
		}
		
		if(works) {
			return sum;
		} else {
			return 0;
		}
	}
	

}