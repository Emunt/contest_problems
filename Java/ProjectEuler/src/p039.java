
public class p039 {
	public static void main(String[] args) {
		int max = Integer.MIN_VALUE;
		int p = 0;
		for(int i = 3; i <= 1000; i++) {
			int tri = getNumTri(i);
			if(tri > max) {
				max = tri;
				p = i;
			}
		}
		System.out.println(p);
	}
	
	private static int getNumTri(int p) {
		int sum = 0;
		for(int a = 1; a <= p - 2; a++) {
			for(int b = a; b <= p - a - b; b++) {
				int c = p - a - b;
				if(isRight(a, b, c)) sum++;
			}
		}
		
		return sum;
	}
	
	private static boolean isRight(int a, int b, int c) {
		return Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2);
	}
}
