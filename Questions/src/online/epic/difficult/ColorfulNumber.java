package online.epic.difficult;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// code is from http://www.careercup.com/question?id=12411025

// Determine whether a number is colorful or not. 263 is a colorful number because (2,6,3,2x6,6x3,2x3x6) are all different whereas 236 is not because (2,3,6,2x3,3x6,2x3x6) have 6 twice. So take all consecutive subsets of digits, take their product and ensure all the products are different

public class ColorfulNumber {

	public static void main(String[] args) {
		ColorfulNumber ins = new ColorfulNumber();

		// test 1
		System.out.println("Test 1: 4293: " + ins.isColorful(4293));
		ins.isColorful(4293);

		// test 2
		System.out.println("Test 2: ");
		for (int i = 1; i < 10; i++) {
			int rand = (int) (Math.random() * 5000);
			System.out.println(i + ". " + rand + " is colorful? "
					+ ins.isColorful(rand));
		}
	}

	private boolean isColorful(int num) {
		int current = 0;
		int listEnd = 0;
		List<Integer> list = new ArrayList<Integer>();
		while (num != 0) {
			// get the last digit as r, and rest of the number save back to num
			int digit = num % 10;
			num = num / 10;
			listEnd = list.size();
			// this for-loop iterative all products produced with previous digit
			for (int i = current; i < listEnd; i++) {
				list.add(list.get(i) * digit);
			}
			list.add(digit);
			current = listEnd;
		}
		// all products are in list now, check duplication
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i : list) {
			if (set.contains(i)) {
				return false;
			} else {
				set.add(i);
			}
		}
		return true;
	}
}
