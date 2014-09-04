package algo.questions;

public class RowWithMax1s {

	public int solution(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int p = n;
		int row = -1;
		for (int i = 0; i < m; i++) {
			// now p is larger than 0, otherwise it's already terminated
			if (matrix[i][p - 1] == 0) {
				continue;
			}
			// p points to a 1, now search to the left direction
			for (int j = p - 1; j >= 0; j--) {
				if (matrix[i][j] == 1) {
					p = j;
				} else {
					break;
				}
			}
			// p have a new value now
			if (p == 0) {
				return i;
			} else {
				row = i;
			}
		}
		return row;
	}

	public static void main(String[] args) {
		RowWithMax1s ins = new RowWithMax1s();
		int[][] input;

		input = new int[][] { { 0, 0, 1, 1 }, { 0, 0, 0, 1 }, { 0, 1, 1, 1 },
				{ 0, 0, 0, 0 }, { 0, 0, 0, 1 } };
		System.out.println(ins.solution(input) + " should be 2");

		input = new int[][] { { 0, 0, 1, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 0 } };
		System.out.println(ins.solution(input) + " should be 0");
	}
	
}
