import java.awt.geom.Point2D;
import java.util.Scanner;


public class CircumOfCircle {
	public static final double PI = 3.141592653589793;
	
	private static class Line {
		public double x;
		public double y;
		public double c;
		
		//Line from two points
		public Line(Point2D p1, Point2D p2) {
			x = p1.getY() - p2.getY();
			y = p1.getX() - p2.getX();
			c = p1.getX() * x + p1.getY() * y;
			
			if(x < 0) {
				x = -x;
				y = -y;
				c = -c;
			}
		}
		
		//Line perpendicular to a line going through point p
		public Line(Line ln, Point2D pt) {
			x = ln.y;
			y = ln.x;
			c = pt.getX() * x + pt.getY() * y;
			
			if(x < 0) {
				x = -x;
				y = -y;
				c = -c;
			}
		}
		
		public Point2D getIntercept(Line ln) {
			 double delta = x * ln.y - ln.x * y;
			 
			 double xOut = (ln.y*c - y*ln.c) / delta;
			 double yOut = (x*ln.c - ln.x*c) / delta;
			 
			 return new Point2D.Double(xOut, yOut);
		}
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		while(kb.hasNext()) {
			Point2D a = new Point2D.Double(kb.nextDouble(), kb.nextDouble());
			Point2D b = new Point2D.Double(kb.nextDouble(), kb.nextDouble());
			Point2D c = new Point2D.Double(kb.nextDouble(), kb.nextDouble());
			System.out.printf("%.2f\n", solve(a,b,c));
		}
	}
	
	private static double solve(Point2D a, Point2D b, Point2D c) {
		Line ln1 = new Line(a,b);
		Line ln2 = new Line(b,c);
		
		Line perp1 = new Line(ln1, new Point2D.Double((a.getX() + b.getX()) / 2, (a.getY() + b.getY()) / 2));
		Line perp2 = new Line(ln2, new Point2D.Double((b.getX() + c.getX()) / 2, (b.getY() + c.getY()) / 2));
		
		Point2D pt = perp1.getIntercept(perp2);
		
		return pt.distance(a) * 2 * PI;
	}
}
