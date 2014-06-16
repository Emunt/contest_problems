
public class p034 {
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 10; i < 5000000; i++) {
			if(i == getFactSum(i)) sum += i;
		}
		System.out.println(sum);
	}

	private static long getFactSum(int n) {
		long sum = 0;
		while(n > 0) {
			sum += fact(n%10);
			n /= 10;
		}
		return sum;
	}
	
	private static int fact(int n) {
		if(n == 0) return 1;
		return n * fact(n-1);
	}
}
