package v4cc150.chap1;

public class Q1_3 {

	// Design an algorithm and write code to remove the duplicate characters in
	// a string without using any additional buffer. NOTE: One or two additional
	// variables are fine. An extra copy of the array is not.
	//
	// FOLLOW UP
	// Write the test cases for this method.

	// Difficulty level: 4
	// Time Spend: 11 min

	public String solve(String in) {
		// this method uses an array. this is not good.
		if (in == null || in.length() == 0) {
			return in;
		}
		boolean[] occ = new boolean[128];
		int a = 0, b = 0;
		char[] input = in.toCharArray();
		while (b < input.length) {
			int curIndex = (int) input[b];
			if (!occ[curIndex]) {
				// if char pointed by b is first occurance
				occ[curIndex] = true;
				input[a++] = input[b++];
			} else {
				b++;
			}
		}
		return String.valueOf(input).substring(0, a);
	}
}