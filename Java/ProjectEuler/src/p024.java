import java.util.ArrayList;


public class p024 {
	public static void main(String[] args) {
		ArrayList<Integer> integerList = new ArrayList<>();
		for(int i = 0; i < 10; i++) integerList.add(i);
		
		int start = 999999;
		String output = "";
		int i = 9;
		while(integerList.size() > 0) {
			int fact = fact(i);
			int div = start / fact;
			output += integerList.remove(div);
			start -= div * fact;
			i--;
		}
		System.out.println(output);
	}
	
	private static int fact(int n) {
		int output = 1;
		for(int i = n; i > 1; i--) {
			output *= i;
		}
		return output;
	}
}
