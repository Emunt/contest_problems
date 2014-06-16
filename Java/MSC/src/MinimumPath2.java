import java.util.PriorityQueue;

public class MinimumPath2 {
	private static class Vertex implements Comparable<Vertex> {
		public Edge[] adj;
		public int minimumdistance = Integer.MAX_VALUE;
		public Vertex previous = null;
		
		int id;
		
		public Vertex(int i) {
			id = i;
		}
		
		@Override
		public int compareTo(Vertex arg0) {
			return minimumdistance - arg0.minimumdistance;
		}
		
	}
	
	private static class Edge {
		int weight;
		Vertex target;
		
		public Edge(Vertex t, int w) {
			this.target = t;
			this.weight = w;
		}
		
	}
	public static void main(String[] args) {
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);
		Vertex v6 = new Vertex(6);
		
		v1.adj = new Edge[] { new Edge(v2, 4)};
		v2.adj = new Edge[] { new Edge(v4, 4)};
		v3.adj = new Edge[] { new Edge(v2, 3)};
		v4.adj = new Edge[] { new Edge(v5, 3), new Edge(v1,3)};
		v5.adj = new Edge[] { new Edge(v2, 4),new Edge(v4, 5),new Edge(v6, 1)};
		v6.adj = new Edge[] { new Edge(v1, 5)};
		
		Vertex start = v3; //For testing
		Vertex end = v5;
		
		solve(start);
		
		System.out.println("Solution: " + end.minimumdistance);
		
		Vertex current = end;
		String out = "";
		while(current != null) {
			out =  current.id + " " + out;
			current = current.previous;
		}
		System.out.println(out);
	}
	
	
	private static void solve(Vertex start) {
		start.minimumdistance = 0;
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		pq.add(start);
		
		while(!pq.isEmpty()) {
			Vertex current = pq.poll();
			for(Edge e : current.adj) {
				Vertex next = e.target;
				int updatedweight = Math.max(current.minimumdistance, e.weight);
				
				if(updatedweight < next.minimumdistance) {
					pq.remove(next);
					next.minimumdistance = updatedweight;
					next.previous = current;
					pq.add(next);
				}
			}
		}
	}
}
