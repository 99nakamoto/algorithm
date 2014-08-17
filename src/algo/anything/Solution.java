package algo.anything;

public class Solution {

	public static void main(String[] args) {
		int[] array = new int[] { 0, 1, 2 };
		Solution s = new Solution();
		System.out.println(s.firstMissingPositive(array));
	}

	public int firstMissingPositive(int[] A) {
		// basic idea: put number 'i' at position (i - 1)
		int len = A.length;
		int i = 0;
		while (i < len) {
			int currentVal = A[i];
			// put currentVal at position (currentVal - 1)
			if (i == currentVal - 1) {
				// already in correct spot
				i++;
				continue;
			} else if (currentVal - 1 < 0 || currentVal > len) {
				// number too small or too large, can't find a position
				i++;
				continue;
			} else if (A[currentVal - 1] == currentVal) {
				// value duplicate, skip it
				i++;
				continue;
			} else {
				A[i] = A[currentVal - 1];
				A[currentVal - 1] = currentVal;
			}
		}
		// now find out that mismatching value
		for (int j = 0; j < len; j++) {
			if (A[j] != j + 1) {
				return j + 1;
			}
		}
		return len + 1;
	}
}