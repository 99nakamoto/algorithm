package cc150.common;

import java.util.ArrayList;
import java.util.Arrays;

public class DummyClass {

	public static void main(String[] args) {
		DummyClass dm = new DummyClass();
		int[] nums = new int[] { 10, 1, 2, 7, 6, 1, 5 };
		ArrayList<ArrayList<Integer>> ans = dm.combinationSum(nums, 8);
		for (ArrayList<Integer> list : ans) {
			for (Integer ii : list) {
				System.out.print(ii + " ");
			}
			System.out.println();
		}
	}

	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
			int target) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(candidates);
		helper(ans, new ArrayList<Integer>(), candidates, 0, 0, target);
		return ans;
	}

	private void helper(ArrayList<ArrayList<Integer>> ans,
			ArrayList<Integer> path, int[] nums, int pos, int sum, int target) {
		if (sum > target) {
			return;
		} else if (sum == target) {
			ans.add(new ArrayList<Integer>(path));
			return;
		}
		for (int i = pos; i < nums.length; i++) {
			if (i > 0 && nums[i - 1] == nums[i]) {
				continue;
			}
			path.add(nums[i]);
			helper(ans, path, nums, i + 1, sum + nums[i], target);
			path.remove(path.size() - 1);
		}
	}
}