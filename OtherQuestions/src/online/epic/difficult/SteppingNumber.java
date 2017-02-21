package online.epic.difficult;

public class SteppingNumber {

	// this question is very difficult!
	// the 2 solutions below have different parameter set
	// and hence different purpose.
	// so these code are non comparable.

	public static void main(String[] args) {

		SteppingNumber ins = new SteppingNumber();
		System.out.println();

		int start = 1;
		int end = 55;
		int sLength = (int) Math.floor(Math.log10(start) + 1);
		int eLength = (int) Math.floor(Math.log10(end) + 1);

		System.out.println("other ppl's");
		for (int len = sLength; len <= eLength; ++len) {
			// no leading zero
			for (long j = 1; j < 10; ++j) {
				ins.DfsSolution(start, end, len, j);
			}
		}

		System.out.println();
		System.out.println("mine");
		ins.mySolution(1, 4, 8);

	}

	private void mySolution(int start, int end, int length) {
		helper(String.valueOf(start), 1, start, end, length);
	}

	private void helper(String cur, int pos, int preDigit, int end, int length) {
		// do a pre-check

		if (pos == length) {
			// finish inserting all numbers
			if (cur.charAt(cur.length() - 1) - '0' == end) {
				// if last digit matches, it's a valid stepping number
				System.out.println("Stepping Number: " + cur);
			}
			return;
		}
		// put (preDigit+1) and (preDigit-1) into cur string
		int digit = preDigit - 1;
		if (digit >= 0 && digit <= 9) {
			helper(cur + digit, pos + 1, digit, end, length);
		}
		digit = preDigit + 1;
		if (digit >= 0 && digit <= 9) {
			helper(cur + digit, pos + 1, digit, end, length);
		}
	}

	public void DfsSolution(int smallest, int largest, int length, long num) {
		if (length - 1 == 0) {
			if (smallest <= num && num <= largest)
				System.out.println("Stepping Number: " + num);
			return;
		}
		int lastDigit = (int) (num % 10);
		if (lastDigit == 0) {
			DfsSolution(smallest, largest, length - 1, num * 10 + 1);
		} else if (lastDigit == 9) {
			DfsSolution(smallest, largest, length - 1, num * 10 + 8);
		} else {
			DfsSolution(smallest, largest, length - 1, num * 10 + lastDigit - 1);
			DfsSolution(smallest, largest, length - 1, num * 10 + lastDigit + 1);
		}
	}

}
