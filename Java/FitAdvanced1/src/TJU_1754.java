import java.util.Scanner;

//Doesn't work
public class TJU_1754 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		double x1 = kb.nextDouble();
		double y1 = kb.nextDouble();
		double r1 = kb.nextDouble();
		
		double x2 = kb.nextDouble();
		double y2 = kb.nextDouble();
		double r2 = kb.nextDouble();
		
		double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
		
		System.out.printf("%.3f\n", solve(distance, r1, r2));
	}

	private static double solve(double distance, double r1, double r2) {
		if(r1 + r2 <= distance) return 0;
		if(r1 + distance <= r2) return Math.PI * Math.pow(r1, 2);
		if(r2 + distance <= r1) return Math.PI * Math.pow(r2, 2);
		
		//Only cases left where the circles intersect
		
		
		
		return 0;
	}

}
