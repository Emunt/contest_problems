import java.util.Scanner;

//Accepted

public class EqualSumSets {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		while(true) {
			int n = kb.nextInt();
			int k = kb.nextInt();
			int s = kb.nextInt();
			
			if(n ==0 && k == 0 && s == 0) break;
			
			System.out.println(recurse(1, n, k, 0, s));
			
		}
	}
	
	private static int recurse(int i, int n, int numbersLeft, int sum, int sumLook) {
		if(numbersLeft == 0 && sum == sumLook) {
			return 1;
		}
		
		if(numbersLeft == 0) return 0;
		
		int tempSum = 0;
		for(; i <= n; i++) {
			tempSum += recurse(i+1, n, numbersLeft-1, sum + i, sumLook);
		}
		
		return tempSum;
	}

}
