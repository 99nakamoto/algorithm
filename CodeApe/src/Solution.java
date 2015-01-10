import common.Common;

public class Solution {

	public static void main(String[] args) {
		Solution ins = new Solution();

		int[] input;

		System.out.println("Testing: ");
		input = new int[] { 1, 2, 3, 4, 5, 6 };
		Common.printArray(input);
		input = ins.removeDup(input);
		Common.printArray(input);
		System.out.println();

		System.out.println("Testing: ");
		input = new int[] { 1, 1, 3, 5, 5, 6 };
		Common.printArray(input);
		input = ins.removeDup(input);
		Common.printArray(input);
		System.out.println();
	}

	public int[] removeDup(int[] array) {
		int i, j;

		/* new length of modified array */
		int NewLength = 1;

		for (i = 1; i < array.length; i++) {
			for (j = 0; j < NewLength; j++) {
				if (array[i] == array[j]) {
					break;
				}
			}
			/*
			 * if none of the values in index[0..j] of array is not same as
			 * array[i], then copy the current value to corresponding new
			 * position in array
			 */
			if (j == NewLength) {
				array[NewLength++] = array[i];
			}
		}

		System.out.println("The new length is " + NewLength);
		return array;
	}
}
