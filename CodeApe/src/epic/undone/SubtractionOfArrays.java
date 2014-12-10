package epic.undone;

import java.util.ArrayList;
import java.util.List;

import common.Common;

public class SubtractionOfArrays {

	public static void main(String[] args) {
		SubtractionOfArrays ins = new SubtractionOfArrays();

		int[] a = { 5 };
		int[] b = { 127 };
		Common.printList(ins.substractArray(a, b));

		System.out.println();
	}

	private void solution() {

	}

	// this code is wrong! 
	public static List<Integer> substractArray(int[] a, int[] b) {
		if (a == null || b == null)
			return null;
		List<Integer> res = new ArrayList<Integer>();

		int ptr1 = a.length - 1;
		int ptr2 = b.length - 1;
		int carry = 0;
		int diff = 0;
		while (ptr1 >= 0 || ptr2 >= 0) {
			if (ptr2 >= 0) {
				diff = (10 + a[ptr1] - b[ptr2] - carry);
				carry = diff / 10 == 1 ? 0 : 1;
				res.add(0, diff % 10);
				ptr2--;
				ptr1--;
			} else if (ptr1 >= 0) {
				if (ptr1 == 0 && carry == 1 && a[ptr1] == 1) { // special case
																// first digits
																// = 1;
					ptr1--;
					continue;
				}
				diff = (10 + a[ptr1] - carry);
				carry = diff / 10 == 1 ? 0 : 1;
				res.add(0, diff % 10);
				ptr1--;
			}
		}
		return res;
	}

}
