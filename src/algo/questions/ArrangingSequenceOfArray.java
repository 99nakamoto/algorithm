package algo.questions;

public class ArrangingSequenceOfArray {

	// Input : 1 2 3 4 5 6 7 8 9 10 11 12 (even number input)
	// Output: 1 7 2 8 3 9 4 10 5 11 6 12

	// Input : 1 2 3 4 5 6 7 (odd number input)
	// Output: 1 5 2 6 3 7 4
	
	// Oh, man. This is not an easy baby. 

	public static void main(String[] args) {
		ArrangingSequenceOfArray ins = new ArrangingSequenceOfArray();
		int[] array1 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		int[] array2 = new int[] { 1, 2, 3, 4, 5, 6, 7 };

		ins.rearrange(array1);
		ins.rearrange(array2);

		printArray(array1);
		printArray(array2);
	}

	private static void printArray(int[] array) {
		for (Integer i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public void rearrange(int[] A) {
		int effLength = A.length;
		if (A.length % 2 == 0) {
			// for even number of input, last element is unchanged
			effLength--;
		}
		// make sure 'effLength' is an odd number.
		int half = effLength / 2 + 1;
		int pos = 1;
		int posValue = A[pos];
		int numSwaps = 0;
		boolean[] visited = new boolean[effLength];
		// visited is used as flag to avoid repeat swap
		// eg. when input is { 1, 2, 3, 4, 5, 6, 7 }, repeat swap as below:
		// 2 -> 3 -> 5 -> 2 -> 3 ...
		while (numSwaps < effLength - 1) {
			// swap (effLength - 1) times because 1st position is unchanged
			int newPos = getNewPosition(A, pos, half);
			if (visited[newPos]) {
				// if this new position is swap already, skip it
				pos = (pos + 1) % effLength;
				posValue = A[pos];
				continue;
			}
			int temp = A[newPos];
			A[newPos] = posValue;
			posValue = temp;
			pos = newPos;

			visited[newPos] = true;
			numSwaps++;
		}
	}

	private int getNewPosition(int[] array, int pos, int half) {
		if (pos < half) {
			return 2 * pos;
		} else {
			return 2 * (pos - half) + 1;
		}
	}
}
