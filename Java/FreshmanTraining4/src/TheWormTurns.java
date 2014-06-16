import java.awt.Point;
import java.util.Scanner;


public class TheWormTurns {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		loop: while(true) {
			int n = kb.nextInt();
			if(n==0) break;
			
			String commands = kb.next();
			Point[] snake = new Point[20];
			for(int i = 0; i < 20; i++) {
				snake[i] = new Point(10 + i, 24);
			}
			
			for(int i = 0; i < commands.length(); i++) {
				char command = commands.charAt(i);
				Point next = new Point(snake[19].x, snake[19].y);
				if(command == 'N') {
					next.y--;
				} else if(command == 'S') {
					next.y++;
				} else if(command == 'E') {
					next.x++;
				} else { //West
					next.x--;
				}
				
				if(next.x < 0 || next.x >= 50 || next.y < 0 || next.y >= 49) {
					System.out.println("The worm ran off the board on move " + (i+1) + ".");
					continue loop;
				}
				
				for(int j = 0; j < snake.length -1; j++) {
					snake[j] = snake[j+1];
				}
				
				for(int j = 0; j < snake.length -1; j++) {
					if(next.x == snake[j].x && next.y == snake[j].y) {
						System.out.println("The worm ran into itself on move " + (i+1) +".");
						continue loop;
					}
				}
				snake[snake.length - 1] = next;
			}
			
			System.out.println("The worm successfully made all "+n+" moves.");
			
		}
	}
}
