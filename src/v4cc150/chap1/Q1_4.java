package v4cc150.chap1;

public class Q1_4 {

	// Write a method to decide if two strings are anagrams or not

	// Difficulty level: 4
	// Time Spend: 15 min

	// Analysis
	//

	public boolean solve(String a, String b) {
		if (a == null || b == null) {
			return false;
		}
		if (a.length() != b.length()) {
			return false;
		}
		int len = a.length();
		int[] flag = new int[26];
		for (int i = 0; i < len; i++) {
			if (a.charAt(i) >= 'a' && a.charAt(i) <= 'z') {
				flag[a.charAt(i) - 'a']++;
			}
			if (b.charAt(i) >= 'a' && b.charAt(i) <= 'z') {
				flag[b.charAt(i) - 'a']--;
			}
		}
		for (int i = 0; i < len; i++) {
			if (flag[i] != 0) {
				return false;
			}
		}
		return true;
	}
}