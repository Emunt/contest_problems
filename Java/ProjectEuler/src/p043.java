
public class p043 {
	public static void main(String[] args) {
		boolean[] rec = new boolean[10];
		System.out.println(recurse(rec, 1, ""));
	}
	
	public static long recurse(boolean[] rec, int start, String str) {
		if(str.length() >= 10 && sat(str)) return Long.parseLong(str);
		
		long sum = 0;
		for(int i = start; i < rec.length; i++) {
			if(!rec[i]) {
				rec[i] = true;
				sum += recurse(rec, 0, str + i);
				rec[i] = false;
			}
		}
		
		return sum;
	}
	
	private static boolean sat(String str) {
		if(getNum(str,2,4)%2 != 0) return false;
		if(getNum(str,3,5)%3 != 0) return false;
		if(getNum(str,4,6)%5 != 0) return false;
		if(getNum(str,5,7)%7 != 0) return false;
		if(getNum(str,6,8)%11 != 0) return false;
		if(getNum(str,7,9)%13 != 0) return false;
		if(getNum(str,8,10)%17 != 0) return false;
		return true;
	}
	
	private static int getNum(String str, int start, int end) {
		return Integer.parseInt(str.substring(start - 1, end));
	}

}
