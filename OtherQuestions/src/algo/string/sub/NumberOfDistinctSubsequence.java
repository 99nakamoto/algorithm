package algo.string.sub;

public class NumberOfDistinctSubsequence {

	public static void main(String[] args) {
		NumberOfDistinctSubsequence ins = new NumberOfDistinctSubsequence();

		System.out.println(ins.countDistinctSubseq("aaa"));
		System.out.println(ins.countDistinctSubseq("ABCDEFG"));
		System.out.println(ins.countDistinctSubseq("CODECRAFT"));
	}

	public int countDistinctSubseq(String input) {
		int len = input.length();
		int[] dp = new int[len + 1];
		// dp[i] denotes the number of distinct subseq within first 'i' chars
		dp[0] = 1;
		// the first 0 chars is "" - we consider it as 1 subseq

		for (int i = 1; i <= len; i++) {
			// set dp[i]
			// dp[i] = dp[i-1] + ... + dp[k] where input{k} == input{i}
			int p = i - 1;
			while (p >= 0) {
				dp[i] += dp[p];
				if (p > 0 && input.charAt(p - 1) == input.charAt(i - 1)) {
					// when meeting a same char ahead of position i, stop
					// adding to dp[i]
					break;
				}
				p--;
			}
		}
		int sum = 0;
		for (int i : dp) {
			sum += i;
		}
		return sum;
	}
}
