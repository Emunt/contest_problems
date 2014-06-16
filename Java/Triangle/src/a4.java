import java.util.Scanner;

//William Nichols

public class a4 {

	public static class Triangle {
		private long aEdge, bEdge, cEdge;
		private boolean isInvalidInput = false;
		
		public Triangle(String line) {
			String[] lineArr = line.split("\\s{1,}");
			if (lineArr.length != 3) {
				isInvalidInput = true;
			}

			int[] numberArr = new int[3];

			for (int i = 0; i < numberArr.length; i++) {
				try {
					numberArr[i] = Integer.parseInt(lineArr[i]);
				} catch (Exception e) {
					isInvalidInput = true;
				}
			}
			if(!isInvalidInput) {
				aEdge = numberArr[0];
				bEdge = numberArr[1];
				cEdge = numberArr[2];
			}
		}
		
		public String getClassification() {
			String s;
			if(isInvalidInput) {
				s = "Invalid Input";
			} else if(!isTriangle()) {
				s = "Invalid Triangle";
			} else if(isEquilateral()) {
				s = "Equilateral";
			} else if(isIsosceles()) {
				s = "Isosceles";
			} else if(isScalene()) {
				s = "Scalene";
			} else {
				s = "Error";
			}
			return s;
		}
		
		private boolean isTriangle() {
			if (aEdge < 1 || bEdge < 1 || cEdge < 1)
				return false;

			return aEdge + bEdge > cEdge && aEdge + cEdge > bEdge
					&& bEdge + cEdge > aEdge;
		}

		private boolean isEquilateral() {
			return getNumberOfEqualEdges() == 3;
		}

		private boolean isIsosceles() {
			return getNumberOfEqualEdges() == 1;
		}

		private boolean isScalene() {
			return getNumberOfEqualEdges() == 0;
		}

		private int getNumberOfEqualEdges() {
			int edges = 0;
			if (aEdge == bEdge) edges++;
			if (bEdge == cEdge) edges++;
			if (cEdge == aEdge) edges++;
			return edges;
		}
	}

	// Driver
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		while (kb.hasNextLine()) {
			String line = kb.nextLine();
			Triangle t = new Triangle(line);
			System.out.println(t.getClassification());
		}

		kb.close();
	}
}
