package algo.questions;

public class ArithmeticProgressionLongest {

	public int longest(int[] A) {
		int len = A.length;
		int[][] dp = new int[len][len];
		for (int i = 0; i < len; i++) {
			// the pair ending at last position is always a progression
			dp[i][len - 1] = 2;
		}
		int longest = 1;
		for (int j = len - 2; j >= 0; j--) {
			// for each j, find i and k that makes 1 progression
			int i = j - 1;
			int k = j + 1;
			while (i >= 0 && k < len) {
				int total = A[i] + A[k];
				if (total > 2 * A[j]) {
					// this is important!
					dp[i][j] = 2;
					i--;
				} else if (total < 2 * A[j]) {
					k++;
				} else {
					// found a valid progression triplet A(i, j, k)
					dp[i][j] = dp[j][k] + 1;
					longest = Math.max(longest, dp[i][j]);
					i--;
					k++;
				}
			}
			// this is important!
			while (i >= 0) {
				dp[i][j] = 2;
				i--;
				// If the loop was stopped due to k becoming more than
				// n-1, set the remaining dp[i][j] as 2
			}
		}
		return longest;
	}

	public static void main(String[] args) {

		ArithmeticProgressionLongest ins = new ArithmeticProgressionLongest();
		int[] array;

		array = new int[] { 1, 7, 10, 14, 19, 31 };
		System.out.println(ins.longest(array) + " should be 2. ");

		array = new int[] { 1, 7, 10, 15, 27, 29 };
		System.out.println(ins.longest(array) + " should be 3. ");

		array = new int[] { 2, 4, 6, 8, 10, 11 };
		System.out.println(ins.longest(array) + " should be 5. ");

		array = new int[] { 1, 2, 3, 5, 6, 7, 8, 9, 11, 300 };
		System.out.println(ins.longest(array) + " should be 6. ");
	}
}
