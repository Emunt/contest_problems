import java.util.Scanner;


public class SumOfFactorials {
	private static int[] fact = new int[11];
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		fact[0] = 1;
		for(int i = 1; i < fact.length; i++) {
			fact[i] = fact[i-1] * i;
		}
		
		while(kb.hasNext()) {
			int n = kb.nextInt();
			if(n < 0) break;
			if(n != 0 && solve(n, 0, 0)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
	
	private static boolean solve(int n, int index, int sum) {
		if(sum == n) return true;
		if(sum > n) return false;
		boolean output = false;
		for(int i = index; i < fact.length; i++) {
			if(solve(n,i+1, sum + fact[i])) {
				output = true;
			}
		}
		
		return output;
	}
}
