import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Scanner;

public class p4504 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		while(true) {
			int nHouses = kb.nextInt();
			if(nHouses == 0) break;
			
			ArrayList<Point2D> houses = new ArrayList<Point2D>(nHouses);
			
			for(int i = 0; i < nHouses; i++) {
				Point2D pt = new Point2D.Double(kb.nextDouble(), kb.nextDouble());
				houses.add(pt);
			}
			
			double low = -200000;
			double high = 200000;
			double min = Double.MAX_VALUE;
			double point = 0;
			
			while(high - low > 0) {
				double mid = (low + high) / 2;
				
				double lowMax = getMaxDist(houses, new Point2D.Double(low, 0));
				double highMax = getMaxDist(houses, new Point2D.Double(high, 0));
				
				if(lowMax < highMax) {
					if(lowMax < min) {
						min = lowMax;
						point = low;
					}
					
					high = mid;
				} else {
					if(highMax < min) {
						min = highMax;
						point = high;
					}
					
					low = mid;
				}
			}
			
			System.out.println(point + " " + getMaxDist(houses, new Point2D.Double(point, 0)));
			
		}
	}
	
	private static double getMaxDist(ArrayList<Point2D> houses, Point2D pt) {
		double max = Double.MIN_VALUE;
		
		for(Point2D house : houses) {
			double dist = getDist(house, pt);
			max = Math.max(max, dist);
		}
		
		return max;
	}
	
	private static double getDist(Point2D a, Point2D b) {
		return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY()-b.getY(), 2));
	}
	
}

