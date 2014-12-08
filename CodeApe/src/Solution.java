import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		int[] num = new int[] { 0, 0, 0, 0 };
		threeSum(num);
	}

	public static List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		if (num == null || num.length < 3) {
			return ans;
		}
		Arrays.sort(num);
		int len = num.length;
		int left, right;
		for (int i = 0; i < len; i++) {
			left = i + 1;
			right = len - 1;
			while (left < right) {
				int sum = num[i] + num[left] + num[right];
				if (sum == 0) {
					// now one triplet is found, add it to ans list
					List<Integer> ls = new ArrayList<Integer>();
					ls.add(num[i]);
					ls.add(num[left]);
					ls.add(num[right]);
					ans.add(ls);
				}
				// shrink the range between left and right pointer
				// (until the 2 pointers met)
				if (sum >= 0) {
					// move right pointer to the left
					right--;
					while (right >= 0 && num[right] == num[right + 1]) {
						right--;
					}
				}
				if (sum <= 0) {
					// move left pointer to the right
					left++;
					while (left < len && num[left] == num[left - 1]) {
						left++;
					}
				}
			}
		}
		return ans;
	}

}
