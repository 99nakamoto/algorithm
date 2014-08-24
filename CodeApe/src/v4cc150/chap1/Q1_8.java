package v4cc150.chap1;

public class Q1_8 {

	// Assume you have a method isSubstring which checks if one word is a
	// substring of another. Given two strings, s1 and s2, write code to check
	// if s2 is a rotation of s1 using only one call to isSubstring .

	// Difficulty level:
	// Time Spend:

	public boolean solve(String a, String b) {
		if (a == null) {
			return b == null;
		}
		String c = a + a;
		return c.indexOf(b) != -1;
	}
}
