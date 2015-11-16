package algo.questions;

public class ArithmeticPairs {

	public static void main(String[] args) {
		ArithmeticPairs ins = new ArithmeticPairs();
		long startTime = System.currentTimeMillis();

		System.out.println("Start Run... ");
		int[] input;

		input = new int[] { 1, 2, 3 };
		System.out.println(ins.solve(input));

		input = new int[] { 1, 3, 5, 7, 8, 9 };
		System.out.println(ins.solve(input));

		input = new int[] { -1, 1, 3, 3, 3, 2, 1, 0 };
		System.out.println(ins.solve(input));

		System.out.print("Total time = ");
		System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
	}

	public int solve(int[] input) {
		int len = input.length;
		int p = 0;
		while (p + 1 < len) {
			// check if there is a arithmetic sequence starting at p
			// note that p is NOT the last element.
			int diff = input[p + 1] - input[p];
			int q = p + 1;
			// starting from q, check arithmetic difference
			while (q < len) {
				if (input[q] - input[q - 1] == diff) {
					q++;
				} else {
					break;
				}
			}
			// so, the range [p, q-1] is a arithmetic sequence
		}
		return 0;
	}
}
