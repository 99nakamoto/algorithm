package Question5_7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyAnswer {

	public static int findMissing(List<BitInteger> list) {
		return helper(list, BitInteger.INTEGER_SIZE - 1);
	}

	private static int helper(List<BitInteger> list, int col) {
		if (list.size() == 0)
			return 0;
		List<BitInteger> zeroList = new ArrayList<BitInteger>();
		List<BitInteger> oneList = new ArrayList<BitInteger>();
		for (BitInteger bit : list) {
			if (bit.fetch(col) == 0) {
				zeroList.add(bit);
			} else {
				oneList.add(bit);
			}
		}
		if (zeroList.size() <= oneList.size()) {
			// this means the missing value contains a 0
			return helper(zeroList, col - 1) << 1;
		} else {
			// the missing value contains 1
			return helper(oneList, col - 1) << 1 | 1;
		}
	}

	/* Create a random array of numbers from 0 to n, but skip 'missing' */
	public static ArrayList<BitInteger> initialize(int n, int missing) {
		BitInteger.INTEGER_SIZE = Integer.toBinaryString(n).length();
		ArrayList<BitInteger> array = new ArrayList<BitInteger>();

		for (int i = 1; i <= n; i++) {
			array.add(new BitInteger(i == missing ? 0 : i));
		}

		// Shuffle the array once.
		for (int i = 0; i < n; i++) {
			int rand = i + (int) (Math.random() * (n - i));
			array.get(i).swapValues(array.get(rand));
		}

		return array;
	}

	// Test harness
	public static void main(String[] args) {
		Random rand = new Random();
		int n = rand.nextInt(300000) + 1;
		int missing = rand.nextInt(n + 1);
		ArrayList<BitInteger> array = initialize(n, missing);
		System.out.println("The array contains all numbers from 0 to " + n
				+ " except " + missing);

		int result = findMissing(array);
		if (result != missing) {
			System.out.println("Your solution is wrong\n"
					+ "The missing number is " + missing
					+ ", but the algorithm reported " + result);
		} else {
			System.out.println("The missing number is " + result);
		}
	}
}
