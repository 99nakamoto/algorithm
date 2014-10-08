package algo.questions;

import common.Common;

public class InterleavePositiveNegative {

	public static void main(String[] args) {
		InterleavePositiveNegative ins = new InterleavePositiveNegative();

		int[] array;

		array = new int[] { 1, 2, 3, 4, -5 };
		ins.solve(array);
		Common.printArray(array);

		array = new int[] { 1, -2, 3, -4, 5 };
		ins.solve(array);
		Common.printArray(array);

		array = new int[] { -1, 2, -3, -4, -5 };
		ins.solve(array);
		Common.printArray(array);

		array = new int[] { 1, -2, 3, 4, 5, 6, 7, 8 };
		ins.solve(array);
		Common.printArray(array);

	}

	public void solve(int[] A) {
		int len = A.length;
		int neg = 0;
		int pos = 1;
		while (neg < len || pos < len) {

			while (neg < len && A[neg] < 0) {
				neg += 2;
			}
			while (pos < len && A[pos] > 0) {
				pos += 2;
			}
			// neg points to a positive value
			// pos points to a negative value
			// swap them (if they're valid position)
			if (neg >= len && pos >= len) {
				return;
			} else if (neg >= len) {
				// neg is done, there's more - then +
				// put all negative values pointed by pos to the back
				int right = len - 1;
				if (right % 2 == 0) {
					right--;
				}
				while (pos < right) {
					while (pos < len && A[pos] > 0) {
						pos += 2;
					}
					while (right >= 0 && A[right] < 0) {
						right -= 2;
					}
					// pos point to a negative value, right to positive value
					if (pos > right) {
						break;
					} else {
						swap(A, pos, right);
					}
				}
				return;
			} else if (pos >= len) {
				// pos is done, there's more + then -
				int right = len - 1;
				if (right % 2 == 1) {
					right--;
				}
				while (neg < right) {
					while (neg < len && A[neg] < 0) {
						neg += 2;
					}
					while (right >= 0 && A[right] > 0) {
						right -= 2;
					}
					if (neg > right) {
						break;
					} else {
						swap(A, neg, right);
					}
				}
				return;
			} else {
				swap(A, neg, pos);
			}
		}
	}

	private void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
