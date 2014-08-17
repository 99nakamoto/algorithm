package algo.questions;

public class TopKQuickSelectAlgorithm {

	private static final int TOP_K = 3;

	public static void main(String args[]) {
		int[] _array = new int[] { 9, 2, 7, 8, 1, 12, 5, 6, 4 };
		System.out.println("Quickselect one:");
		quickSelect1(_array, TOP_K);
		printArray(_array);

		System.out.println("Quickselect two:");
		quickSelect2(_array, TOP_K);
		printArray(_array);
	}

	private static void printArray(int[] _array) {
		for (int i = 0; i < TOP_K; i++) {
			System.out.println(_array[i]);
		}
	}

	private static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	/**
	 * find the smallest k elements, and place them on the top k positions in
	 * the array
	 * 
	 * the solution 1 is the most standard
	 * 
	 * @param list
	 * @param k
	 */
	public static void quickSelect1(int[] list, int k) {
		selectHelper1(list, 0, list.length - 1, k);
	}

	public static void selectHelper1(int[] list, int left, int right, int k) {
		int pivotIndex = partition(list, left, right);
		if (pivotIndex == k) {
			return;
		} else if (k < pivotIndex) {
			selectHelper1(list, left, pivotIndex - 1, k);
		} else {
			selectHelper1(list, pivotIndex + 1, right, k);
		}
	}

	private static int partition(int[] list, int left, int right) {
		int pivot = left + (right - left) / 2;
		swap(list, right, pivot);
		for (int i = left; i < right; i++) {
			if (list[i] < list[right]) {
				swap(list, i, left);
				left++;
			}
		}
		swap(list, left, right);
		return left;
	}

	/**
	 * find the smallest k elements, and place them on the top k positions in
	 * the array
	 * 
	 * the solution  is the most standard
	 * 
	 * @param list
	 * @param k
	 */
	
	public static int quickSelect2(int[] arr, int k) {
		if (arr == null || arr.length <= k)
			throw new Error();
		int from = 0, to = arr.length - 1;
		// if from == to we reached the kth element
		while (from < to) {
			int r = from, w = to;
			int mid = arr[(r + w) / 2];
			// stop if the reader and writer meets
			while (r < w) {
				if (arr[r] >= mid) { // put the large values at the end
					swap(arr, w, r);
					w--;
				} else { // the value is smaller than the pivot, skip
					r++;
				}
			}
			// if we stepped up (r++) we need to step one down
			if (arr[r] > mid)
				r--;
			// the r pointer is on the end of the first k elements
			if (k <= r) {
				to = r;
			} else {
				from = r + 1;
			}
		}
		return arr[k];
	}
}