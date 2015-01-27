package algo.questions;

import java.util.Arrays;

public class KnapSackProblem {

	public static void main(String[] args) {
		KnapSackProblem ins = new KnapSackProblem();

		int[] value;
		int[] weight;

		value = new int[] { 3, 5 };
		weight = new int[] { 1, 2 };
		System.out.println(ins.maxValNoDup(4, value, weight));
		System.out.println();

		value = new int[] { 1, 2, 3 };
		weight = new int[] { 1, 3, 5 };
		System.out.println(ins.maxValNoDup(6, value, weight));
		System.out.println();
	}

	public int maxValNoDup(int totalWeight, int[] value, int[] weight) {
		int items = value.length;
		Arrays.sort(value);
		Arrays.sort(weight);

		int[][] dp = new int[items + 1][totalWeight + 1];
		for (int i = 1; i <= items; i++) {
			for (int j = 1; j <= totalWeight; j++) {
				// we'll try to take i'th item, to fit in weight j
				if (j < weight[i - 1]) {
					// not able to put in
					dp[i][j] = dp[i - 1][j];
				} else {
					// we are able to take i'th item into knapsack
					dp[i][j] = Math.max(dp[i - 1][j], value[i - 1]
							+ dp[i - 1][j - weight[i - 1]]);
				}
			}
		}
		return dp[items][totalWeight];
	}
}
