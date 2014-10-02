package Question18_7;

import java.util.Arrays;
import java.util.HashSet;

public class MyAnswer {

	public static void printLongestWord(String[] arr) {
		Arrays.sort(arr, new LengthComparator());
		HashSet<String> set = new HashSet<String>();
		for (String str : arr) {
			set.add(str);
		}
		for (String word : arr) {
			if (canDivide(word, 0, set)) {
				System.out.println(word);
				return;
			}
		}
		System.out.println("can not find such word");
	}

	private static boolean canDivide(String word, int from, HashSet<String> set) {
		if (from == word.length()) {
			return true;
		}
		for (int i = from; i < word.length(); i++) {
			String str = word.substring(from, i + 1);
			if (from == 0 && i == word.length() - 1) {
				continue;
			} else if (!set.contains(str)) {
				continue;
			}
			if (canDivide(word, i + 1, set)) {
				return true;
			}
		}
		return false;
	}

}
