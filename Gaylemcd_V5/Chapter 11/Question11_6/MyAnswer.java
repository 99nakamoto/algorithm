package Question11_6;

import CtCILibrary.*;

public class MyAnswer {

	public static boolean findElement(int[][] matrix, int target) {
		// start from bottom left corner
		int x = matrix.length - 1;
		int y = 0;
		while (x >= 0 && y < matrix[0].length) {
			if (matrix[x][y] == target) {
				return true;
			} else if (matrix[x][y] > target) {
				x--;
			} else {
				y++;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int M = 10;
		int N = 5;
		int[][] matrix = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = 10 * i + j;
			}
		}

		AssortedMethods.printMatrix(matrix);
		System.out.println();

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				int v = 10 * i + j;
				System.out.println(v + ": " + findElement(matrix, v));
				if (j == 9)
					System.out.println();
			}
		}

	}
}
