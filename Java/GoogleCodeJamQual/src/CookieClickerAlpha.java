import java.util.Scanner;


public class CookieClickerAlpha {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int cases = kb.nextInt();
		
		for(int c = 0; c < cases; c++) {
			System.out.println("Case #" + (c+1) + ": " + solve(kb.nextDouble(), kb.nextDouble(), kb.nextDouble(), 2.0));
		}
	}
	
	private static double solve(double cost, double farm, double x, double rate) {
		if(fasterToBuy(cost, farm, x, rate)) {
			return solve(cost, farm, x, rate + farm) + (cost / rate);
		} else {
			return x / rate;
		}
	}
	
	private static boolean fasterToBuy(double cost, double farm, double x, double rate) {
		double timewithoutbuy = (x / rate);
		double timewithbuy = (cost / rate) + (x / (rate + farm));
		return timewithbuy < timewithoutbuy;
	}
}
