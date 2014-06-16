import java.util.Scanner;


public class MagicTrick {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int cases = kb.nextInt();
		
		loop: for(int c = 0 ; c < cases; c++) {
			System.out.print("Case #" + (c+1)+": ");
			int firstrow = kb.nextInt() - 1;
			int[] numbers = new int[4];
			for(int i = 0; i < 16; i++) {
				if(i/4 == firstrow) {
					numbers[i%4] = kb.nextInt();
				} else {
					kb.nextInt();
				}
			}
			
			int secondrow = kb.nextInt() - 1;
			int number = -1;
			boolean b = false;
			for(int i = 0; i < 16; i++) {
				if(i/4 == secondrow) {
					int tempNumber = kb.nextInt();
					if(contains(tempNumber, numbers)) {
						if(number == -1) {
							number = tempNumber;
						} else {
							b = true;
						}
					}
				} else {
					kb.nextInt();
				}
			}
			if(b) {
				System.out.println("Bad magician!");
			} else if(number == -1) {
				System.out.println("Volunteer cheated!");
			} else {
				System.out.println(number);
			}
		}
	}
	
	private static boolean contains(int n, int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == n) return true;
		}
		return false;
	}
}
