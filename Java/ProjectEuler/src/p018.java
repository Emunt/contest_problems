import java.util.Scanner;


public class p018 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int[][] triangle = new int[15][];
		for(int i = 0; i < triangle.length; i++) {
			triangle[i] = new int[i+1];
			for(int j = 0; j < i+1; j++) {
				triangle[i][j] = kb.nextInt();
			}
		}
		
		System.out.println(getMax(triangle));
		
		
	}

	private static int getMax(int[][] triangle) {
		for(int i = triangle.length-2; i >= 0; i--) {
			for(int j = 0; j < triangle[i].length; j++) {
				triangle[i][j] += Math.max(triangle[i+1][j],triangle[i+1][j+1]); 
			}
		}
		return triangle[0][0];
	}

}
