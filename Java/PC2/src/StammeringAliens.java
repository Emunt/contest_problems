import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class StammeringAliens {
	private static class Intwrapper {
		public int i;
		public Intwrapper(int i) {
			this.i = i;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
		loop: while(true) {
			int minRep = Integer.parseInt(kb.readLine());
			if(minRep == 0) break;
			
			String s = kb.readLine();
			
			 for(int size = s.length() - minRep + 1; size >= 1; size--) {
				HashMap<String, Intwrapper> m = new HashMap<String, Intwrapper>(40000);
				for(int i = s.length() - size; i >= 0; i--) {
					String temp = s.substring(i, i + size);
					if(m.containsKey(temp)) {
						Intwrapper tempint = m.get(temp);
						tempint.i++;
						if(tempint.i >= minRep) {		
							System.out.println(size + " " + s.lastIndexOf(temp));
							continue loop;
						}
					} else {
						m.put(temp, new Intwrapper(1));
					}
				}
			}
			 System.out.println("none");
		}
	}

}
