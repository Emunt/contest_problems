
public class p028 {
	public static void main(String[] args) {
		int sum = 1;
		int i = 1;
		int add = 2;
		while(i < 1001 * 1001) {
			for(int j = 0 ; j < 4; j++) {
				i += add;
				sum += i;
			}
			add += 2;
		}
		
		System.out.println(sum);
	}

}
