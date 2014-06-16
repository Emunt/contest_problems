package startbreak;

import java.util.Scanner;

public class SwitchingLights {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int lights = kb.nextInt();
		int commands = kb.nextInt();
		
		boolean[] barns = new boolean[lights];
		
		for(int i = 0; i < commands; i++) {
			int command = kb.nextInt();
			int start = kb.nextInt() - 1;
			int end = kb.nextInt() - 1;
			
			if(command == 0) {
				setLights(barns, start, end);
			} else {
				System.out.println(getLights(barns, start, end));
			}
		}
	}
	
	private static void setLights(boolean[] arr, int start, int end) {
		for(int i = start; i <= end; i++) {
			arr[i] = !arr[i];
		}
	}
	private static int getLights(boolean[] arr, int start, int end) {
		int output = 0;
		
		for(int i = start; i <= end; i++) {
			if(arr[i]) output++;
		}
		
		return output;
	}

}
