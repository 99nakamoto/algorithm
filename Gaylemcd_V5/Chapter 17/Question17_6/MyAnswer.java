package Question17_6;

public class MyAnswer {

	public static void findUnsortedSequence(int[] array, int[] ans) {
		int len = array.length;
		ans[0] = 0;
		ans[1] = 0;

		// find increasing sequence on left and on right
		int leftPeak = 0;
		while (leftPeak < len - 1) {
			if (array[leftPeak] < array[leftPeak + 1]) {
				leftPeak++;
			} else {
				break;
			}
		}
		if (leftPeak == len - 1) {
			return;
		}
		int rightBottom = len - 1;
		while (rightBottom > 0) {
			if (array[rightBottom] > array[rightBottom - 1]) {
				rightBottom--;
			} else {
				break;
			}
		}

		// leftPeak and rightBottom are found, now read mid part
		int midMin = Integer.MAX_VALUE;
		int midMax = Integer.MIN_VALUE;
		for (int i = leftPeak; i <= rightBottom; i++) {
			midMin = Math.min(midMin, array[i]);
			midMax = Math.max(midMax, array[i]);
		}

		// find left boudary and right boundary
		int leftBound = leftPeak;
		while (leftBound >= 0) {
			if (array[leftBound] < midMin) {
				break;
			}
			leftBound--;
		}
		int rightBound = rightBottom;
		while (rightBound < len) {
			if (array[rightBound] > midMax) {
				break;
			}
			rightBound++;
		}

		// finish it up
		ans[0] = leftBound + 1;
		ans[1] = rightBound - 1;
	}

	private static void testing(int[] array, int[] ans) {
		int left_index = ans[0];
		int right_index = ans[1];
		if (validate(array, left_index, right_index)) {
			System.out.println("TRUE: " + left_index + " " + right_index);
		} else {
			System.out.println("FALSE: " + left_index + " " + right_index);
		}
	}

	/*
	 * Testing
	 */
	public static boolean validate(int[] array, int left_index, int right_index) {
		int[] middle = new int[right_index - left_index + 1];
		for (int i = left_index; i <= right_index; i++) {
			middle[i - left_index] = array[i];
		}
		java.util.Arrays.sort(middle);
		for (int i = left_index; i <= right_index; i++) {
			array[i] = middle[i - left_index];
		}
		for (int i = 1; i < array.length; i++) {
			if (array[i - 1] > array[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] ans = new int[2];

		int[] array = { 1, 2, 4, 7, 10, 11, 8, 12, 5, 7, 16, 18, 19 };
		findUnsortedSequence(array, ans);
		testing(array, ans);

		array = new int[] { 1, 2, 4, 7, 10, 110, 7, 12, 0, 7, 16, 18, 19 };
		findUnsortedSequence(array, ans);
		testing(array, ans);
	}
}
