package algo.questions;

import common.Common;

public class LexicographicRankOfString {

	public static void main(String[] args) {
		LexicographicRankOfString ins = new LexicographicRankOfString();
		String input;

		input = "String";
		System.out.println("Rank of '" + input + "' is " + ins.getRank(input));
	}

	public int getRank(String input) {
		if (input == null || input.length() == 0) {
			return 0;
		}
		input = input.toUpperCase();
		return helper(input) + 1;
	}

	public int helper(String input) {
		if (input == null || input.length() == 0) {
			return 0;
		}
		char headChar = input.charAt(0);
		int countSmallerThanHead = 0;
		for (char ch : input.toCharArray()) {
			if (ch < headChar) {
				countSmallerThanHead++;
			}
		}
		return countSmallerThanHead * Common.factorial(input.length() - 1)
				+ helper(input.substring(1));
	}
}
