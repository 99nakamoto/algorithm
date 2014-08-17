package v4cc150.chap1;

public class Q1_5 {

	// Write a method to replace all spaces in a string with 

	// Difficulty level: 3
	// Time Spend: 8 min

	// Analysis
	//

	public String solve(String in) {
		if (in == null || in.length() == 0) {
			return in;
		}
		// first, learn the number of space
		int len = in.length();
		int spaces = 0;
		for (int i = 0; i < len; i++) {
			if (in.charAt(i) == ' ') {
				spaces++;
			}
		}
		int newLen = len + (2 * spaces);
		char[] out = new char[newLen];
		int p = len - 1, q = newLen - 1;
		while (p >= 0 && q >= 0) {
			if (in.charAt(p) != ' ') {
				out[q--] = in.charAt(p);
			} else {
				out[q--] = '0';
				out[q--] = '2';
				out[q--] = '%';
			}
			p--;
		}
		return String.valueOf(out);
	}
}
