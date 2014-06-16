import java.util.Scanner;


public class BinomialShowdown {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		while(true) {
			int n = kb.nextInt();
			int k = kb.nextInt();
			if(n==0 && k==0) break;
			System.out.println(nChooseK(n,k));
		}
	}
	
	private static int nChooseK(int n, int k) {
		 long output = 1;
		 
		 int divisor;
		 int other;
		 
		 if(n - k > k) {;
			 divisor = n - k;
			 other = k;
		 } else {
			 divisor = k;
			 other = n-k;
		 }
		int counter = 2;
		for(int i = divisor + 1; i <= n; i++) {
			output *= i;
			
			if(counter <= other && output % counter == 0) {
				output /= counter;
				counter++;
			}
		}
		
		for(int i = counter; i <= other; i++) {
			output /= i;
		}
		
		return (int) output;
	}
}
