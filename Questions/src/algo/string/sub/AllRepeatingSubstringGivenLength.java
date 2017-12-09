package algo.string.sub;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import common.Common;

public class AllRepeatingSubstringGivenLength {

	public static void main(String[] args) {
		AllRepeatingSubstringGivenLength ins = new AllRepeatingSubstringGivenLength();

		List<String> list;

		list = ins.solve("abcabc", 1);
		Common.printList(list);

		list = ins.solve("abcabc", 2);
		Common.printList(list);

		list = ins.solve("abcabca", 2);
		Common.printList(list);

		list = ins.solve("abcabc", 3);
		Common.printList(list);
	}

	public List<String> solve(String input, int k) {
		List<String> ans = new ArrayList<String>();
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i <= input.length() - k; i++) {
			String sub = input.substring(i, i + k);
			if (set.contains(sub)) {
				ans.add(sub);
			}
			set.add(sub);
		}
		return ans;
	}
}
