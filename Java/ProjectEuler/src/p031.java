
public class p031 {
	public static void main(String[] args) {
		int[] coins = {200, 100, 50, 20, 10, 5, 2, 1};
		System.out.println(getNumber(coins, 200, 0));
	}
	
	private static int getNumber(int[] coins, int cap, int start) {
		if(cap == 0) return 1;
		
		int sum = 0;
		
		for(int i = start; i < coins.length; i++) {
			if(cap >= coins[i]) {
				sum += getNumber(coins, cap - coins[i], i);
			}
		}
		
		return sum;
	}

}
