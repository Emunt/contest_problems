import java.util.ArrayList;
import java.util.Scanner;

//Accepted

public class Ants {
	private static class Ant {
		int number;
		int direction;
		int position;
		public Ant(int number, int dir, int pos) {
			this.number = number;
			direction = dir;
			position = pos;
		}
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		while(true) {
			int nAnts = kb.nextInt();
			int length = kb.nextInt();
			
			if(nAnts == 0 && length == 0) break;
			ArrayList<Ant> antList = new ArrayList<Ant>(nAnts);
			
			for(int i = 0; i < nAnts; i++) {
				String direction = kb.next();
				int pos = kb.nextInt();
				int dir;
				if(direction.equals("R")) {
					dir = 1;
				} else {
					dir = -1;
				}
				
				antList.add(new Ant(i+1, dir, pos));
			}
			int time = 0;
			Ant lastAnt1 = null;
			int time1 = 0;
			Ant lastAnt2 = null;
			int time2 = 0;
			
			while(antList.size() > 0) {
				time++;
				//Update
				for(int i = antList.size() - 1; i >= 0; i--) {
					Ant a = antList.get(i);
					a.position += a.direction;
					if(a.position < 0 || a.position > length) {
						lastAnt2 = lastAnt1;
						time2 = time1;
						
						lastAnt1 = a;
						time1 = time;
						antList.remove(i);
					}
				}
				
				//flip
				for(int i = 0; i < antList.size()-1; i++) {
					Ant a = antList.get(i);
					for(int j = i+1; j < antList.size(); j++) {
						Ant b = antList.get(j);
						if(a.position == b.position) {
							a.direction = -a.direction;
							b.direction = -b.direction;
						}
					}
				}
			}
			Ant winner;
			if(time1 == time2) {
				if(lastAnt1.position < 0) {
					winner = lastAnt1;
				} else {
					winner = lastAnt2;
				}
			} else {
				winner = lastAnt1;
			}
			
			System.out.println(time1 - 1 + " " + winner.number);
		}
	}

}
