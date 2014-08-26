package algo.questions;

class Node {
	public Node[] childs = null;
}

public class DuplicateRowsInBinaryMatrix {
	public static int[][] uniqueRows(int[][] matrix) {
		int N = matrix.length;
		boolean[] isUnique = new boolean[N];
		int uniqueCount = 0;
		Node root = new Node();
		for (int i = 0; i < N; i++) {
			Node current = root;
			for (int j = 0; j < N; j++) {
				int index = matrix[i][j];
				if (null == current.childs) {
					current.childs = new Node[2];
				}
				if (null == current.childs[index]) {
					current.childs[index] = new Node();
					if ((N - 1) == j) {
						isUnique[i] = true;
						uniqueCount++;
					}
				}
				current = current.childs[index];
			}
		}

		int[][] result = new int[uniqueCount][];
		int resultCount = 0;
		for (int i = 0; i < N; i++) {
			if (isUnique[i]) {
				result[resultCount] = matrix[i];
				resultCount++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] matrix1 = { { 0, 1, 0, 0, 1 }, { 1, 0, 1, 1, 0 },
				{ 0, 1, 0, 0, 1 }, { 1, 1, 1, 0, 0 } };
		debug(uniqueRows(matrix1));
	}

	public static void debug(int[][] array) {
		debug(array, " ");
	}

	public static void debug(int[][] array, String separator) {
		for (int i = 0; i < array.length; i++) {
			debug(array[i], separator);
		}
	}

	public static void debug(int[] array, String separator) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < array.length - 1; i++) {
			buffer.append(array[i] + separator);
		}
		if (array.length > 0) {
			buffer.append(array[array.length - 1]);
		}
		System.out.println(buffer.toString());
	}
}