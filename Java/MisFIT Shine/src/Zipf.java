import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class Zipf {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = 0;
		while(true) {
			String strN = reader.readLine();
			if(strN == null) break;
			if(strN.trim().length() == 0) continue;
			int n = Integer.parseInt(strN);
			
			if(testCase != 0) System.out.println();
			
			HashMap<String, Integer> hash = new HashMap<String, Integer>(10000);
			int[] list = new int[10000];
			String[] strList = new String[10000];
			
			int k = 0;
			while(true) {
				String[] s = reader.readLine().split("[^a-zA-Z]+");
				if(s.length == 1 && s[0].equals("EndOfText")) break;
				
				for(int i = 0; i < s.length; i++) {
					if(s[i].length() == 0) continue;
					String str = s[i].toLowerCase();
					if(hash.containsKey(str)) {
						list[hash.get(str)]++;
					} else {
						hash.put(str, k);
						list[k] = 1;
						strList[k] = str;
						k++;
					}
				}
			}
			ArrayList<String> outputList = new ArrayList<String>();
			for(int i = 0; i < list.length; i++) {
				if(list[i] == n) {
					outputList.add(strList[i]);
				}
			}
			
			Collections.sort(outputList);
			
			for(int i = 0 ; i < outputList.size(); i++) {
				System.out.println(outputList.get(i));
			}
			
			if(outputList.size() == 0) {
				System.out.println("There is no such word.");
			}
			
			testCase++;
		}
	}

}
