import java.util.Scanner;

//2/2/14
//Calculate B^P % M

public class p374 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		while(kb.hasNext()) {
			int B = kb.nextInt();
			int P = kb.nextInt();
			int M = kb.nextInt();
			System.out.println(bigMod(B, P, M));
		}


	}
	
	//R = B^P % M
	//(A*B) % M = (A % M * B * M) % M
	//Implemented the same way integer pow is
	private static int bigMod(int B, int P, int M) {
		if(P == 0) return 1;
		if(P % 2 == 0) {
			int b = bigMod(B,P/2, M);
			return (b * b) % M;
		} else {
			return ((bigMod(B, P - 1, M) % M) * (B % M)) % M;
		}
	}

}
