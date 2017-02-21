package algo.string.sub;

public class CheckRepeatingSubsequence {

	public static void main(String[] args) {
		CheckRepeatingSubsequence ins = new CheckRepeatingSubsequence();

		// false
		System.out.println(ins.checkRepeatSubseq("ab"));
		System.out.println(ins.checkRepeatSubseq("abba"));
		System.out.println(ins.checkRepeatSubseq("abcaz"));

		// true
		System.out.println(ins.checkRepeatSubseq("abab"));
		System.out.println(ins.checkRepeatSubseq("abcab"));
		System.out.println(ins.checkRepeatSubseq("acbdaghfb"));
		System.out.println(ins.checkRepeatSubseq("abcdacb"));
	}

	public boolean checkRepeatSubseq(String input) {
		int len = input.length();
		int[][] dp = new int[len + 1][len + 1];
		// dp[i][j] denotes the length of subseq between 2 strings:
		// 1. first i chars of input
		// 2. first j chars of input
		for (int i = 1; i <= len; i++) {
			for (int j = i; j <= len; j++) {
				if (i != j && input.charAt(i - 1) == input.charAt(j - 1)) {
					int temp = Math.max(dp[i - 1][j], dp[i][j - 1]);
					dp[i][j] = Math.max(temp, dp[i - 1][j - 1] + 1);
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[len][len] >= 2;
	}
}
