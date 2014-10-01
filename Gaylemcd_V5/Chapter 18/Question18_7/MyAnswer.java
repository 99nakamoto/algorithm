package Question18_7;

import java.util.Arrays;

public class MyAnswer {

	public static void printLongestWord(String[] arr) {
		Arrays.sort(arr, new LengthComparator());
		for (String word: arr) {
			if (canDivide(word, arr)) {
				System.out.println(word);
				return;
			}
		}
		System.out.println("can not find such word");
	}

	private static boolean canDivide(String word, String[] arr) {

		return false;
	}
}
