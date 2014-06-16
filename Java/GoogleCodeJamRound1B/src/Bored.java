import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;


public class Bored {
	private static class Vertex {
		public String zip;
		public int zipInt;
		public ArrayList<Vertex> adjList;
		public boolean isVisited;
		
		public Vertex(String z) {
			zip = z;
			zipInt = Integer.parseInt(z);
			adjList = new ArrayList<>();
			isVisited = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int cases = kb.nextInt();
		
		for(int c = 1; c <= cases; c++) {
			int cities = kb.nextInt();
			int flights = kb.nextInt();
			
			Vertex[] vertexList = new Vertex[cities];
			
			for(int i = 0; i < cities; i++) {
				Vertex v = new Vertex(kb.next());
				vertexList[i] = v;
			}
			
			for(int i = 0; i < flights; i++) {
				int a = kb.nextInt() - 1;
				int b = kb.nextInt() - 1;
				
				vertexList[a].adjList.add(vertexList[b]);
				vertexList[b].adjList.add(vertexList[a]);
			}
			
			System.out.println("Case #" + c  + ": " + solve(vertexList[0]));
		}

	}

	private static String solve(Vertex v0) {
		ArrayDeque<Vertex> stack = new ArrayDeque<Vertex>();
		v0.isVisited = true;
		String output = v0.zip;
		
		stack.push(v0);
		
		while(!stack.isEmpty()) {
			Vertex current = stack.peek();
			
			ArrayList<Vertex> adjList = current.adjList;
			
			Vertex minimum = null;
			int minimumZip = Integer.MAX_VALUE;
			for(int i = 0; i < adjList.size(); i++) {
				Vertex prospect = adjList.get(i);
				if(!prospect.isVisited) {
					if(prospect.zipInt < minimumZip) {
						minimum = prospect;
						minimumZip = prospect.zipInt;
					}
				}
			}
			
			if(minimum != null) {
				minimum.isVisited = true;
				output += minimum.zip;
				stack.push(minimum);
			} else {
				stack.pop();
			}
		}
		
		return output;
	}

}
