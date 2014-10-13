import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
	public int ladderLength(String start, String end, Set<String> dict) {
		if (start == null || end == null || dict == null) {
			return 0;
		} else if (start.equals(end)) {
			return 1;
		}
		dict.remove(start);
		dict.remove(end);
		Queue<String> q = new LinkedList<String>();
		q.offer(start);
		int distance = 2;
		while (!q.isEmpty()) {
			for (int u = q.size(); u > 0; u--) {
				start = q.poll();
				for (int i = 0; i < start.length(); i++) {
					for (char c = 'a'; c <= 'z'; c++) {
						String word = start.substring(0, i) + c
								+ start.substring(i + 1);
						if (word.equals(end)) {
							return distance;
						}
						if (dict.contains(word)) {
							dict.remove(word);
							q.offer(word);
						}
					}
				}
			}
			distance++;
		}
		return 0;
	}

	public static void main(String[] args) {
		Solution ins = new Solution();
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("b");
		dict.add("c");
		System.out.println(ins.ladderLength("a", "b", dict));
	}
}
