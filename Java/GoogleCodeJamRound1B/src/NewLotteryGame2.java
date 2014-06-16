import java.math.BigInteger;
import java.util.Scanner;


public class NewLotteryGame2 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int cases = kb.nextInt();
		
		for(int c = 1; c <= cases; c++) { {
			long a = kb.nextInt();
			long b = kb.nextInt();
			long k = kb.nextInt();
			
			
			System.out.println("Case #" + c  + ": " + solve(a,b,k).toString());
		}
		}

	}

	private static BigInteger solve(long a, long b, long k) {
		BigInteger output = new BigInteger("0");
		for(long i = 0; i < k; i++) {
			output = output.add(new BigInteger(Long.toString(solveOne(a,b,i))));
		}
		
		return output;
	}
	
	private static long solveOne(long a, long b, long k) {
		
	}

}
