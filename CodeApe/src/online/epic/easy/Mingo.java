package online.epic.easy;

public class Mingo {

	// Mingo
	//
	// 抽奖。有个一百乘一百的方阵，每个格子背面有个一到一百万的随机数且互不重复，
	// 现在嘉宾喊一串数字，如果有格子背面正好是这个数字则翻到正面。任何时候，
	// 如果有一行、一列或一对角线的所有格子都被翻到正面，则游戏终止、嘉宾中奖。
	// 给你此方阵和嘉宾打算喊的一串数字，求该嘉宾能中奖否，若能，喊到第几个数可以中奖？

	int[][] matrix = new int[10][10];

	// first 10 nums in fillArray is for rows
	// second 10 nums for cols, and 2 other for diagonal
	int[] fillArray = new int[22];
	int mingoCount = 1;

	public static void main(String[] args) {
		Mingo mingo = new Mingo();
		mingo.initializeMatrix();
		mingo.callOutRandomNumbers();
		mingo.printOutMingle();
	}

	void initializeMatrix() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = 0;
			}
		}
	}

	void printOutMingle() {
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				for (int g = String.valueOf(matrix[i][j]).length(); g < 6; g++) {
					System.out.print(" ");
				}
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}

	void callOutRandomNumbers() {
		int value = 0;
		int row = 0;
		int col = 0;
		for (int i = 0; i < 100; i++) {
			value = (int) (Math.random() * 100);
			row = value / 10;
			col = value - row * 10;
			while (matrix[row][col] != 0) {
				value = (int) (Math.random() * 100);
				row = value / 10;
				col = value - row * 10;
			}
			// input in a random num in position (row, col)
			matrix[row][col] = (int) (Math.random() * 1000);
			checkMingleState(row, col);
		}
	}

	void checkMingleState(int row, int col) {
		// update fillArray counts for row and col
		this.fillArray[row]++;
		this.fillArray[col + 10]++;
		// check if any row/col is filled with 10 numbers
		if (fillArray[row] == 10) {
			System.out.println("Mingo " + mingoCount++ + ": Row " + row);
		}
		if (fillArray[col + 10] == 10) {
			System.out.println("Mingo " + mingoCount++ + ": Column " + col);
		}
		// while diagonal is different, we need some pre-check
		// be careful here! the sysout must be inside the if-condition
		if (row == col) {
			fillArray[20]++;
			if (fillArray[20] == 10) {
				System.out.println("Mingo " + mingoCount++ + ": Diagonal 1! ");
			}
		}
		if (row + col == 9) {
			fillArray[21]++;
			if (fillArray[21] == 10) {
				System.out.println("Mingo " + mingoCount++ + ": Diagonal 2! ");
			}
		}
	}
}
