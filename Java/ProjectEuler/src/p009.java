
public class p009 {
	public static void main(String[] args) {// TODO Auto-generated method stub
		for(int a = 0; a < 999; a++) {
			for(int b = a + 1; b < 1000; b++) {
				for(int c = b + 1; c < 1001; c++) {
					if(Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2) && a + b + c == 1000) {
						System.out.println(a * b * c);
					}
				}
			}
		}
	}
}
