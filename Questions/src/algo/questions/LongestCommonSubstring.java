package algo.questions;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		LongestCommonSubstring ins = new LongestCommonSubstring();

		String s = "abcrfghwetf";
		String t = "abrfghwwetxyab";
		System.out.println(ins.LCSubstr(s, t) + " should be rfghw. ");
	}

	public String LCSubstr(String s, String t) {
		int longest = 0;
		int tPos = -1;

		// dp[i][j] represents the LCSubstr ending at position i and j
		int[][] dp = new int[t.length() + 1][s.length() + 1];
		for (int i = 1; i <= t.length(); i++) {
			for (int j = 1; j <= s.length(); j++) {
				if (t.charAt(i - 1) == s.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					if (dp[i][j] > longest) {
						longest = dp[i][j];
						tPos = i;
					}
				}
			}
		}
		return t.substring(tPos - longest, tPos);
	}
}
