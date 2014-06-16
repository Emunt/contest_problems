package fitness;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ThreeIdiots {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cases = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < cases; i++) {
			int n = Integer.parseInt(br.readLine());
			String[] line = br.readLine().split(" ");
			int[] arr = new int[n];
			
			for(int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(line[j]);
			}
			
			Arrays.sort(arr);
			
			System.out.println(bSearch(arr, 0, arr.length - 1, 4));
			
		}
	}
	
	private static int bSearch(int[] arr, int start, int end, int n) {
		int mid = (start + end) / 2;
		
		if(end - start <= 1) return end;
		
		if(n >= arr[mid]) {
			return bSearch(arr, mid, end, n);
		} else {
			return bSearch(arr, start, mid, n);
		}
	}

}
