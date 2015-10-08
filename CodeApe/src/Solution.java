import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Solution ins = new Solution();
		System.out.println(ins.wordPattern("abba", "dog cat cat dog"));
	}

	public boolean wordPattern(String pattern, String str) {
		if (pattern == null || str == null) {
			return false;
		}
		String[] words = str.split(" ");
		char[] letters = pattern.toCharArray();
		if (words.length != letters.length) {
			return false;
		}
		// use a Set to check duplication
		// and use an array to do mapping
		Set<String> set = new HashSet<String>();
		String[] mapping = new String[26];
		for (int i = 0; i < words.length; i++) {
			if (set.contains(words[i])) {
				if (!mapping[letters[i] - 'a'].equals(words[i])) {
					return false;
				}
			} else {
				set.add(words[i]);
				mapping[letters[i] - 'a'] = words[i];
			}
		}
		return true;
	}
}
