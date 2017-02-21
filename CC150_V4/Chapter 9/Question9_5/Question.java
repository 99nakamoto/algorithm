package Question9_5;

public class Question {

	public static int search(String[] input, String target) {
		if (input == null || target == null) {
			return -1;
		}
		if (target == "") {
			for (int i = 0; i < input.length; i++) {
				if (input[i] == "") {
					return i;
				}
			}
			return -1;
		}
		return search(input, target, 0, input.length - 1);
	}

	private static int search(String[] strings, String str, int first, int last) {
		while (first <= last) {
			// Ensure there is something at the end
			while (first <= last && strings[last] == "") {
				--last;
			}
			if (last < first) {
				return -1; // this block was empty, so fail
			}
			int mid = (last + first) >> 1;
			while (strings[mid] == "") {
				++mid; // will always find one
			}
			int r = strings[mid].compareTo(str);
			if (r == 0)
				return mid;
			if (r < 0) {
				first = mid + 1;
			} else {
				last = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		String[] stringList = { "apple", "", "", "banana", "", "", "",
				"carrot", "duck", "", "", "eel", "", "flower" };

		for (String s : stringList) {
			System.out.println("<" + s + "> " + " appears at location "
					+ search(stringList, s));
		}

		String s = "harry";
		printMsg(s, search(stringList, s));

		s = "-343";
		printMsg(s, search(stringList, s));
	}

	private static void printMsg(String s, int result) {
		System.out.println("<" + s + "> " + " appears at location " + result);
	}
}
