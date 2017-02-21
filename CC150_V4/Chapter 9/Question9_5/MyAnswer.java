package Question9_5;

public class MyAnswer {

	public static int search(String[] input, String target) {
		if (target == null || target.length() == 0) {
			return -1;
		}
		int len = input.length;
		int left = 0, right = len - 1;
		while (left < right) {
			int calculatedMid = left + (right - left) / 2;
			int comparisonMid = calculatedMid;
			while (comparisonMid < len && input[comparisonMid].length() == 0) {
				comparisonMid++;
			}
			if (input[comparisonMid].equals(target)) {
				return comparisonMid;
			} else if (input[comparisonMid].compareTo(target) < 0) {
				left = comparisonMid + 1;
			} else {
				right = calculatedMid - 1;
			}
		}
		if (left < len && input[left].equals(target)) {
			return left;
		} else {
			return -1;
		}
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
