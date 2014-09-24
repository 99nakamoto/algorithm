package Question11_2;

import java.util.Arrays;
import java.util.Comparator;

import CtCILibrary.AssortedMethods;

public class MyAnswerComparator {

	public static void sort(String[] array) {
		Arrays.sort(array, new AnagramComparatorMe());
	}

	public static void main(String[] args) {
		String[] array = { "apple", "banana", "carrot", "ele", "duck", "papel",
				"tarroc", "cudk", "eel", "lee" };
		System.out.println(AssortedMethods.stringArrayToString(array));
		sort(array);
		System.out.println(AssortedMethods.stringArrayToString(array));
	}
}

class AnagramComparatorMe implements Comparator<String> {

	public int compare(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		return String.valueOf(c1).compareTo(String.valueOf(c2));
	}
}
