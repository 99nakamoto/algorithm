package Question19_2;

import Question19_2.Question.Piece;

public class MyAnswer {

	public static Piece hasWon3(Piece[][] board) {

		int N = board.length;

		// O(2n+2) space to store count info
		int[] rowCnt = new int[N];
		int[] colCnt = new int[N];
		int[] digCnt = new int[2];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				int pieceValue = 0;
				if (board[i][j] == Piece.Blue) {
					pieceValue = 1;
				} else if (board[i][j] == Piece.Red) {
					pieceValue = -1;
				}

				// if empty, pieceValue is 0
				// if blue, add 1 in count
				// if red, subtract 1 in count
				rowCnt[i] += pieceValue;
				if (checkFinish(rowCnt[i], N) != null) {
					return checkFinish(rowCnt[i], N);
				}

				// after adding the count, check if the game finishes
				colCnt[j] += pieceValue;
				if (checkFinish(colCnt[j], N) != null) {
					return checkFinish(colCnt[j], N);
				}

				if (i == j) {
					digCnt[0] += pieceValue;
					if (checkFinish(digCnt[0], N) != null) {
						return checkFinish(digCnt[0], N);
					}
				} else if (i + j == N) {
					digCnt[1] += pieceValue;
					if (checkFinish(digCnt[1], N) != null) {
						return checkFinish(digCnt[1], N);
					}
				}
			}
		}
		// game not finished, continue
		return Piece.Empty;
	}

	private static Piece checkFinish(int count, int N) {
		if (count == N)
			return Piece.Blue;
		else if (count == -1 * N)
			return Piece.Red;
		else
			return null;
	}
}
