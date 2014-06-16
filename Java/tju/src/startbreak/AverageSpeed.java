package startbreak;

import java.util.Scanner;

public class AverageSpeed {
	private static class Time {
		public int hours;
		public int minutes;
		public int seconds;
		
		public Time(int hours, int minutes, int seconds) {
			this.hours = hours;
			this.minutes = minutes;
			this.seconds = seconds;
		}
		//Other is smaller
		public Time subtract(Time other) {
			Time output = new Time(0,0,0);
			
			int carry = 0;
			int diff = this.seconds - other.seconds;
			if(diff < 0) {
				output.seconds = 60 + diff;
				carry = 1;
			} else {
				output.seconds = diff;
			}
			
			diff = this.minutes - other.minutes - carry;
			carry = 0;
			if(diff < 0) {
				output.minutes = 60 + diff;
				carry = 1;
			} else {
				output.minutes = diff;
			}
			
			output.hours = this.hours - other.hours - carry;
			
			return output;
		}
		@Override
		public String toString() {
			return String.format("%02d:%02d:%02d", this.hours, this.minutes, this.seconds);
		}
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String[] line;
		double distance = 0;
		double speed = 0;
		Time currentTime = new Time(0,0,0);
		
		while(kb.hasNextLine()) {
			line = kb.nextLine().split("(\\s|:)");
			
			Time newTime = new Time(Integer.parseInt(line[0]),Integer.parseInt(line[1]),Integer.parseInt(line[2]));
			
			//Update new distance
			Time diffTime = newTime.subtract(currentTime);
			distance += (diffTime.hours * speed) + ((diffTime.minutes / 60.0) * speed) + ((diffTime.seconds / (3600.0) * speed));
			
			currentTime = newTime;
			
			if(line.length > 3) {
				speed = Integer.parseInt(line[3]);
			} else {
				System.out.print(currentTime);
				System.out.printf(" %.2f km\n", distance);
			}
			
		}

	}
}
