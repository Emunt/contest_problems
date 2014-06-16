package fitness;

public class PerfectCubes {	
	public static void main(String[] args) {
		for(int i = 6; i <= 200; i++) {
			for(int a = 2; a < i; a++ ) {
				for(int b = a; b <= i; b++) {
					for(int c = b; c <= i; c++) {
						if(i * i * i == a*a*a + b*b*b + c*c*c) {
							System.out.println("Cube = " + i + ", Triple = (" +a+"," + b + "," + c + ")");
						}
					}
				}
			}
		}

	}

}
