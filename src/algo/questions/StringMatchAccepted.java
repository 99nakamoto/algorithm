package algo.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class StringMatchAccepted {

	List<String> words = new ArrayList<String>();

	public void initWithString(String str) {
		if (str == null || str.length() == 0) {
			return;
		}
		HashSet<String> set = new HashSet<String>();
		int len = str.length();
		for (int i = 0; i < len; i++) {
			// put all substrings of str (with length 10 or less)
			// into the HashSet
			set.add(str.substring(i, Math.min(i + 10, len)));
		}
		for (String s : set) {
			words.add(s);
		}
		Collections.sort(words);
		// now words contains all substrings with length = 10 or less
		// use binary search to find the query string from words
	}

	public boolean existSubString(String query) {
		int len = words.size();
		int left = 0;
		int right = len - 1;
		while (left < right + 1) {
			int mid = left + (right - left) / 2;
			String word = words.get(mid);
			int val = word.compareTo(query);
			if (val == 0) {
				return true;
			} else if (word.startsWith(query)) {
				return true;
			} else {
				if (val < 0) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		StringMatchAccepted ins = new StringMatchAccepted();
		ins.initWithString("n");
		System.out.println(ins.existSubString("n"));
	}
}
