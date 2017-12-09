package algo.questions;

import java.util.Comparator;
import java.util.PriorityQueue;

import common.Pair;

public class MinRangeIncludesAtLeastOne {

	private static final int SIZE = 3;

	public static void main(String[] args) {
		MinRangeIncludesAtLeastOne ins = new MinRangeIncludesAtLeastOne();

		int[][] input = new int[SIZE][];

		System.out.println("Test 1");
		input[0] = new int[] { 0, 9, 255 };
		input[1] = new int[] { 2, 7, 257 };
		input[2] = new int[] { 8, 12, 258 };
		ins.printMinRange(input);

		System.out.println("Test 2");
		input[0] = new int[] { 0, 1, 12 };
		input[1] = new int[] { 2, 11, 500 };
		input[2] = new int[] { 9, 52, 258 };
		ins.printMinRange(input);
	}

	public void printMinRange(int[][] input) {
		Comparator<Pair> compr = new HeapComparator(input);
		// Note that we pass in 'input' arrays to the comparator
		PriorityQueue<Pair> heap = new PriorityQueue<Pair>(SIZE, compr);

		int maxVal = Integer.MIN_VALUE;
		for (int i = 0; i < SIZE; i++) {
			heap.add(new Pair(i, 0));
			// insert the head of each array into the heap
			maxVal = Math.max(maxVal, input[i][0]);
			// keep additional value to keep track of the max value in heap
		}

		int left = 0;
		int right = Integer.MAX_VALUE;
		while (heap.size() == SIZE) {
			Pair p = heap.remove();
			// first, update the range
			if (maxVal - input[p.x][p.y] < right - left) {
				right = maxVal;
				left = input[p.x][p.y];
			}
			// then, push the next element after 'p' to the heap
			// meanwhile, update 'maxVal'
			if (p.y + 1 < input[p.x].length) {
				Pair nextP = new Pair(p.x, p.y + 1);
				heap.add(nextP);
				maxVal = Math.max(maxVal, input[nextP.x][nextP.y]);
			}
			// when 'p' is the last element in the row, terminate loop
		}
		System.out.println("Left boundary: " + left);
		System.out.println("Right boundary: " + right);
	}

	class HeapComparator implements Comparator<Pair> {

		int[][] arrays = null;

		public HeapComparator(int[][] input) {
			arrays = input;
		}

		public int compare(Pair p1, Pair p2) {
			return arrays[p1.x][p1.y] - arrays[p2.x][p2.y];
		}
	}

}
