package Question18_2;

import CtCILibrary.AssortedMethods;

public class MyAnswer {

	public static void shuffleArrayInteratively(int[] cards) {
		for (int i = 0; i < cards.length; i++) {
			// all nums to the left of (i) is 'dead', don't consider them
			int choose = rand(i, cards.length - 1);
			swap(cards, i, choose);
			// now (i) is also 'dead'
		}
	}

	private static int rand(int from, int to) {
		int count = to - from + 1;
		return from + (int) (Math.random() * count);
	}

	private static void swap(int[] nums, int a, int b) {
		if (a == b) {
			return;
		}
		nums[a] ^= nums[b];
		nums[b] ^= nums[a];
		nums[a] ^= nums[b];
	}

	public static void main(String[] args) {
		int[] cards = { -5, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(AssortedMethods.arrayToString(cards));

		shuffleArrayInteratively(cards);
		System.out.println(AssortedMethods.arrayToString(cards));
	}

}
