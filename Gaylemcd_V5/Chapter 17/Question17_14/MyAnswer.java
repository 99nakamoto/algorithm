package Question17_14;

import CtCILibrary.Trie;

public class MyAnswer {

	private static int min = Integer.MAX_VALUE;

	public static int parse(String doc, Trie dictionary) {
		helper(doc, dictionary, 0, 0, 0);
		return min;
	}

	private static void helper(String doc, Trie dict, int from, int until,
			int count) {
		
		System.out.println("Check " + from + " to " + until);
		int len = doc.length();

		// get the substring in the range of [from, until]
		// check whether we should insert a space after 'until'
		if (until == len) {
			if (from == len) {
				// last word finishes at the end of the sentence
				min = Math.min(min, count);
			} else {
				// do nothing
			}
			return;
		}

		// if we insert space after 'until'
		String substr = doc.substring(from, until + 1);
		if (dict.contains(substr)) {
			helper(doc, dict, until + 1, until + 1, count);
		} else {
			helper(doc, dict, until + 1, until + 1, count + until - from + 1);
		}
		
		// if we do not insert space after 'until'
		helper(doc, dict, from, until + 1, count);
	}

}
