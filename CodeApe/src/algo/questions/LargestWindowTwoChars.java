package algo.questions;

import java.util.HashSet;

public class LargestWindowTwoChars {

	// Given a string, find the longest substring that contains only two unique
	// characters. For example, given "abcbbbbcccbdddadacb", the longest
	// substring that contains 2 unique character is "bcbbbbcccb".

	public static void main(String[] args) {
		LargestWindowTwoChars ins = new LargestWindowTwoChars();
		System.out.println(ins.solution("abcbbbbcccbdddadacb"));
	}

	private String solution(String input) {
		HashSet<Character> set = new HashSet<Character>();
		char[] letters = input.toCharArray();
		set.add(letters[0]);

		int start = 0;
		String longest = input.substring(0, 1);

		for (int i = 1; i < input.length(); i++) {
			if (set.add(letters[i])) {
				if (set.size() > 2) {
					// first, update the longest substring that exists before i
					if (i - start > longest.length()) {
						longest = input.substring(start, i);
					}
					// clear and rebuild the HashSet
					set.clear();
					set.add(letters[i]);
					set.add(letters[i - 1]);
					// remove 1 char entirely from current substring
					int p = i - 1;
					while (p > 0 && letters[p] == letters[p - 1]) {
						p--;
					}
					start = p;
				}
			}
		}
		if (input.length() - start > longest.length()) {
			longest = input.substring(start);
		}
		return longest;
	}
}
