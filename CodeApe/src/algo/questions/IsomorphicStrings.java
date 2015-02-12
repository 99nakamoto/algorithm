package algo.questions;
import java.util.HashMap;

public class IsomorphicStrings {

	public static void main(String[] args) {
		IsomorphicStrings ins = new IsomorphicStrings();
		long startTime = System.currentTimeMillis();

		System.out.println("Code Ape Run... ");
		System.out.println(ins.isomorphic("abc", "acb") + " should be true");
		System.out.println(ins.isomorphic("foo", "app") + " should be true");
		System.out.println(ins.isomorphic("turtle", "tletur")
				+ " should be true");
		System.out.println(ins.isomorphic("bar", "foo") + " should be false");
		System.out.println(ins.isomorphic("hate", "hell") + " should be false");

		System.out.print("Total time = ");
		System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
	}

	public boolean isomorphic(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		return (sequence(s).equals(sequence(t)));
	}

	private String sequence(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				sb.append(map.get(s.charAt(i)));
			} else {
				map.put(s.charAt(i), i);
			}
		}
		return sb.toString();
	}
}
