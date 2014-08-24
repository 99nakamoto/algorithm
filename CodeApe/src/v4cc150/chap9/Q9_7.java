package v4cc150.chap9;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q9_7 {

	// A circus is designing a tower routine consisting of people standing atop
	// one another's shoulders. For practical and aesthetic reasons, each
	// person must be both shorter and lighter than the person below him or her.
	// Given the heights and weights of each person in the circus, write a
	// method to compute the largest possible number of people in such a
	// tower.

	// EXAMPLE:

	// Input (ht, wt): (65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
	// Output: The longest tower is length 6 and includes from top to bottom:
	// (56, 90) (60,95) (65,100) (68,110) (70,150) (75,190)

	public int longestTower(List<Man> list) {
		Collections.sort(list, new ManComparator());
		// now find the longest increasing sequence of 'weight' property
		int len = list.size();
		int maxLen = 1;
		int[] dp = new int[len];
		for (int i = 1; i < len; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (list.get(i).weight > list.get(j).weight) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			maxLen = Math.max(maxLen, dp[i]);
		}
		return maxLen;
	}

	class ManComparator implements Comparator<Man> {
		@Override
		public int compare(Man o1, Man o2) {
			return o1.height - o2.height;
		}
	}

}