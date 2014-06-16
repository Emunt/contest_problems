import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class p022 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		kb.useDelimiter(",");
		ArrayList<String> list = new ArrayList<>();
		
		while(kb.hasNext()) {
			list.add(kb.next().replaceAll("\"", ""));
		}
		list.remove(list.size() -1);
		Collections.sort(list);
		BigInteger sum = new BigInteger("0");
		
		for(int i = 0 ; i < list.size(); i++) {
			String s = list.get(i);
			int ssum = 0;
			for(int j = 0; j < s.length(); j++) {
				ssum += s.charAt(j) - 'A' + 1;
			}
			
			sum = sum.add(new BigInteger(Integer.toString(ssum * (i+1))));
		}
		System.out.println(sum);
	}

}
