package algo.questions;

public class MaxSumNonConsecutiveElements {

	public static void main(String[] args) {
		MaxSumNonConsecutiveElements ins = new MaxSumNonConsecutiveElements();
		int[] input = new int[] { 6, 4, 2, 8, 1 };
		int ans = ins.maxSumNonConsec(input);
		System.out.println(ans);
	}

	public int maxSumNonConsec(int[] input) {
		int len = input.length;
		int[] dp = new int[len];
		dp[0] = input[0];
		dp[1] = Math.max(input[0], input[1]);
		for (int i = 2; i < len; i++) {
			dp[i] = Math.max(dp[i - 1], input[i] + dp[i - 2]);
		}
		return dp[len - 1];
	}
}
