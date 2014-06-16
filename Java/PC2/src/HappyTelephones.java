import java.util.Scanner;

//Accepted

public class HappyTelephones {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		while (true) {
			int phoneCalls = kb.nextInt();
			int queries = kb.nextInt();
			if (phoneCalls == 0 && queries == 0)
				break;
			int[] startTimes = new int[phoneCalls];
			int[] endTimes = new int[phoneCalls];
			for (int i = 0; i < phoneCalls; i++) {
				kb.nextInt();
				kb.nextInt();
				startTimes[i] = kb.nextInt();
				endTimes[i] = kb.nextInt();
			}

			for (int i = 0; i < queries; i++) {
				int start = kb.nextInt();
				int end = start + kb.nextInt() - 1;
				int sum = 0;
				for (int j = 0; j < phoneCalls; j++) {
					int startTime = startTimes[j];
					int endTime = startTimes[j] + endTimes[j] - 1;
					
					if((startTime >= start && startTime <= end) || (endTime >= start && endTime <= end) || (startTime <= start && endTime >= end)) sum++;

				}
				System.out.println(sum);
			}
		}
	}

}
