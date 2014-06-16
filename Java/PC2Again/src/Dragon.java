import java.util.HashMap;
import java.util.Scanner;


public class Dragon {
	private static HashMap<String, Integer> h;
	
	private static int[][] swaps = {{1,8,6,3},{2,0,7,4},{3,1,8,5},{4,2,0,6},{5,3,1,7},{6,4,2,8},{7,5,3,0},{8,6,4,1},{0,7,5,2}};
	
	private static class Table {
		public int[][] board;
		
		public Table(int[][] b) {
			board = b;
		}
		//normalized
		public int get(int i) {
			return board[i%3][i/3];
		}
		
		public void set(int i, int number) {
			board[i%3][i/3] = number;
		}
		
		public int getZeroLocation() {
			for(int i = 0 ; i < 9; i++) {
				if(get(i) == 0) return i;
			}
			
			return -1;
		}
		
		public void swap(int i, int j) {
			int temp = get(i);
			set(i, get(j));
			set(j, temp);
		}
		
		public String toString() {
			StringBuilder b = new StringBuilder();
			for(int i = 0; i < board.length; i++) {
				for(int j = 0 ; j < board[i].length; j++) {
					b.append(board[j][i]);
				}
			}
			return b.toString();
		}
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		while(true) {
			int costHor = kb.nextInt();
			int costVert = kb.nextInt();
			
			if(costHor == 0 && costVert == 0) break;
			
			h = new HashMap<String, Integer>(362880);
			int[][] tempTable = new int[3][3];
			
			for(int y = 0 ; y < 3; y++) {
				for(int x = 0; x < 3; x++) {
					tempTable[x][y] = kb.nextInt();
				}
			}
			
			Table start = new Table(tempTable);
			
			tempTable = new int[3][3];
			
			for(int y = 0 ; y < 3; y++) {
				for(int x = 0; x < 3; x++) {
					tempTable[x][y] = kb.nextInt();
				}
			}
			
			Table end = new Table(tempTable);
			
			
			recurse(start, 0, costHor, costVert);
			System.out.println(h.get(end.toString()));
		}
	}
	
	private static void recurse(Table t, int currentCost, int costHor, int costVert) {
		if(h.containsKey(t.toString())) {
			if(currentCost < h.get(t.toString())) {
				h.put(t.toString(), currentCost);
			} else {
				return;
			}
			
		} else {
			h.put(t.toString(), currentCost);
		}
		
		int zeroLocation = t.getZeroLocation();
		
		int[] swapList = swaps[zeroLocation];
		
		for(int i = 0 ; i < swapList.length; i++) {
			int cost;
			if(i < 2) cost = costHor;
			else cost = costVert;
			
			t.swap(zeroLocation, swapList[i]);
			recurse(t, currentCost + cost, costHor, costVert);
			t.swap(zeroLocation, swapList[i]);
		}
	}
}
