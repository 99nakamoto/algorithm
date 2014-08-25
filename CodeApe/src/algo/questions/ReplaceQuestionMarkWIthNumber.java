package algo.questions;

import java.util.ArrayList;
import java.util.List;

import common.Common;

public class ReplaceQuestionMarkWIthNumber {

	public static void main(String[] args) {
		ReplaceQuestionMarkWIthNumber ins = new ReplaceQuestionMarkWIthNumber();
		List<String> result = ins.solution("a?b?c?");
		System.out.println();
		Common.printList(result);
	}

	public List<String> solution(String str) {
		List<String> result = new ArrayList<String>();
		helper(result, str.toCharArray(), 0);
		return result;
	}

	private void helper(List<String> result, char[] letters, int pos) {
		if (pos == letters.length) {
			result.add(String.valueOf(letters));
			return;
		} else if (letters[pos] != '?') {
			helper(result, letters, pos + 1);
			return;
		}
		for (char i = '0'; i <= '1'; i++) {
			// put char i in letters[] to replace the '?'
			letters[pos] = i;
			helper(result, letters, pos + 1);
			letters[pos] = '?';
		}
	}
}
