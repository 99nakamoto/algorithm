package Question11_5;

public class MyAnswer {

	public static int search(String[] strings, String str) {
		return helper(strings, str, 0, strings.length - 1);
	}

	public static int helper(String[] array, String target, int left, int right) {
		if (right < left) {
			return -1;
		}
		int len = array.length;
		int mid = left + (right - left) / 2;
		int originalMid = mid;
		while (mid < len && array[mid] == "") {
			mid++;
		}
		if (array[mid] == " ") {
			return helper(array, target, left, originalMid - 1);
		} else if (array[mid].compareTo(target) < 0) {
			return helper(array, target, originalMid + 1, right);
		} else if (array[mid].compareTo(target) > 0) {
			return helper(array, target, left, originalMid - 1);
		} else { // target is found
			return mid;
		}
	}

	public static void main(String[] args) {

		String[] stringList = { "apple", "", "", "banana", "", "", "",
				"carrot", "duck", "", "", "eel", "", "flower" };
		System.out
				.println(search(stringList, "don't exist") + " should be -1.");

		for (String s : stringList) {
			if (s.length() == 0) {
				continue;
			}
			String cloned = new String(s);
			System.out.println("<" + cloned + "> " + " appears at location "
					+ search(stringList, cloned));
		}
	}
}
