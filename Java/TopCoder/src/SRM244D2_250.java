//Complete

public class SRM244D2_250 {
	public static class Grader {
		public static int[] grade(int[] predictedGrades, int[] actualGrades) {
			int[] out = new int[7];

			for (int i = 0; i < predictedGrades.length; i++) {
				out[(int) Math.abs(predictedGrades[i] - actualGrades[i])]++;
			}

			for (int i = 0; i < out.length; i++) {
				out[i] = (out[i] * 100) / actualGrades.length;
			}
			return out;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
