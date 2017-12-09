package algo.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import common.Common;

public class InsertPlusMinus {

	public static void main(String[] args) {
		InsertPlusMinus ins = new InsertPlusMinus();
		long startTime = System.currentTimeMillis();

		System.out.println("Start Run... ");
		String str;

		str = "4312";
		System.out.println("Input is " + str);
		Common.printList(ins.solve(str));
		System.out.println();

		str = "43868643";
		System.out.println("Input is " + str);
		Common.printList(ins.solve(str));
		System.out.println();

		System.out.print("Total time = ");
		System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
	}

	public List<String> solve(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}
		List<String> result = new ArrayList<String>();
		helper(result, "", 0, str);
		Collections.sort(result);
		return result;
	}

	private void helper(List<String> result, String curExp, int curVal, String remain) {
		if (curVal == Integer.parseInt(remain)) {
			result.add(curExp + "=" + remain);
		} else if (curVal + Integer.parseInt(remain) == 0) {
			result.add(curExp + "=-" + remain);
		}
		for (int i = 1; i < remain.length(); i++) {
			String nextStr = remain.substring(0, i);
			int nextNum = Integer.parseInt(nextStr);

			// case 1: add a + between curExp and nextStr
			String newExp = curExp + "+" + nextStr;
			int newVal = curVal + nextNum;
			helper(result, newExp, newVal, remain.substring(i));

			// case 2: '-' sign
			newExp = curExp + "-" + nextStr;
			newVal = curVal - nextNum;
			helper(result, newExp, newVal, remain.substring(i));
		}
	}
}
