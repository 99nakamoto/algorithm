package algo.questions;

public class AllStringByPlacingSpace {

	public static void main(String[] args) {
		AllStringByPlacingSpace ins = new AllStringByPlacingSpace();
		long startTime = System.currentTimeMillis();

		System.out.println("Start Run... ");

		String input = "ABC";
		System.out.println("Input is " + input);
		ins.printAll(input);
		System.out.println();

		input = "12AB";
		System.out.println("Input is " + input);
		ins.printAll(input);
		System.out.println();

		System.out.print("Total time = ");
		System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
	}

	public void printAll(String input) {
		if (input == null || input.length() <= 1) {
			// since we insert space in-between chars, so
			return;
		}
		int len = input.length();
		// len >= 2
		helper(input, len - 1);
	}

	private void helper(String s, int p) {
		if (p == 1) {
			System.out.println(s);
			// no insertion
			System.out.println(s.substring(0, 1) + " " + s.substring(1));
			// insert at position 1
		} else {
			helper(s, p - 1);
			helper(s.substring(0, p) + " " + s.substring(p), p - 1);
		}
	}
}
