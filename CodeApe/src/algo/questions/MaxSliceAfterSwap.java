package algo.questions;

public class MaxSliceAfterSwap {

	// http://stackoverflow.com/questions/24111349/codility-challenge-test-case-ok-evaluation-report-wrong-answer

	public static void main(String[] args) {
		MaxSliceAfterSwap ins = new MaxSliceAfterSwap();
		int[] A = new int[] { 3, 9, -6, 7, -3, 9, -6, -10 };
		int[] B = new int[] { -10, -6, 9, -3, 7, -6, 9, 3 };
		System.out.println(ins.findMaxSumOfArray(A));
		System.out.println(ins.findMaxSumOfArray(B));
	}

	public int findMaxSumOfArray(int[] A) {
		if (A.length == 1)
			return A[0];
		else if (A.length == 2)
			return A[0] + A[1];

		else {
			int finalMaxSum = A[0];

			for (int l = 0; l < A.length; l++) {
				for (int k = l + 1; k < A.length; k++) {

					int[] newA = A;
					int temp = newA[l];
					newA[l] = newA[k];
					newA[k] = temp;

					int maxSum = newA[0];
					int current_max = newA[0];
					for (int i = 1; i < newA.length; i++) {
						current_max = Math.max(A[i], current_max + newA[i]);
						maxSum = Math.max(maxSum, current_max);
					}

					finalMaxSum = Math.max(finalMaxSum, maxSum);

				}
			}

			return finalMaxSum;
		}
	}
}
