package algo.questions;

import common.Common;

public class ArrayDistanceAiAjPlusJminusI {

	// Given an int array A[], define:
	// distance=A[i]+A[j]+(j-i), j>=i.
	// Find max distance in A[]?

	public static void main(String[] args) {
		ArrayDistanceAiAjPlusJminusI ins = new ArrayDistanceAiAjPlusJminusI();

		int[] array = new int[] { 3, 3, 3, 5, 6, 4 };

		int ans = ins.distance(array);
		System.out.println("Answer:");
		System.out.println(ans);
	}

	public int distance(int[] A) {
		int len = A.length;
		int[] arrayI = new int[len];
		int[] arrayJ = new int[len];

		arrayI[0] = A[0] - 0;
		// arrayI stores max value of (A[i]-i) from left to right
		arrayJ[len - 1] = A[len - 1] + (len - 1);
		// arrayJ stores max value of (A[i]+i) from right to left

		for (int i = 1; i < len; i++) {
			arrayI[i] = Math.max(arrayI[i - 1], A[i] - i);
		}

		for (int i = len - 2; i >= 0; i--) {
			arrayJ[i] = Math.max(arrayJ[i + 1], A[i] + i);
		}

		Common.printArray(arrayI);
		Common.printArray(arrayJ);

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < len; i++) {
			max = Math.max(max, arrayI[i] + arrayJ[i]);
		}
		return max;
	}
}
