import java.awt.Point;
import java.util.ArrayList;


public class p033 {
	public static void main(String[] args) {
		ArrayList<Point> list = new ArrayList<>();
		
		for(int b = 11; b < 100; b++) {
			for(int t = 10; t < b; t++) {
				double d = t / (double) b;
				if(((t%10 == b/10) && (d == (t/10) / (double) (b%10))) || ((t/10 == b%10) && (d == (t%10) / (double)(b/10))) || ((t/10 == b/10) && (d == (t%10) / (double)(b%10)))) {
					System.out.println(t + "/" + b);
					list.add(new Point(t, b));
				}
			}
		}
		
		//Now add in the worst way possible, i should really look this up
		
		long bot = 1;
		long top = 1;
		for(int i = 0; i < list.size(); i++) {
			top *= list.get(i).x;
			bot *= list.get(i).y;
		}
		
		int i = 2;
		while(i <= top) {
			if(top%i == 0 && bot%i == 0) {
				top /= i;
				bot /= i;
				i = 2;
			}
			i++;
		}
		System.out.println(top + "/" + bot);
	}

}
