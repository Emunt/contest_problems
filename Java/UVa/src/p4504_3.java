import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class p4504_3 {
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
			double leftMost = Double.MAX_VALUE;
			double rightMost = Double.MIN_VALUE;
			
			for(int i = 0; i < nHouses; i++) {
				Point2D pt = new Point2D.Double(kb.nextDouble(), Math.abs(kb.nextDouble()));
				leftMost = Math.min(leftMost, pt.getX());
				rightMost = Math.max(rightMost, pt.getX());
				
				houses.add(pt);
			}
			
			final Point2D center = new Point2D.Double((rightMost + leftMost) / 2, 0);
			
			Collections.sort(houses, new Comparator<Point2D>() {
				@Override
				public int compare(Point2D o1, Point2D o2) {
					double diff = getDist(o1,center) - getDist(o2, center);
					if(diff > 0) return 1;
					if(diff < 0) return -1;
					return  0;
				}
			});
			
			//Solve
			XDist minimum;
			if(houses.size() == 1) {
				minimum = new XDist(houses.get(0).getX(), houses.get(0).getY());
			} else {
				minimum = getOptimalX(houses.get(0), houses.get(1));
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


