import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Wormholes {
	private static class Edge {
		public int source = 0;
		public int dest = 0;
		public int cost = 0;
		
		public Edge(int s, int d, int c) {
			source = s;
			dest = d;
			cost = c;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int testCases = Integer.parseInt(reader.readLine());
		
		for(int i = 0 ; i < testCases; i++) {
			String[] input = reader.readLine().split(" ");
			int fields = Integer.parseInt(input[0]);
			int paths = Integer.parseInt(input[1]);
			int wormholes = Integer.parseInt(input[2]);
			
			ArrayList<Edge> edgeList = new ArrayList<Edge>(paths * 2 + wormholes);
			
			for(int j = 0; j < paths; j++) {
				String[] str = reader.readLine().split(" ");
				int source = Integer.parseInt(str[0]) - 1;
				int dest = Integer.parseInt(str[1]) - 1;
				int cost = Integer.parseInt(str[2]);
				Edge e1 = new Edge(source, dest, cost);
				Edge e2 = new Edge(dest, source, cost);
				edgeList.add(e1);
				edgeList.add(e2);
			}
			for(int j = 0; j < wormholes; j++) {
				String[] str = reader.readLine().split(" ");
				int source = Integer.parseInt(str[0]) - 1;
				int dest = Integer.parseInt(str[1]) - 1;
				int cost = -Integer.parseInt(str[2]);
				Edge e1 = new Edge(source, dest, cost);
				edgeList.add(e1);
			}
			
			if(hasCycle(fields, edgeList)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
	
	private static boolean hasCycle(int fields, ArrayList<Edge> edgeList) {
		int[] distance = new int[fields];
		for(int i = 1 ; i < distance.length; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < distance.length - 1; i++) {
			for(int j = 0; j < edgeList.size(); j++) {
				Edge e = edgeList.get(j);
				int newCost;
				if(distance[e.source] == Integer.MAX_VALUE) {
					newCost = Integer.MAX_VALUE;
				} else {
					newCost = distance[e.source] + e.cost;
				}
				
				if(newCost < distance[e.dest]) {
					distance[e.dest] = newCost;
				}
			}
		}
		
		for(int j = 0; j < edgeList.size(); j++) {
			Edge e = edgeList.get(j);
			int newCost;
			if(distance[e.source] == Integer.MAX_VALUE) {
				newCost = Integer.MAX_VALUE;
			} else {
				newCost = distance[e.source] + e.cost;
			}
			
			if(newCost < distance[e.dest]) {
				return true;
			}
		}
		return false;
	}

}
