package algo.string.sub;

import java.util.HashSet;

public class AllDistinctSubsequenceGivenLength {

	// input: ¡°food¡±
	// output: 4
	// ¡°fo¡±, ¡°fd¡±, ¡°oo¡±, and ¡°od¡±

	public static void main(String[] args) {
		AllDistinctSubsequenceGivenLength ins = new AllDistinctSubsequenceGivenLength();

		System.out.println(ins.countSubSeq("abc", 1));
		System.out.println(ins.countSubSeq("abc", 2));
		System.out.println(ins.countSubSeq("abc", 3));
		System.out.println(ins.countSubSeq("food", 2) + " should be 4");
		System.out.println(ins.countSubSeq("fodop", 2) + " should be 8");
	}

	public int countSubSeq(String input, int k) {
		// assuming all input chars are small letter
		return choose(input, 0, k);
	}

	private int choose(String input, int start, int numChar) {
		int charLeft = input.length() - start;
		if (charLeft == numChar || numChar == 0) {
			return 1;
		} else if (charLeft < numChar || numChar < 0) {
			return 0;
		}
		// now numChar is smaller than charLeft, and larger than 0
		// start to pick a char (which is at first appearance)
		int total = 0;
		HashSet<Character> chosen = new HashSet<Character>();
		while (start < input.length()) {
			char currentChar = input.charAt(start);
			if (!chosen.contains(currentChar)) {
				// pick the char pointer by 'start'
				total += choose(input, start + 1, numChar - 1);
				chosen.add(currentChar);
			}
			start++;
		}
		return total;
	}
}
