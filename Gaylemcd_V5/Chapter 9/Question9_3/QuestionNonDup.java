package Question9_3;

import java.util.Arrays;

import CtCILibrary.AssortedMethods;

public class QuestionNonDup {

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
		int mid = (start + end) / 2;
		if (array[mid] == mid) {
			return mid;
		} else if (array[mid] > mid) {
			return magicFast(array, start, mid - 1);
		} else {
			return magicFast(array, mid + 1, end);
		}
	}

	public static int magicFast(int[] array) {
		return magicFast(array, 0, array.length - 1);
	}

	/* Creates an array that is distinct and sorted */
	public static int[] getDistinctSortedArray(int size) {
		int[] array = AssortedMethods.randomArray(size, -1 * size, size);
		Arrays.sort(array);
		for (int i = 1; i < array.length; i++) {
			if (array[i] == array[i - 1]) {
				array[i]++;
			} else if (array[i] < array[i - 1]) {
				array[i] = array[i - 1] + 1;
			}
		}
		return array;
	}

	public static int myAnswerNonDup(int[] array) {
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
		} else if (array[mid] < mid) {
			// discard all element to the left of array[mid]
			return helper(array, mid + 1, right);
		} else {
			return helper(array, left, mid - 1);
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			int size = AssortedMethods.randomIntInRange(5, 20);
			int[] array = getDistinctSortedArray(size);
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
						+ myAnswerNonDup(array));
			}
		}
	}

}
