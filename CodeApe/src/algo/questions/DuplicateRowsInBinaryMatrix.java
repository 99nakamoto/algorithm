package algo.questions;

/*
 * The code is refacted by referring to:
 * http://www.careercup.com/question?id=9478119
 * 
 */
public class DuplicateRowsInBinaryMatrix {

	public int[][] getUniqueRows(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		TrieNode root = new TrieNode();
		TrieNode p;
		int uniqueCount = 0;
		boolean[] isUnique = new boolean[m];
		// isUnique is used to mark the lines that would appear in final result

		// start to build the trie
		for (int i = 0; i < m; i++) {
			// insert number matrix[i][] into the trie
			p = root;
			// root element would be an empty heading for all numbers
			for (int j = 0; j < n; j++) {
				int digit = matrix[i][j];
				if (p.kids == null) {
					p.kids = new TrieNode[2];
				}
				if (p.kids[digit] == null) {
					// this is a whole new branch, create a new node here
					p.kids[digit] = new TrieNode();
					if (j == n - 1) {
						uniqueCount++;
						isUnique[i] = true;
					}
				}
				p = p.kids[digit];
			}
		}
		System.out.println("uniqueCount is " + uniqueCount);
		int[][] result = new int[uniqueCount][];
		int k = 0;
		for (int w = 0; w < isUnique.length; w++) {
			if (isUnique[w]) {
				result[k++] = matrix[w];
			}
		}
		return result;
	}

	class TrieNode {
		TrieNode[] kids = null;
	}

	public static void main(String[] args) {
		DuplicateRowsInBinaryMatrix ins = new DuplicateRowsInBinaryMatrix();
		int[][] matrix1 = { { 1, 0, 0, 0, 0 }, { 1, 0, 0, 0, 1 },
				{ 1, 0, 0, 1, 1 }, { 1, 0, 0, 1, 1 }, { 1, 0, 0, 1, 1 },
				{ 1, 0, 0, 0, 1 } };

		printResult(ins.getUniqueRows(matrix1), " ");
	}

	public static void printResult(int[][] array, String separator) {
		for (int[] line : array) {
			for (Integer i : line) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}