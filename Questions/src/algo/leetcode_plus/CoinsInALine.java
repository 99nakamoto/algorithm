package algo.leetcode_plus;

public class CoinsInALine {

	public static void main(String[] args) {

		CoinsInALine ins = new CoinsInALine();

		int[] coins = new int[] { 10, 2, 7, 5, 1 };
		System.out.println(ins.maxMoney(coins) + " should be " + 17);

		coins = new int[] { 10, 2, 7, 5, 1, 6 };
		System.out.println(ins.maxMoney(coins) + " should be " + 18);
	}

	public int maxMoney(int[] coins) {
		int len = coins.length;
		int[][] dp = new int[len][len];
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i; j < len; j++) {
				if (i == j) {
					dp[i][j] = coins[i];
				} else if (i + 1 == j) {
					dp[i][j] = Math.max(coins[i], coins[j]);
				} else {
					int chooseHead = coins[i]
							+ Math.min(dp[i + 2][j], dp[i + 1][j - 1]);
					int chooseTail = coins[j]
							+ Math.min(dp[i][j - 2], dp[i + 1][j - 1]);
					dp[i][j] = Math.max(chooseHead, chooseTail);
				}
			}
		}
		return dp[0][len - 1];
	}
}
