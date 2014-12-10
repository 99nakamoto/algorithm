package epic.undone;

import common.Common;

public class TicTacToe {

	public static void main(String[] args) {
		TicTacToe ins = new TicTacToe();

		int size = 5;
		boolean[][] board = new boolean[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				board[i][j] = Math.random() > 0.5 ? true : false;
			}
		}
		ins.ticTacToe(board);
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(" " + (board[i][j] ? 'R' : 'B'));
			}
			System.out.println();
		}

		System.out.println();
	}

	private void solution() {

	}

	public static void ticTacToe(boolean[][] board) {
		if (board == null || board.length == 0)
			return;

		int m = board.length;
		int n = board[0].length;
		int red = 0, black = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j]) {
					if (i < m - 2 && board[i + 1][j] && board[i + 2][j])
						red++; // check vertical
					if (j < n - 2 && board[i][j + 1] && board[i][j + 2])
						red++; // check horizontal
					if (i < m - 2 && j < n - 2 && board[i + 1][j + 1]
							&& board[i + 2][j + 2])
						red++; // check diag
				} else {
					if (i < m - 2 && !board[i + 1][j] && !board[i + 2][j])
						black++; // check vertical
					if (j < n - 2 && !board[i][j + 1] && !board[i][j + 2])
						black++; // check horizontal
					if (i < m - 2 && j < n - 2 && !board[i + 1][j + 1]
							&& !board[i + 2][j + 2])
						black++; // check diag
				}
			}
		}

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (board[i][j]) {
					if (i >= 2 && j >= 2 && board[i - 1][j - 1]
							&& board[i - 2][j - 2])
						red++; // check reverse diag
				} else {
					if (i >= 2 && j >= 2 && !board[i - 1][j - 1]
							&& !board[i - 2][j - 2])
						black++; // check reverse diag
				}
			}
		}

		System.out.println("Red " + red);
		System.out.println("Black " + black);
		System.out.println();
	}

}
