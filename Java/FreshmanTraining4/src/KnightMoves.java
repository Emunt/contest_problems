import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class KnightMoves {
	private static class Node {
		Point p;
		int cost;
		
		Node(Point p, int c) {
			this.p = p;
			this.cost = c;
		}
	}
	
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		while(kb.hasNext()) {
			String startS = kb.next();
			String endS = kb.next();
			
			System.out.println("To get from " + startS + " to " + endS + " takes " + solve(new Point(startS.charAt(0) - 'a', startS.charAt(1) - '1'), new Point(endS.charAt(0) - 'a', endS.charAt(1) - '1')) + " knight moves.");
		}
	}

	private static int solve(Point start, Point end) {
		int[][] table = new int[8][8];
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				table[i][j] = 5000;
			}
		}
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(new Node(start, 0));
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			if(n.p.x >= 0 && n.p.y >= 0 && n.p.x < 8 && n.p.y < 8) {
				if(n.cost < table[n.p.x][n.p.y]) {
					table[n.p.x][n.p.y] = n.cost;	
					queue.add(new Node(new Point(n.p.x+2, n.p.y+1), n.cost + 1));
					queue.add(new Node(new Point(n.p.x+1, n.p.y+2), n.cost + 1));
					queue.add(new Node(new Point(n.p.x-2, n.p.y+1), n.cost + 1));
					queue.add(new Node(new Point(n.p.x+1, n.p.y-2), n.cost + 1));
					queue.add(new Node(new Point(n.p.x+2, n.p.y-1), n.cost + 1));
					queue.add(new Node(new Point(n.p.x-1, n.p.y+2), n.cost + 1));
					queue.add(new Node(new Point(n.p.x-2, n.p.y-1), n.cost + 1));
					queue.add(new Node(new Point(n.p.x-1, n.p.y-2), n.cost + 1));
				}
			}
		}
		return table[end.x][end.y];
	}
}
