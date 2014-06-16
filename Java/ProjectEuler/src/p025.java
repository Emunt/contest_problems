import java.math.BigInteger;


public class p025 {
	public static void main(String[] args) {
		BigInteger i = new BigInteger("1");
		BigInteger iminus1 = new BigInteger("1");
		int f = 2;
		while(true) {
			f++;
			BigInteger iplus1 = i.add(iminus1);
			iminus1 = i;
			i = iplus1;
			if(i.toString().length() >= 1000) break;
		}
		
		System.out.println(f);
	}

}
