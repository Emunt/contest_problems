import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// Doesn't work yet

public class XYZZY {
	private static class Edge {
		public int source = 0;
		public int dest = 0;
		
		public Edge(int s, int d) {
			source = s;
			dest = d;
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner kb = new Scanner(System.in);
		
		while(true) {
			int rooms = kb.nextInt();
			if(rooms == -1) break;
			
			ArrayList<Edge> edgeList = new ArrayList<Edge>();
			int[] costList = new int[rooms];
			
			for(int i = 0 ; i < rooms; i++) {
				
				costList[i] = kb.nextInt();
				
				int doors = kb.nextInt();
				for(int j = 0; j < doors; j++) {
					Edge e = new Edge(i, kb.nextInt() - 1);
					edgeList.add(e);
				}
			}
			
			if(isWinnable(edgeList, costList)) {
				System.out.println("winnable");
			} else {
				System.out.println("hopeless");
			}
		}
	}
	
	private static boolean isWinnable(ArrayList<Edge> edgeList, int[] costList) {
		int[] energy = new int[costList.length];
		int[] pred = new int[costList.length];
		pred[0] = -1;
		for(int i = 1; i < energy.length; i++) {
			energy[i] = Integer.MIN_VALUE;
			pred[i] = -1;
		}
		
		for(int i = 0; i < costList.length - 1; i++) {
			for(Edge e : edgeList) {
				int newEnergy;
				if(energy[e.source] == Integer.MIN_VALUE) {
					newEnergy = Integer.MIN_VALUE;
				} else {
					newEnergy = energy[e.source] + costList[e.dest];
				}
				
				if(newEnergy > energy[e.dest]) {
					energy[e.dest] = newEnergy;
					pred[e.dest] = e.source;
				}
			}
		}
		
		for(Edge e : edgeList) {
			int newEnergy;
			if(energy[e.source] == Integer.MIN_VALUE) {
				newEnergy = Integer.MIN_VALUE;
			} else {
				newEnergy = energy[e.source] + costList[e.dest];
			}
			
			if(newEnergy > energy[e.dest]) {
				return true;
			}
		}
		
		return energy[energy.length - 1] >= -100;
	}

}
