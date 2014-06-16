import java.math.BigInteger;
import java.util.Scanner;


public class p013 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		BigInteger sum = new BigInteger("0");
		for(int i = 0; i < 100; i++) {
			BigInteger add = new BigInteger(kb.next());
			sum = sum.add(add);
		}
		
		System.out.println(sum.toString().substring(0, 10));
	}
}
