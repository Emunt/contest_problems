import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class DeceitfulWar {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int cases = kb.nextInt();
		
		for(int c = 1; c <= cases; c++) {
			int stones = kb.nextInt();
			
			ArrayList<Double> hisStones = new ArrayList<Double>(stones);
			ArrayList<Double> herStones = new ArrayList<Double>(stones);
			
			for(int i = 0; i < stones; i++) {
				herStones.add(kb.nextDouble());
			}
			for(int i = 0; i < stones; i++) {
				hisStones.add(kb.nextDouble());
			}
			
			Collections.sort(hisStones);
			Collections.sort(herStones);
			
			System.out.println("Case #" + c + ": " + solveDWar(hisStones,herStones) + " " + solveWar(hisStones, herStones));
		}
	}
	
	private static int solveWar(ArrayList<Double> hisStones, ArrayList<Double> herStones) {
		loop: for(int i = 0; i < herStones.size(); i++) {
			double currentStone = herStones.get(i);
			for(int j = 0; j < hisStones.size(); j++) {
				if(hisStones.get(j) > currentStone) {
					hisStones.remove(j);
					continue loop;
				}
			}
			return hisStones.size();
		}
		return 0;
	}
	
	private static int solveDWar(ArrayList<Double> hisStones, ArrayList<Double> herStones) {
		int counter = 0;
		int hismin = 0;
		for(int i = 0; i < hisStones.size(); i++) {
			if(herStones.get(i) > hisStones.get(hismin)) {
				counter++;
				hismin++;
			} 
		}
		return counter;
	}
}
