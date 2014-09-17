package Question9_3;

import java.util.Arrays;

import CtCILibrary.AssortedMethods;

public class QuestionHavDup {

	public static int magicSlow(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == i) {
				return i;
			}
		}
		return -1;
	}

	public static int magicFast(int[] array, int start, int end) {
		if (end < start || start < 0 || end >= array.length) {
			return -1;
		}
		int midIndex = (start + end) / 2;
		int midValue = array[midIndex];
		if (midValue == midIndex) {
			return midIndex;
		}
		/* Search left */
		int leftIndex = Math.min(midIndex - 1, midValue);
		int left = magicFast(array, start, leftIndex);
		if (left >= 0) {
			return left;
		}

		/* Search right */
		int rightIndex = Math.max(midIndex + 1, midValue);
		int right = magicFast(array, rightIndex, end);

		// right can be -1
		return right;
	}

	public static int magicFast(int[] array) {
		return magicFast(array, 0, array.length - 1);
	}

	/* Creates an array that is sorted */
	public static int[] getSortedArray(int size) {
		int[] array = AssortedMethods.randomArray(size, -1 * size, size);
		Arrays.sort(array);
		return array;
	}

	public static int myAnswerWithDup(int[] array) {
		int len = array.length;
		return helper(array, 0, len - 1);
	}

	public static int helper(int[] array, int left, int right) {
		if (right < left) {
			return -1;
		}
		int mid = left + (right - left) / 2;
		if (array[mid] == mid) {
			return mid;
		} else {
			int smaller = 0;
			int larger = 0;
			if (array[mid] < mid) {
				smaller = array[mid];
				larger = mid + 1;
			} else if (array[mid] > mid) {
				smaller = mid - 1;
				larger = array[mid];
			}
			int leftResult = helper(array, left, smaller);
			if (leftResult != -1) {
				return leftResult;
			} else {
				return helper(array, larger, right);
			}
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			int size = AssortedMethods.randomIntInRange(5, 20);
			int[] array = getSortedArray(size);
			int v2 = magicFast(array);
			if (magicSlow(array) == -1) {
				// do nothing
			} else if (v2 == -1 && magicSlow(array) != -1) {
				int v1 = magicSlow(array);
				System.out.println("Incorrect value: index = -1, actual = "
						+ v1 + " " + i);
				System.out.println(AssortedMethods.arrayToString(array));
				break;
			} else if (v2 > -1 && array[v2] != v2) {
				System.out.println("Incorrect values: index= " + v2
						+ ", value " + array[v2]);
				System.out.println(AssortedMethods.arrayToString(array));
				break;
			} else {
				System.out.println("Found index = " + v2 + " "
						+ myAnswerWithDup(array));
			}
		}
	}

}
