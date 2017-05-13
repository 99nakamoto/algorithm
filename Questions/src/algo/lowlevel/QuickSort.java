package algo.lowlevel;

public class QuickSort {

	// http://www.programcreek.com/2012/11/quicksort-array-in-java/
	// this code is not written by me

	public static void main(String[] args) {
		int[] x = { 9, 7, 2, 7, 3, 7, 10 };
		int[] x2 = { 9, 7, 2, 7, 3, 7, 10 };
		printArray("original list: ", x);

		int low = 0;
		int high = x.length - 1;

		quickSort(x, low, high);
		quickSortRan(x2, low, high);
		printArray("original algo: ", x);
		printArray("written by me: ", x2);
	}

	public static void quickSortRan(int[] arr, int low, int high) {
		if (low >= high) {
			return;
		}
		int pivot = arr[low + (high - low) / 2];
		int left = low;
		int right = high;
		while (left < right) {
			while (arr[left] < pivot) {
				left++;
			}
			while (arr[right] > pivot) {
				right--;
			}
			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		quickSortRan(arr, low, right);
		quickSortRan(arr, left, high);
	}

	public static void quickSort(int[] arr, int low, int high) {

		if (arr == null || arr.length == 0)
			return;

		if (low >= high)
			return;

		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];

		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}

			while (arr[j] > pivot) {
				j--;
			}

			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}

		// recursively sort two sub parts
		quickSort(arr, low, j);
		quickSort(arr, i, high);
	}

	public static void printArray(String str, int[] x) {
		System.out.print(str + " ");
		for (int a : x)
			System.out.print(a + " ");
		System.out.println();
	}
}
