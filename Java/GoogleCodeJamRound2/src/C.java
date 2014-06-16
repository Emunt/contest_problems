import java.util.Arrays;
import java.util.Scanner;


public class C {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int cases = kb.nextInt();
		
		for(int c = 1; c <= cases; c++) {
			int n = kb.nextInt();
			int capacity = kb.nextInt();
			
			int[] files = new int[n];
			
			for(int i = 0; i < n; i++) {
				files[i] = kb.nextInt();
			}
			
			Arrays.sort(files);
			
			int start = 0;
			int end = files.length-1;
			int CD = 0;	
			while(end >= start) {
				CD++;
				int left = capacity - files[end--];
				
				if(left >= files[start]) {
					start++;
				}
			}
			
			System.out.println("Case #" + c + ": " + CD);
		}
	}

}
