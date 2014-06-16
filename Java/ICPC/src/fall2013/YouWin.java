package fall2013;

import java.util.Scanner;

public class YouWin {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		while(true) {
			String in = kb.next();
			if(in.equals("0")) break;
			System.out.println(solution(in));
		}
	}
	
	private static int solution(String str) {
		
	}

}
