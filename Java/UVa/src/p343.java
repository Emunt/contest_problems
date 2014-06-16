import java.util.Scanner;

//2/2/14
//Find out if two numbers are the same in two likely different 
//bases between 2 and 36

public class p343 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		while(kb.hasNext()) {
			String a = kb.next();
			String b = kb.next();
			solve(a,b);
		}

	}
	
	
	private static void solve(String a, String b) {
		int maxA = 2;
		for(int i = 0; i < a.length(); i++) {
			maxA = Math.max(maxA, getNum(a.charAt(i))+1);
		}
		
		int maxB = 2;
		for(int i = 0; i < b.length(); i++) {
			maxB = Math.max(maxB, getNum(b.charAt(i))+1);
		}
		
		for(int baseA = maxA; baseA <= 36; baseA++) {
			for(int baseB = maxB; baseB <= 36; baseB++) {
				if(convert(a, baseA) == convert(b, baseB)) {
					System.out.println(a + " (base " + baseA + ") = " + b + " (base " + baseB+")");
					return;
				}
			}
		}
		System.out.println(a + " is not equal to " + b + " in any base 2..36");
	}
	
	private static int convert(String str, int base) {
		int sum = 0;
		for(int i = 0; i < str.length(); i++) {
			sum += getNum(str.charAt(str.length() - 1 - i)) * (int) Math.pow(base, i);
		}
		return sum;
	}
	
	private static int getNum(char c) {
		if(c - '0' >= 0 && c - '0' <= 9) return c - '0';
		return c - 'A' + 10;
	}
}
