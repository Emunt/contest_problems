import java.util.ArrayList;
import java.util.Scanner;


public class p042 {
	public static void main(String[] args) {
		ArrayList<Integer> triangles = new ArrayList<>();
		triangles.add(1);
		
		Scanner kb = new Scanner(System.in);
		kb.useDelimiter(",|\\s");
		
		int sum = 0;
		while(kb.hasNext()) {
			String s = kb.next();
			s = s.replaceAll("\"", "");
			int digitSum = 0;
			
			for(int i = 0; i < s.length(); i++) {
				digitSum += s.charAt(i) - 'A' + 1;
			}
			
			increase(triangles, digitSum);
			if(triangles.contains(digitSum)) sum++;
		}
		
		System.out.println(sum);
	}
	
	private static void increase(ArrayList<Integer> triangles, int n) {
		while(triangles.get(triangles.size() - 1) <= n) {
			triangles.add(triangles.get(triangles.size() - 1) + triangles.size() + 1);
		}
	}

}
