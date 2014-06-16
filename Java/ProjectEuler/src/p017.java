
public class p017 {
	public static void main(String[] args) {
		String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
		String[] tens = {"","", "twenty","thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
		int sum = 0;
		
		for(int i = 1; i < 1000; i++) {
			String str = "";
			int temp = i;
			str += ones[temp / 100];
			if(temp / 100 > 0 && temp % 100 != 0) str += "hundredand";
			if(temp % 100 == 0) str += "hundred";
			temp %= 100;
			if(temp < 20 && temp >= 10) {
				str += teens[temp%10];
			} else {
				str += tens[temp / 10] + ones[temp % 10];
			}
			sum += str.length();
		}
		System.out.println(sum + "onethousand".length());
		
	}

}
