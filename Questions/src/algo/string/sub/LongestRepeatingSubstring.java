package algo.string.sub;

import java.util.Arrays;

public class LongestRepeatingSubstring {

	public static void main(String[] args) {
		LongestRepeatingSubstring ins = new LongestRepeatingSubstring();

		System.out.println(ins.longestRepeat("banana"));
		System.out.println(ins.longestRepeat("abcabcab"));
		System.out.println(ins.longestRepeat("bzaaczaa"));
	}

	public String longestRepeat(String input) {
		int len = input.length();
		String[] suffixArray = new String[len];
		for (int i = 0; i < len; i++) {
			suffixArray[i] = input.substring(i);
		}
		// now sort the suffix array
		Arrays.sort(suffixArray);
		String longest = "";
		// start to compare neighborhood suffixes, and check LCP
		for (int i = 0; i < suffixArray.length - 1; i++) {
			String lcp = longestCommonPrefix(suffixArray[i], suffixArray[i + 1]);
			if (lcp.length() > longest.length()) {
				longest = lcp;
			}
		}
		return longest;
	}

	private String longestCommonPrefix(String s1, String s2) {
		int p = 0;
		while (p < s1.length() && p < s2.length()) {
			if (s1.charAt(p) != s2.charAt(p)) {
				break;
			}
			p++;
		}
		return s1.substring(0, p);
	}
}
