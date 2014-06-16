import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class TJU_3505 {
	private static class BIT {
		private long[] tree;
		
		public BIT(int[] freq) {
			tree = new long[freq.length + 1];
			
			long[] temp = new long[freq.length + 1];
			long sum = 0;
			for(int i = 1; i < temp.length; i++) {
				sum += freq[i-1];
				temp[i] = sum;
			}
			
			for(int i = 1; i < tree.length; i++) {
				tree[i] = temp[i] - temp[i - (i & -i)];
			}
		}
		
		public long getC(int i) {	
			long sum = 0;
			
			while(i > 0) {
				sum += tree[i];
				i -= (i & -i);
			}
			
			return sum;
		}
		
		public void update(int i, int value) {
			while(i <= tree.length - 1) {
				tree[i] += value;
				i += (i & -i);
			}
		}
		
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cases = Integer.parseInt(reader.readLine());
		
		for(int c = 0; c < cases; c++) {
			int numbers = Integer.parseInt(reader.readLine());
			
			int[] numberList = new int[numbers];
			String[] line = reader.readLine().split(" ");
			
			for(int i = 0; i < numberList.length; i++) {
				numberList[i] = Integer.parseInt(line[i]);
			}
			
			BIT tree = new BIT(numberList);
			
			int commands = Integer.parseInt(reader.readLine());
			
			for(int i = 0; i < commands; i++) {
				line = reader.readLine().split(" ");
				String command = line[0];
				int a = Integer.parseInt(line[1]);
				int b = Integer.parseInt(line[2]);
				
				if(command.equals("Inquire")) {
					log.write((tree.getC(b) - tree.getC(a-1)) + "\n");
				} else if(command.equals("Add")) {
					tree.update(a, b);
					numberList[a - 1] += b;
				} else {
					if(b >numberList[a-1]) b = numberList[a-1];
					numberList[a - 1] -= b;
					tree.update(a, -b);
				}
			}
			
		}
		log.flush();
	}
}
