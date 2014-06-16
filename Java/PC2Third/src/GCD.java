import java.util.ArrayList;
import java.util.Scanner;

//Too slow O(n^2)

public class GCD {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		while(true) {
			int numbers = kb.nextInt();
			if(numbers == 0) break;
			
			boolean[] table = new boolean[101];
			int count = 0;
			
			ArrayList<Integer> numList = new ArrayList<Integer>(numbers);
			numList.add(kb.nextInt());
			for(int i = 1; i < numbers; i++) {
				int n = kb.nextInt();
				if(numList.get(numList.size() - 1) != n) numList.add(n);
			}
			
			int gcd;
			loop: for(int start = 0; start < numList.size(); start++) {
				gcd = numList.get(start);
				for(int end = start; end < numList.size(); end++) {
					gcd = gcd(gcd, numList.get(end));
					if(!table[gcd]) {
						table[gcd] = true;
						count++;
					}
					if(gcd == 1) break;
					if(count >= 100) break loop;
				}
			}
			System.out.println(count);
		}
	}
	
	private static int gcd(int a, int b) {
		if(a == 0 || b == 0) return a + b;
		return gcd(b, a % b);
	}

}
