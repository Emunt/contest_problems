import java.util.ArrayList;
import java.util.Scanner;

//Uses Belman-Ford
public class MinimumPath {
	private static class Edge{
		public int start;
		public int end;
		public int cost;
		
		public Edge(int s, int e, int c) {
			start = s;
			end = e;
			cost = c;
		}
		
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int nodes = kb.nextInt();
		int edges = kb.nextInt();
		int start = kb.nextInt();
		int end = kb.nextInt();
		
		ArrayList<Edge> edgeList = new ArrayList<Edge>();
		
		for(int i = 0 ; i < edges; i++) {
			edgeList.add(new Edge(kb.nextInt(), kb.nextInt(), kb.nextInt()));
		}
		
		System.out.println(solve(edges, edgeList, start, end));
	}
	
	private static int solve(int edges, ArrayList<Edge> edgeList, int start, int end) {
		int[] dist = new int[edges];
		
		for(int i = 0 ; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		dist[start] = 0;
		
		for(int i = 0; i < dist.length; i++) {
			for(int j = 0; j < edgeList.size(); j++) {
				Edge e = edgeList.get(j);
				int max = Math.max(dist[e.start], e.cost);
				
				if(max < dist[e.end]) {
					dist[e.end] = max;
				}
			}
		}
		return dist[end];
	}
}
