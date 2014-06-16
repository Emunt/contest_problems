import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//After hours of useless debugging
public class p12532 {
	private static class SegmentTree {
		int[] T; //Tree
		int numbers;
		public SegmentTree(int[] numberList) {
			numbers = numberList.length;
			
			int n = (int) Math.ceil(Math.log10(numbers) / Math.log10(2));
			int length = 2 * (int) Math.pow(2, n);
			
			T = new int[length];
			init(1, 0, numbers - 1, numberList);
		}
		
		private void init(int n, int lo, int hi, int[] numberlist) {
			if(lo == hi) {
				T[n] = numberlist[lo];
				return;
			}
			int mid = (lo + hi) / 2;
			init((n * 2), lo, mid, numberlist); // Left
			init((n * 2 + 1), mid + 1,hi,numberlist);//Right
			
			T[n] = T[n * 2] * T[(n * 2) + 1];
		}
		
		public void update(int index, int number) {
			update(1, index,number, 0, numbers-1);
			
		}
		private void update(int n, int index, int number, int lo, int hi) {
			if(index < lo || index > hi) return;
			
			if(lo == hi) {
				T[n] = number;
				return;
			}
			
			int mid = (lo + hi) / 2;
			update(n* 2, index, number, lo, mid); // left
			update((n * 2) + 1, index, number, mid + 1, hi); // right
			T[n] = T[n * 2] * T[(n * 2) + 1];
		}
		
		public int check(int si, int ei) {
			return check(1,si,ei,0,numbers - 1);
		}
		
		private int check(int n, int si, int ei, int lo, int hi) {
			if(si > hi || ei < lo) return 1;
			if(lo >= si && hi <= ei) return T[n];
			
			int mid = (lo + hi) / 2;
			
			int left = check(n * 2, si, ei, lo, mid); //left
			int right = check((n * 2) + 1, si, ei, mid + 1, hi); // right
			return left * right;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		BufferedWriter log = new BufferedWriter(new OutputStreamWriter(
				System.out));

		String firstLine;
		while ((firstLine = reader.readLine()) != null) {
			String[] line = firstLine.split(" ");
			int numbers = Integer.parseInt(line[0]);
			int queries = Integer.parseInt(line[1]);

			line = reader.readLine().split(" ");

			int[] numberList = new int[numbers];
			for (int i = 0; i < numbers; i++) {
				numberList[i] = reduce(Integer.parseInt(line[i]));//0;
			}
			
			SegmentTree tree = new SegmentTree(numberList);
			
			for (int i = 0; i < queries; i++) {
				line = reader.readLine().split(" ");
				String command = line[0];
				int a = Integer.parseInt(line[1]);
				int b = Integer.parseInt(line[2]);
				
				if(command.equals("C")) {
					tree.update(a-1, reduce(b));
				} else { //P
					int result = tree.check(a-1, b-1);
					if(result == -1) {
						log.append('-');
					} else if(result == 1) {
						log.append('+');
					} else {
						log.append('0');
					}
				}
			}
			
			log.append('\n');
			log.flush();
		}
		
	}

	
	private static int reduce(int n) {
		if(n > 0) return 1;
		if(n < 0) return -1;
		return 0;
	}
	
}
