package Question17_14;

import CtCILibrary.Trie;

public class MyAnswer {

	public static int parse(String doc, Trie dict) {
		int len = doc.length();
		int[] dp = new int[len + 1];
		// dp[i] denotes the number of special chars in first i chars of docs
		for (int i = 1; i <= len; i++) {
			dp[i] =  Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				String str = doc.substring(j, i);
				if (dict.contains(str, true)) {
					// consider (i to j) a valid word
					dp[i] = Math.min(dp[i], dp[j]);
				} else {
					// consider (i to j) special chars
					dp[i] = Math.min(dp[i], dp[j] + i - j);
				}
			}
		}
		return dp[len];
	}
}
