import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Scanner;

public class p4504_2 {
	//A pair of doubles used to simplify getOptimalX() return
	private static class XDist {
		public double x;
		public double dist;
		
		public XDist(double x, double dist) {
			this.x = x;
			this.dist = dist;
		}
		
		@Override
		public String toString() {
			return x + " " + dist;
		}
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		while(true) {
			int nHouses = kb.nextInt();
			if(nHouses == 0) break;
			
			ArrayList<Point2D> houses = new ArrayList<Point2D>(nHouses);
			
			for(int i = 0; i < nHouses; i++) {
				Point2D pt = new Point2D.Double(kb.nextDouble(), Math.abs(kb.nextDouble()));
				houses.add(pt);
			}
			
			//Solve
			XDist minimum = new XDist(0, Double.MIN_VALUE);
			
			for(int i = 0; i < houses.size() - 1; i++) {
				Point2D a = houses.get(i);
				for(int j = i+1; j < houses.size(); j++) {
					Point2D b = houses.get(j);
					XDist current = getOptimalX(a, b);
					
					if(current.dist > minimum.dist) {
						minimum = current;
					}
				}
			}
			
			System.out.println(minimum);
		}
	}
	
	//How do you know the one when you find him...
	
	//Returns the optimal x location given two points
	private static XDist getOptimalX(Point2D a, Point2D b) {
		if(a.getY() > getDist(b, new Point2D.Double(a.getX(),0))) return new XDist(a.getX(), a.getY());
		if(b.getY() > getDist(a, new Point2D.Double(b.getX(),0))) return new XDist(b.getX(), b.getY());
		double middle = getMiddle(a,b);
		return new XDist(middle, getDist(new Point2D.Double(middle, 0), a));
	}
	
	private static double getMiddle(Point2D a, Point2D b) {
		double dist = b.getX() - a.getX();
		double width = (Math.pow(dist, 2) + Math.pow(b.getY(), 2) - Math.pow(a.getY(), 2)) / (2 * dist);
		return width + a.getX();
	}
	
	
	private static double getDist(Point2D a, Point2D b) {
		return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY()-b.getY(), 2));
	}
	
}

