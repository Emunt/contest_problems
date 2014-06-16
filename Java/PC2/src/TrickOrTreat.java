import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TrickOrTreat {
	
	private static double epsilon = .00001;
	
	public static void main(String[] args) throws IOException {
		BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int n = Integer.parseInt(kb.readLine());
			if(n == 0) break;
			
			Point2D[] pointList = new Point2D[n];
			
			for(int i = 0; i < pointList.length; i++) {
				String[] s = kb.readLine().split(" ");
				
				pointList[i] = new Point2D.Double(Double.parseDouble(s[0]), Math.abs(Double.parseDouble(s[1])));
			}
			
			double dMin = 0;
			double dMax = 282843;
			double pos = 0;
			while(true) {
				double mid = (dMax + dMin) / 2;
				 
				double xMin = -200000;
				double xMax = 200000;
				for(int i = 0; i < pointList.length; i++) {
					Point2D pt = pointList[i];
					double dist = getWidth(pt,mid);
					xMin = Math.max(xMin, pt.getX() - dist);
					xMax = Math.min(xMax, pt.getX() + dist);
					
					if(xMax - xMin <= 0) break;
				}
				
				if(xMax - xMin <= 0) {
					dMin = mid;
				} else if(xMax - xMin > epsilon){
					dMax = mid;
				} else {
					pos = (xMin + xMax) / 2;
					break;
				}
			}
			
			System.out.println(pos + " " + dMin);
			
			kb.readLine();
		}
	}
	
	private static double getWidth(Point2D pt, double d) {
		if(d < pt.getY()) return 0;
		return Math.sqrt(Math.pow(d, 2) - Math.pow(pt.getY(), 2));
	}
}
