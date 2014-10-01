package Question18_7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyAnswer {

	public static void printLongestWord(String[] arr) {
		Arrays.sort(arr, new LengthComparator());
		List<String> list = new ArrayList<String>(); 
		for (String str: arr) {
			list.add(str);
		}
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

	private static boolean helper(String word, int pos, int len, String[] arr) {
		if (pos == len) {
			return true;
		}
		for (int i = pos + 1; i <= len; i++) {
			String str = word.substring(pos, i);
			if (arr.)
		}
		return false;
	}
}
