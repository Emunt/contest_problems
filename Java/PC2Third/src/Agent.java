import java.util.Scanner;

//Accepted

public class Agent {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int[] list = new int[1000031];
		solve(list);
		
		while(true) {
			int coins = kb.nextInt();
			if(coins == 0) break;
			System.out.println(list[coins]);
		}
	}

	private static void solve(int[] list) {
		int sum = 0;
		for(int start = 2; start <= list.length; start++) {
			for(int end = start; end <= list.length; end++) {
				sum += end;
				if(sum > list.length - 1) break;
				list[sum]++;
			}
			sum = 0;
		}
	}

}
