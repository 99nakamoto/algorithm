package algo.leetcode_plus;

import java.util.LinkedList;
import java.util.List;

import common.Common;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		SlidingWindowMaximum ins = new SlidingWindowMaximum();
		int[] array = { 1, 3, -1, -3, 5, 3, 6, 7 };

		System.out.print("Input is                 ");
		Common.printArray(array);

		for (int i = 1; i <= array.length; i++) {
			System.out.print("Output for window size " + i + ": ");
			Common.printArray(ins.slidingWindowMax(array, i));
		}
	}

	public int[] slidingWindowMax(int[] array, int w) {
		int[] ans = new int[array.length - w + 1];
		List<Integer> q = new LinkedList<Integer>();
		// Queue stores indices of array, and values are in decreasing order.
		// In this way, the top element in queue is the max in window
		for (int i = 0; i < array.length; i++) {
			// 1. remove element from head until first number within window
			if (!q.isEmpty() && q.get(0) + w <= i) {
				// it's OK to change 'while' to 'if' in the line above
				// cuz we actually remove 1 element at most
				q.remove(0);
			}
			// 2. before inserting i into queue, remove from the tail of the
			// queue indices with smaller value they array[i]
			while (!q.isEmpty() && array[q.get(q.size() - 1)] <= array[i]) {
				q.remove(q.size() - 1);
			}
			q.add(i);
			// 3. set the max value in the window (always the top number in
			// queue)
			if (i + 1 >= w) {
				ans[i + 1 - w] = array[q.get(0)];
			}
		}
		return ans;
	}
}
