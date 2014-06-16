import java.util.Scanner;


public class TrickorTreat2 {
	
	private static double epsilon = 10e-5;
	
	private static double[] xList;
	private static double[] yList;
	
	private static class Return {
		double minX = 0;
		double maxX = 0;
		boolean accepted = false;
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		while(true) {
			int n = kb.nextInt();
			
			xList = new double[n];
			yList = new double[n];
			
			double maxY = Double.MIN_VALUE;
			double minY = Double.MAX_VALUE;
			
			for(int i = 0; i <n; i++) {
				xList[i] = kb.nextDouble();
				yList[i] = kb.nextDouble();
				if(yList[i] < 0) yList[i] = -yList[i];
				maxY = Math.max(maxY, yList[i]);
			}
			
			
		}

	}
	
	private static boolean doesWork(double dist) {
		Return output = new Return();
		
		double maxX = Double.MAX_VALUE;
		double minX = Double.MIN_VALUE;
		
		for(int i = 0; i < xList.length; i++) {
			if(dist < yList[i]) return output;
		}
	}

}
