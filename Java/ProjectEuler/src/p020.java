import java.math.BigInteger;


public class p020 {
	public static void main(String[] args) {
		BigInteger product = new BigInteger("2");
		for(int i = 3; i <= 100; i++) {
			product = product.multiply(new BigInteger(Integer.toString(i)));
		}
		
		String s = product.toString();
		int sum = 0;
		for(int i = 0 ; i < s.length(); i++) {
			sum += s.charAt(i) - '0';
		}
		System.out.println(sum);
	}

}
