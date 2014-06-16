import java.util.ArrayList;


public class p032 {
	public static void main(String[] args) {
		int sum = 0;
		ArrayList<Integer> al = new ArrayList<>();
		for(int a = 1; a < 9999; a++) {
			for(int b = 1; b < 9999; b++) {
				if(isPandigital(a, b) && !al.contains(a * b)) {
					sum += a * b;
					al.add(a * b);
				}
			}
		}
		System.out.println(sum);
	}
	
	private static boolean isPandigital(int a, int b) {
		boolean[] list = new boolean[10];
		int aTemp = a;
		int bTemp = b;
		int abTemp = a*b;
		while(aTemp > 0) {
			if(list[aTemp%10]) return false;
			list[aTemp%10] = true;
			aTemp /= 10;
		}
		while(bTemp > 0) {
			if(list[bTemp%10]) return false;
			list[bTemp%10] = true;
			bTemp /= 10;
		}
		while(abTemp > 0) {
			if(list[abTemp%10]) return false;
			list[abTemp%10] = true;
			abTemp /= 10;
		}
		
		if(list[0]) return false;
		
		for(int i = 1; i < 10; i++) {
			if(!list[i]) return false;
		}
		
		return true;
	}
	

}
