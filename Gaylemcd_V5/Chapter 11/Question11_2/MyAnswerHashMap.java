package Question11_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import CtCILibrary.AssortedMethods;

public class MyAnswerHashMap {

	public static void sort(String[] array) {

		HashMap<String, List<String>> map = new HashMap<String, List<String>>();

		for (String str : array) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String keyStr = String.valueOf(chars);
			if (!map.containsKey(keyStr)) {
				map.put(keyStr, new ArrayList<String>());
			}
			map.get(keyStr).add(str);
		}

		for (List<String> list : map.values()) {
			for (String str : list) {
				System.out.print(str + ", ");
			}
		}
	}

	public static void main(String[] args) {
		String[] array = { "apple", "banana", "carrot", "ele", "duck", "papel",
				"tarroc", "cudk", "eel", "lee" };
		System.out.println(AssortedMethods.stringArrayToString(array));
		sort(array);
	}
}
