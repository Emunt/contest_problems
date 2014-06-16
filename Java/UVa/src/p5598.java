import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

public class p5598 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		BufferedWriter log = new BufferedWriter(new OutputStreamWriter(
				System.out));

		int n = Integer.parseInt(reader.readLine());
		for (int c = 0; c < n; c++) {
			String a = reader.readLine();
			String b = reader.readLine();

			int solution = solve(a, b);

			log.append("There are " + solution + " black pixels.");
		}

	}

	private static int solve(String a, String b) {
		ArrayDeque<Character> aStack = new ArrayDeque<Character>();
		ArrayDeque<Character> bStack = new ArrayDeque<Character>();

		aStack.push(a.charAt(0));
		bStack.push(b.charAt(0));

		int aLevel = 1;
		int bLevel = 1;
		int aIndex = 1;
		int bIndex = 1;

		while (!aStack.isEmpty() && !bStack.isEmpty()) {
			char aChar = aStack.pop();
			char bChar = bStack.pop();
			
			if(aChar == 'p' && bChar == 'p') {
				aLevel++;
				bLevel++;
				for(int i = 0; i < 4; i++) {
					aStack.push(a.charAt(aIndex++));
					bStack.push(b.charAt(bIndex++));
				}
			} else if(aChar == 'p' && bChar == 'f') {
				
			} else if(aChar == 'f' && bChar == 'p') {
				
			} else if(aChar == 'p' && bChar == 'p') {
				
			} else if(aChar == 'p' && bChar == 'p') {
				
			} else if(aChar == 'p' && bChar == 'p') {
				
			}
		}
		return 0;
	}

}
