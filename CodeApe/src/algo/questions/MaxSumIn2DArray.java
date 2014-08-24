package algo.questions;

public class MaxSumIn2DArray {

	public static void main(String[] args) {
		MaxSumIn2DArray ins = new MaxSumIn2DArray();
		int[][] array = new int[][] { { 1, 2, -1, -4, -20 },
				{ -8, -3, 4, 2, 1 }, { 3, 8, 10, 1, 3 }, { -4, -1, 1, 7, -6 } };
		System.out.println(ins.maxSum(array));
		System.out.println("Start from -3 to 7, the answer is 29");
	}

	public int maxSum(int[][] A) {
		int m = A.length;
		int n = A[0].length;
		int maxResult = Integer.MIN_VALUE;
		for (int i = 0; i < m; i++) {
			int[] temp = new int[n];
			for (int j = i; j < m; j++) {
				// from row#i to row#(m-1), add the number into temp[]
				for (int k = 0; k < n; k++) {
					temp[k] += A[j][k];
				}
				// find max sum for 1D array
				maxResult = Math.max(maxResult, maxSum(temp));
			}
		}
		return maxResult;
	}

	private int maxSum(int[] B) {
		int sumSoFar = 0;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < B.length; i++) {
			maxSum = Math.max(maxSum, sumSoFar + B[i]);
			sumSoFar = Math.max(0, sumSoFar + B[i]);
		}
		return maxSum;
	}
}
