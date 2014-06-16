
public class p038 {
	public static void main(String[] args) {
		int max = 0;
		for(int i = 1; i < 9999; i++) {
			String s = "";
			int pan = 0;
			while(s.length() < 9) {
				pan++;
				s += i * pan;
			}
			if(pan > 1 && isPandigital(s)) System.out.println(s);
		}
	}
	
	private static boolean isPandigital(String s) {
		if(s.length() != 9) return false;
		
		for(int i = 1; i < 10; i++) {
			if(!s.contains(Integer.toString(i))) return false;
		}
		
		return true;
	}

}
