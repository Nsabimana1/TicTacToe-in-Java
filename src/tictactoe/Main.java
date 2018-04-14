package tictactoe;

public class Main{

	public boolean GoalReached(Tictac value, Board board ) {
		for(int i = 0; i < 3; i ++) {
			for (int j = 0; j < 3; j ++) {
				/// check diagonals
				if(i == 0 && j == 0) {
					if(board.get(i, j) == value && board.get(i + 1, j + 1) == value  && board.get(i + 2, j + 2) == value) {
						return true;
					}
				}

				if(i == 2 && j == 2) {
					if(board.get(i, j - 2) == value && board.get(i - 1, j - 1) == value  && board.get(i - 2, j) == value) {
						return true;
					}
				}

				/// check horizontal lines
				if(j == 0) {
					if(board.get(i, j) == value && board.get(i, j+1) == value  && board.get(i, j + 2) == value) {
						return true;
					}
				}
				/// check vertical lines
				if (i == 0) {
					if(board.get(i, j) == value && board.get(i + 1, j) == value  && board.get(i + 2, j) == value) {
						return true;
					}
				}

			}
		}
		return false;
	}

	public boolean BoardIsfull(Board board) {
		for(int i = 0; i < 3; i ++) {
			for (int j = 0; j < 3; j ++) {
				if(board.get(i, j) == null) {
					return false;
				}

			}
		}
		return true;
	}
}
