package algo.questions;

import common.Common;

public class SwizzleSort {

	public static void main(String[] args) {
		SwizzleSort ins = new SwizzleSort();
		long startTime = System.currentTimeMillis();

		System.out.println("Start Run... ");
		int[] input, output;

		input = new int[] { 1, 5, 4, 3, 7, 6, 9, 2 };
		Common.printArray(input);
		output = ins.solve(input);
		Common.printArray(output);
		System.out.println();

		input = new int[] { 1, 5, 11, 12, 13, 15, 19, 4, 3, 7, 6, 9, 2, -1, 100, 111, 99 };
		Common.printArray(input);
		output = ins.solve(input);
		Common.printArray(output);
		System.out.println();

		System.out.print("Total time = ");
		System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
	}

	public int[] solve(int[] input) {
		boolean incr = true;
		int len = input.length;
		int p = 1;
		while (p < len) {
			if (incr ^ (input[p - 1] < input[p])) {
				Common.swap(input, p - 1, p);
			}
			p++;
			incr = !incr;
		}
		return input;
	}

}
