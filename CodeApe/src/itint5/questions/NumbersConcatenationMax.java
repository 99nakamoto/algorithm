package itint5.questions;

import java.util.Arrays;
import java.util.Comparator;

public class NumbersConcatenationMax {

	public static void main(String[] args) {
		NumbersConcatenationMax ins = new NumbersConcatenationMax();

		System.out.println("Test start");
		String[] a1 = new String[] { "40", "20", "201" };
		String[] a2 = new String[] { "40", "20", "203" };
		System.out.println(ins.biggestNum(a1) + " should be 4020201");
		System.out.println(ins.biggestNum(a2) + " should be 4020320");
	}

	public String biggestNum(String[] nums) {
		Arrays.sort(nums, new SpecialComparator());
		StringBuilder sb = new StringBuilder();
		for (int i = nums.length - 1; i >= 0; i--) {
			sb.append(nums[i]);
		}
		return sb.toString();
	}

	class SpecialComparator implements Comparator<String> {
		public int compare(String s1, String s2) {
			// eg.
			// 40 > 20
			// 20 > 201
			// 203 > 20
			String firstNum = s1 + s2;
			String secondNum = s2 + s1;
			return firstNum.compareTo(secondNum);
		}
	}

}
