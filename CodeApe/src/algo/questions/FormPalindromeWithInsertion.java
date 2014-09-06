package algo.questions;

public class FormPalindromeWithInsertion {

	public static void main(String[] args) {
		FormPalindromeWithInsertion ins = new FormPalindromeWithInsertion();

		System.out.println("solve1: direct dp solution");
		System.out.println(ins.solve1("ab") + " should be 1");
		System.out.println(ins.solve1("aa") + " should be 0");
		System.out.println(ins.solve1("abcd") + " should be 3");
		System.out.println(ins.solve1("abcda") + " should be 2");
		System.out.println(ins.solve1("abcde") + " should be 4");

		System.out.println();

		System.out.println("solve2: longest palindrome subsequence");
		System.out.println(ins.solve2("ab") + " should be 1");
		System.out.println(ins.solve2("aa") + " should be 0");
		System.out.println(ins.solve2("abcd") + " should be 3");
		System.out.println(ins.solve2("abcda") + " should be 2");
		System.out.println(ins.solve2("abcde") + " should be 4");

	}

	public int solve1(String str) {
		// direct dp
		if (str == null)
			return 0;
		int len = str.length();
		int[][] dp = new int[len][len];
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i; j < len; j++) {
				if (i == j) {
					dp[i][j] = 0;
				} else if (i + 1 == j) {
					dp[i][j] = str.charAt(i) == str.charAt(j) ? 0 : 1;
				} else {
					dp[i][j] = str.charAt(i) == str.charAt(j) ? dp[i + 1][j - 1]
							: 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[0][len - 1];
	}

	public int solve2(String str) {
		// longest palindrome subsequence
		if (str == null)
			return 0;
		int len = str.length();
		int[][] dp = new int[len][len];
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i; j < len; j++) {
				if (i == j) {
					dp[i][j] = 1;
				} else if (i + 1 == j) {
					dp[i][j] = str.charAt(i) == str.charAt(j) ? 2 : 1;
				} else {
					dp[i][j] = str.charAt(i) == str.charAt(j) ? 2 + dp[i + 1][j - 1]
							: Math.max(dp[i + 1][j], dp[i][j - 1]);
				}
			}
		}
		return len - dp[0][len - 1];
	}
}
