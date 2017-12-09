package algo.questions;

import java.util.ArrayList;
import java.util.List;

import common.Common;

public class FormQueueGivenHeights {

	public static void main(String[] args) {
		FormQueueGivenHeights ins = new FormQueueGivenHeights();

		int[] countArray;
		int[] originalArray;

		countArray = new int[] { 0, 1, 1 };
		originalArray = ins.form(3, countArray);
		System.out.println("Result: ");
		Common.printArray(originalArray);

		countArray = new int[] { 0, 0, 2, 0 };
		originalArray = ins.form(4, countArray);
		System.out.println("Result: ");
		Common.printArray(originalArray);
	}

	public int[] form(int peopleCount, int[] countArray) {
		int len = peopleCount;
		int[] heightQueue = new int[len];
		List<Integer> list = new ArrayList<Integer>();
		for (int i = peopleCount; i > 0; i--) {
			list.add(i);
		}
		for (int i = len - 1; i >= 0; i--) {
			heightQueue[i] = list.remove(countArray[i]);
		}
		return heightQueue;
	}
}
