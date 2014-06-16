import java.math.BigInteger;
import java.util.HashMap;


public class p029 {
	public static void main(String[] args) {
		HashMap<String, Integer> h = new HashMap<>();
		int distinct = 0;
		for(int a = 2; a <= 100; a++) {
			for(int b = 2; b <= 100; b++) {
				String s = new BigInteger(Integer.toString(a)).pow(b).toString();
				
				if(!h.containsKey(s)) {
					distinct++;
					h.put(s, 5);
				}
			}
		}
		System.out.println(distinct);

	}

}
