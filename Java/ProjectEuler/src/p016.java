import java.math.BigInteger;


public class p016 {
	
	public static void main(String[] args) {
		BigInteger b = new BigInteger("2");
		String result = b.pow(1000).toString();
		int sum = 0;
		for(int i = 0; i < result.length(); i++) {
			sum += result.charAt(i) - '0';
		}
		
		System.out.println(sum);
	}

}
