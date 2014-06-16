import java.util.ArrayList;
import java.util.Scanner;

//Accepted DP O(n)

public class GCD2 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		while(true) {
			int n = kb.nextInt();
			if(n==0) break;
			
			int[] list = new int[n];
			int count = 0;
			
			boolean[] table = new boolean[101];
			
			for(int i = 0 ; i < n; i++) {
				list[i] = kb.nextInt();
			}
			
			boolean[] oldList = new boolean[101];
			for(int i = 0; i < n; i++) {
				oldList = getList(oldList, list[i]);
				for(int j = 0; j < 101; j++) {
					if(oldList[j] && !table[j]) {
						table[j] = true;
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
	}
	
	private static boolean[] getList(boolean[] list, int n) {
		boolean[] newList = new boolean[101];
		newList[n] = true;
		for(int i = 0; i < 101; i++){
			if(list[i]) {
				newList[gcd(i,n)] = true;
			}
		}
		
		return newList;
	}
	
	private static int gcd(int a, int b) {
		if(a == 0 || b == 0) return a + b;
		return gcd(b, a % b);
	}

}
