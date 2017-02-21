package algo.questions;

import common.Common;

public class GetMaxNumberGame {

	public static void main(String[] args) {
		GetMaxNumberGame ins = new GetMaxNumberGame();
		long startTime = System.currentTimeMillis();

		System.out.println("Start Run... ");
		int[] input;

		input = new int[] { 1, 4, 3, 2 };
		System.out.print("Input ");
		Common.printArray(input);
		System.out.println("max sum for player 1 is " + ins.getMaxSumPlayerOne(input));
		System.out.println();

		input = new int[] { 7, 5, 2, 6, 9, 8, 3, 4 };
		System.out.print("Input ");
		Common.printArray(input);
		System.out.println("max sum for player 1 is " + ins.getMaxSumPlayerOne(input));
		System.out.println();

		System.out.print("Total time = ");
		System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
	}

	public int getMaxSumPlayerOne(int[] input) {
		int len = input.length;
		// sum[i][j] sum of number from i to j
		int[][] sum = new int[len][len];
		// val[i][j]: the max value that can be obtained if only
		// the range [i,j] is left and you take the move first
		int[][] val = new int[len][len];
		// pos is related to val, as it denotes whether we take i or j
		int[][] pos = new int[len][len];

		// 1. fill in sum[][]
		for (int x = 0; x < len; x++) {
			for (int y = x; y < len; y++) {
				if (x == y) {
					sum[x][y] = input[x];
				} else if (x == 0) {
					// fill up the first row in the sum[][] dp array
					sum[x][y] = sum[x][y - 1] + input[y];
				} else {
					// starting from the 2nd row, it's gonna make use of 1st row
					// x >= 1
					sum[x][y] = sum[0][y] - sum[0][x - 1];
				}
			}
		}

		// 2. fill in val[][] and pos[][]
		for (int x = len - 1; x >= 0; x--) {
			for (int y = x; y < len; y++) {
				if (x == y) {
					val[x][y] = input[x];
					pos[x][y] = x;
				} else {
					// when I choose either x or y, I look at what the opponent
					// is gonna get after my move, then chose the smaller
					// v[][] for the remaining part
					val[x][y] = sum[x][y] - Math.min(val[x + 1][y], val[x][y - 1]);
					pos[x][y] = val[x + 1][y] < val[x][y - 1] ? x : y;
				}
			}
		}
		this.printSteps(pos, len);
		return val[0][len - 1];
	}

	private void printSteps(int[][] pos, int len) {
		int a = 0;
		int b = len - 1;

		char player = '1';

		while (a <= b) {
			System.out.println("Player " + player + " take position " + pos[a][b]);
			player = player == '1' ? '2' : '1';
			if (pos[a][b] == a) {
				a++;
			} else if (pos[a][b] == b) {
				b--;
			} else {
				System.out.println("Debug: " + a + " " + pos[a][b] + " " + b);
			}
		}
	}
}
