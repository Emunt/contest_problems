
public class p030 {
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 10; i < 999999; i++) {
			int digitFifth = 0;
			int number = i;
			while(number > 0) {
				digitFifth += (int) Math.pow(number%10, 5);
				number /= 10;
			}
			if(digitFifth == i) sum += i;
		}
		System.out.println(sum);
	}

}
