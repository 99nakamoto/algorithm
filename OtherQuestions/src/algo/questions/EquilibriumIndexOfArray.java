package algo.questions;

import java.util.ArrayList;
import java.util.List;

import common.Common;

public class EquilibriumIndexOfArray {

	public static void main(String[] args) {
		EquilibriumIndexOfArray ins = new EquilibriumIndexOfArray();
		int[] array = { -7, 1, 5, 2, -4, 3, 0 };
		Common.printList(ins.findEI(array));
	}

	public List<Integer> findEI(int[] array) {
		List<Integer> ans = new ArrayList<Integer>();
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		int runningSum = 0;
		for (int i = 0; i < array.length; i++) {
			if (2 * runningSum + array[i] == sum) {
				ans.add(i);
			}
			runningSum += array[i];
		}
		return ans;
	}
}
