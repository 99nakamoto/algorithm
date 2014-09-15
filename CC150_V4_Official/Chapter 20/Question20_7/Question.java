package Question20_7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;

public class Question {

	public static void printLongestWord(String arr[]) {
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		for (String str : arr) {
			map.put(str, true);
		}
		Arrays.sort(arr, new LengthComparator()); // Sort by length

		for (int i = 0; i < arr.length; i++) {
			String str = new String(arr[i]);
			Set<String> keys = map.keySet();
			String keyArr[] = new String[keys.size()];
			int k = 0;
			for (String s : keys) {
				keyArr[k] = new String(s);
				k++;
			}
			/* Sort so that we get the longest string to replace */
			Arrays.sort(keyArr, new LengthComparator());
			for (String j : keyArr) {
				if (j.equals(arr[i]))
					continue;
				str = str.replaceAll(j, "");
			}
			/* If we get a string of size 0, it's the required word */
			if (str.length() == 0) {
				System.out.println("Longest word: " + arr[i]);
				return;
			}
		}
		System.out.println("No such word");
	}

	public static void main(String[] args) {
		String[] arr;

		arr = new String[] { "test", "tester", "testertest", "testing",
				"apple", "seattle", "banana", "batting", "cat", "bat",
				"testingtester", "testbattingcat" };
		printLongestWord(arr);

		System.out.println();
		System.out.println("This solution is wrong, look: ");

		arr = new String[] { "abcd", "abc", "ab", "cd" };
		printLongestWord(arr);

		arr = new String[] { "abc", "ab", "a", "bc" };
		printLongestWord(arr);
	}
}

class LengthComparator implements Comparator<String> {
	public int compare(String o1, String o2) {
		if (o1.length() < o2.length())
			return 1;
		if (o1.length() > o2.length())
			return -1;
		return 0;
	}
}
