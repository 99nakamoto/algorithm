package algo.questions;

import common.Common;

public class DutchNationalFlag {

	public static void main(String[] args) {
		DutchNationalFlag ins = new DutchNationalFlag();
		long startTime = System.currentTimeMillis();

		System.out.println("Start Run... ");
		int[] input, output;

		input = new int[] { 0, 1, 2, 0, 1 };
		Common.printArray(input);
		output = ins.solve(input);
		Common.printArray(output);
		System.out.println();

		input = new int[] { 2, 0, 1, 1, 2, 0, 2 };
		Common.printArray(input);
		output = ins.solve(input);
		Common.printArray(output);
		System.out.println();

		input = new int[] { 1, 2, 0, 0, 1, 0, 2, 2, 2, 0, 2, 0, 1, 1, 0, 2, 1 };
		Common.printArray(input);
		output = ins.solve(input);
		Common.printArray(output);
		System.out.println();

		System.out.print("Total time = ");
		System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
	}

	public int[] solve(int[] input) {
		if (input == null || input.length <= 1) {
			return input;
		}


		// left is at the leftmost non-0 position
		// right is at rightmost non-2
		// mid is currently being evaluated (before mid, it's sorted)
		int left = 0, right = input.length - 1;
		int mid = left;
		
		while (mid <= right) {
			if (input[mid] > 1) {
				Common.swap(input, mid, right);
				right--;
			} else if (input[mid] < 1) {
				Common.swap(input, left, mid);
				left++;
				mid++;
			} else {
				mid++;
			}
		}

		return input;
	}

}
