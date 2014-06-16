package startbreak;

import java.util.Arrays;
import java.util.Scanner;

public class Vacation {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int testCases = kb.nextInt();
		for(int i = 0; i < testCases; i++) {
			int days = kb.nextInt();
			int cities = kb.nextInt();
			
			int[] arr = new int[cities];
			
			for(int j = 0; j < cities; j++) {
				arr[j] = kb.nextInt();
			}
			
			Arrays.sort(arr);
			int output = 0;
			for(int j = 0; j < cities; j++) {
				if(arr[j] <= days) {
					output++;
					days -= arr[j];
				}
			}
			
			System.out.println(output);
		}

	}

}
