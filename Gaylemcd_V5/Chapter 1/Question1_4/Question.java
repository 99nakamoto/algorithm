package Question1_4;

import CtCILibrary.AssortedMethods;

public class Question {
	// Assume string has sufficient free space at the end
	public static void replaceSpaces(char[] str, int length) {
		int spaceCount = 0, index, i = 0;
		for (i = 0; i < length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		index = length + spaceCount * 2;
		str[index] = '\0';
		for (i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				index = index - 3;
			} else {
				str[index - 1] = str[i];
				index--;
			}
		}
	}

	public static char[] replaceSpacesMe(String str) {
		int spaces = 0;
		for (char c : str.toCharArray()) {
			if (c == ' ')
				spaces++;
		}
		char[] result = new char[str.length() + (2 * spaces)];
		int p = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ') {
				result[p++] = str.charAt(i);
			} else {
				result[p++] = '%';
				result[p++] = '2';
				result[p++] = '0';
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String str = "abc d e f";
		char[] arr = new char[str.length() + 3 * 2 + 1];
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i);
		}

		replaceSpaces(arr, str.length());
		System.out.println(AssortedMethods.charArrayToString(arr));

		System.out.println(AssortedMethods
				.charArrayToString(replaceSpacesMe(str)));
	}
}
