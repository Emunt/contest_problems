import java.util.ArrayList;


public class p026 {
	public static void main(String[] args) {
		int maxLength = Integer.MIN_VALUE;
		int maxPos = 0;
		
		for(int i = 2; i < 1000; i++) {
			int length = getCycle(i).length();
			if(length > maxLength) {
				maxLength = length;
				maxPos = i;
			}
		}
		System.out.println(maxPos);
		System.out.println(getCycle(maxPos));
	}
	
	private static String getCycle(int n) {
		int bigpart = 1;
		String decimal = ""; 
		
		ArrayList<Integer> r = new ArrayList<>();
		r.add(1);
		
		boolean good = false;
		
		while(bigpart != 0) {
			bigpart *= 10;
			decimal += bigpart / n;
			bigpart %= n;
			if(r.contains(bigpart)) {
				decimal = decimal.substring(r.indexOf(bigpart));
				good = true;
				break;
			}
			r.add(bigpart);
		}
		
		if(!good) decimal = "";
		
		return decimal;
	}
}
