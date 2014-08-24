package v4cc150.chap1;

public class Q1_1 {

	// Implement an algorithm to determine if a string has all unique characters
	// What if you can not use additional data structures?

	// Difficulty level: 2
	// Time Spend:

	public static void main(String[] args) {
		Q1_1 solution = new Q1_1();

		System.out.println(solution.solve(null));
		System.out.println(solution.solve(""));
		System.out.println(solution.solve("34567890"));
		System.out.println(solution.solve("ierIER 094"));
		System.out.println(solution.solve("ABCDEFakld35"));
		System.out.println("");
		System.out.println(solution.solve("abbba"));
		System.out.println(solution.solve("ABCDEFDakldfjlskdsg354346435"));
		System.out
				.println(solution
						.solve("tijsldgdlfj lgjdlkfg394 87 7g7 g9df7g9d7f98gdf9g 09g709g809 jlkfjgldfjglkfdg gjldg jlkdfhlkdfjhglfjgldsfjglkdf"));
	}

	public boolean solve(String str) {
		// this method used additional array,
		if (str == null)
			return true;
		boolean[] flag = new boolean[128];
		// ASCII code is 128 chars in 7 bits
		// There is extended ASCII code from 128 to 255
		// But this question, we should use only 128 bits
		// http://en.wikipedia.org/wiki/ASCII
		for (Character c : str.toCharArray()) {
			int cur = (int) c;
			if (!flag[cur])
				flag[cur] = true;
			else
				return false;
		}
		return true;
	}
}