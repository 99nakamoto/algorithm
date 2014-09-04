package algo.questions;

import java.util.Arrays;

import common.Common;

public class WeirdSortingArray {

	public static void main(String[] args) {
		WeirdSortingArray ins = new WeirdSortingArray();

		int[] array = new int[] { 1, 15, 36, 2, 4, 95, 25, 11, 17, 63, 54 };
		Common.printArray(array);

		ins.solutionOn(array);
		Common.printArray(array);

		ins.solutionOnlgn(array);
		Common.printArray(array);
	}

	public void solutionOn(int[] A) {
		// this is a O(n) solution
		for (int i = 1; i < A.length; i++) {
			// compare (i)th with (i-1)th, and put the large value
			// at odd-indexed positions
			if ((A[i - 1] < A[i] && i % 2 == 0)
					|| (A[i - 1] > A[i] && i % 2 == 1)) {
				swap(A, i - 1, i);
			}
		}
	}

	public void solutionOnlgn(int[] A) {
		// this is a O(nlgn) solution
		Arrays.sort(A);
		for (int i = 2; i < A.length; i += 2) {
			swap(A, i - 1, i);
		}
	}

	private void swap(int[] A, int a, int b) {
		A[a] ^= A[b];
		A[b] ^= A[a];
		A[a] ^= A[b];
	}
}
