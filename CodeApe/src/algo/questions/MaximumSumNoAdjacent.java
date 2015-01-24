package algo.questions;

public class MaximumSumNoAdjacent {

	public static void main(String[] args) {
		MaximumSumNoAdjacent ins = new MaximumSumNoAdjacent();

		int[] ar1 = new int[] { 3, 2, 7, 10 };
		System.out.println("Ans 1: " + ins.solve(ar1));

		int[] ar2 = new int[] { 3, 2, 5, 10, 7 };
		System.out.println("Ans 2: " + ins.solve(ar2));
	}

	public int solve(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		} else if (A.length == 1) {
			return A[0];
		} else if (A.length == 2) {
			return Math.max(A[0], A[1]);
		}

		// prePreMax is the max non-adjacency sequence ending 2 position ahead
		// preMax is the max non-adjacency sequence ending 1 position ahead
		int prePreMax = A[0];
		int preMax = A[1];
		int ans = 0;

		for (int i = 2; i < A.length; i++) {
			ans = Math.max(ans, prePreMax + A[i]);
			// set the 2 variables: prePreMax, preMax
			int temp = preMax;
			preMax = Math.max(0, prePreMax + A[i]);
			prePreMax = Math.max(prePreMax, temp);
		}
		return ans;
	}
}
