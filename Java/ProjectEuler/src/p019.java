
public class p019 {
	public static void main(String[] args) {
		int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int year = 1900;
		int day = 0;
		int sum = 0;
		//0 is a monday, so day mod 7 == 6 is a sunday
		
		for(; year <= 2000; year++) { // year
			for(int i = 0; i < 12; i++) { // month
				if(year > 1900) {
					if(day % 7 == 6) sum++;
				}
				
				day += month[i];
				if(i == 1 && year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) day++;
			}
		}
		if(day % 7 == 6) day++;
		System.out.println(sum);
	}
}
