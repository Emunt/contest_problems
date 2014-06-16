import java.util.Scanner;


public class p011 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int[][] grid = new int[20][20];
		
		for(int y = 0; y < 20; y++) {
			for(int x = 0; x < 20; x++) {
				grid[x][y] = kb.nextInt();
			}
		}
		int max = Integer.MIN_VALUE;
		
		for(int y = 0; y < 20; y++) {
			for(int x = 0; x < 20; x++) {
				if(x + 3 < 20) {
					int product = 1;
					for(int i = 0 ; i < 4; i++) {
						product *= grid[x+i][y];
					}
					max = Math.max(max, product);
				}
				if(y + 3 < 20) {
					int product = 1;
					for(int i = 0 ; i < 4; i++) {
						product *= grid[x][y+i];
					}
					max = Math.max(max, product);
				}
				if(x + 3 < 20 && y + 3 < 20) {
					int product = 1;
					for(int i = 0 ; i < 4; i++) {
						product *= grid[x+i][y+i];
					}
					max = Math.max(max, product);
				}
				
				if(x + 3 < 20 && y - 3 >= 0) {
					int product = 1;
					for(int i = 0 ; i < 4; i++) {
						product *= grid[x+i][y-i];
					}
					max = Math.max(max, product);
				}
			}
		}
		System.out.println(max);
	}
}
