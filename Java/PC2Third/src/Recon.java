import java.util.Scanner;


public class Recon {
	private static class Car {
		public int velocity;
		public int position;
		public int id;
		
		public Car(int p, int v, int i) {
			position = p;
			velocity = v;
			id = i;
		}
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		while(true) {
			int cars = kb.nextInt();
			if(cars == 0) break;
			Car[] carList = new Car[cars];
			
			for(int i = 0 ; i < cars; i++) {
				carList[i] = new Car(kb.nextInt(), kb.nextInt(), i);
			}		
		}

	}
	
	public static Car getRightMost(Car[] carList, int time) {
		
	}
}
