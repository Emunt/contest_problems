package MSC;

import java.util.Scanner;

public class PiggyBank {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int cases = kb.nextInt();
		
		for(int c = 0; c < cases; c++) {
			int empty = kb.nextInt();
			int full = kb.nextInt();
			
			int pigWeight = (int) Math.abs(full - empty);
			
			int coins = kb.nextInt();
			
			int[] valueList = new int[coins];
			int[] weightList = new int[coins];
			
			for(int i = 0; i < coins; i++) {
				valueList[i] = kb.nextInt();
				weightList[i] = kb.nextInt();
			}
			
			int solution = getSoltion(pigWeight,valueList,weightList);
			
			if(solution == Integer.MAX_VALUE) {
				System.out.println("This is impossible.");
			} else {
				System.out.println("The minimum amount of money in the piggy-bank is " + solution + ".");
			}
		}
	}

	private static int getSoltion(int pigWeight, int[] valueList, int[] weightList) {
		int[] solTable = new int[pigWeight+1];
		
		solTable[0] = 0;
		
		for(int i = 1; i < solTable.length; i++) {
			solTable[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < valueList.length; i++) {
			int weight = weightList[i];
			int value = valueList[i];
			
			for(int j = weight; j < solTable.length; j++) {
					int newValue = 0;
					int oldValue = solTable[j - weight];
					
					if(oldValue == Integer.MAX_VALUE) {
						newValue = Integer.MAX_VALUE;
					} else {
						newValue = oldValue + value;
					}
					
					if(newValue < solTable[j]) solTable[j] = newValue;
			}
		}
		
		return solTable[solTable.length-1];
	}

}
