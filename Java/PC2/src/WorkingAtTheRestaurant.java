import java.util.Scanner;

//Accepted

public class WorkingAtTheRestaurant {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int c = 0;
		while(true) {
			int commands = kb.nextInt();
			if(commands == 0) break;
			
			if(c > 0) System.out.println();
			
			int stack1 = 0;
			int stack2 = 0;
			
			for(int i = 0; i < commands; i++) {
				String command = kb.next();
				int ammount = kb.nextInt();
				
				if(command.equals("DROP")) {
					stack1 += ammount;
					System.out.println("DROP 2 " + ammount);
				} else {
					if(stack2 >= ammount) {
						System.out.println("TAKE 1 " + ammount);
						stack2 -= ammount;
					} else if(stack2 > 0) {
						System.out.println("TAKE 1 " + stack2);
						ammount -= stack2;
						stack2 = 0;
						System.out.println("MOVE 2->1 " + stack1);
						stack2 += stack1;
						stack1 = 0;
						System.out.println("TAKE 1 " + ammount);
						stack2 -= ammount;
					} else { // Nothing on stack2
						System.out.println("MOVE 2->1 " + stack1);
						stack2 += stack1;
						stack1 = 0;
						System.out.println("TAKE 1 " + ammount);
						stack2 -= ammount;
					}
				}
			}
			c++;
		}
	}

}
