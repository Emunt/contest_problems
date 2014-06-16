import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class TJU_1471 {
	private static int[][] costTable = new int[][] {
			{5, -1, -2, -1,-3},
			{-1, 5, -3, -2, -4},
			{-2,-3, 5, -2, -2},
			{-1,-2,-2,5,-1},
			{-3, -4, -2,-1, 0}};
	private static HashMap<String,Integer> mem;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(reader.readLine());
		
		for(int c = 0; c < cases; c++) {
			String A = reader.readLine().split(" ")[1];
			String B = reader.readLine().split(" ")[1];
			
			mem = new HashMap<String, Integer>();
			
			System.out.println(solve(A,B));
		}
	}

	private static int solve(String a, String b) {
		return recurse(a,b,0,0);
	}
	
	private static int recurse(String a, String b, int aIndex, int bIndex) {
		String s = aIndex + "," + bIndex;
		if(mem.containsKey(s)) return mem.get(s);
		
		if(aIndex == a.length() && bIndex == b.length()) return 0;
		
		int answer = 0;
		
		if(aIndex == a.length()) {
			answer = getCost('-', b.charAt(bIndex)) + recurse(a,b,aIndex,bIndex+1);
		} else if(bIndex == b.length()) {
			answer = getCost('-', a.charAt(aIndex)) + recurse(a,b,aIndex+1,bIndex-1);
		} else {
			//Do it
			int optionA = getCost(a.charAt(aIndex), b.charAt(bIndex)) + recurse(a,b,aIndex+1,bIndex+1);
			int optionB = getCost('-', b.charAt(bIndex)) + recurse(a,b,aIndex,bIndex+1); //Place - in string a
			int optionC = getCost('-', a.charAt(aIndex)) + recurse(a,b,aIndex+1,bIndex); //Place - in string b
			
			answer = Math.max(optionA, Math.max(optionB, optionC));
		}
		
		mem.put(s, answer);
		return answer;
	}
	
	private static int getCost(char a, char b) {
		return costTable[getIndex(a)][getIndex(b)];
	}
	
	private static int getIndex(char c) {
		if(c == 'A') return 0;
		if(c == 'C') return 1;
		if(c == 'G') return 2;
		if(c == 'T') return 3;
		return 4;
	}

}
