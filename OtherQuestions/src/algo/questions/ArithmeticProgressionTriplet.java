package algo.questions;

public class ArithmeticProgressionTriplet {

	public static void main(String[] args) {
		ArithmeticProgressionTriplet ins = new ArithmeticProgressionTriplet();

		int[] array;

		array = new int[] { 1, 7, 10, 15, 27, 29 };
		System.out.println(ins.longest(array) + " should be true. ");

		array = new int[] { 1, 7, 10, 15, 100 };
		System.out.println(ins.longest(array) + " should be false. ");

		array = new int[] { 1, 2, 5, 6, 9 };
		System.out.println(ins.longest(array) + " should be true. ");

	}

	public boolean longest(int[] A) {
		int len = A.length;
		for (int i = 1; i < len - 1; i++) {
			int left = i - 1;
			int right = i + 1;
			while (left >= 0 && right < len) {
				int total = A[left] + A[right];
				if (total > 2 * A[i]) {
					left--;
				} else if (total < 2 * A[i]) {
					right++;
				} else {
					return true;
				}
			}
		}
		return false;
	}
}
