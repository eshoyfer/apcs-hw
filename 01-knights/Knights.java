public class Knights {
	private int current = 0; 
	private boolean solved = false;
	private int[][] board = new int[5][5]; // 5x5 board

	public Knights() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				board[i][j] = 0;
			}
		}
	}

	private boolean isInvalid(int x, int y) {
		// inspects a position on the board, given by coordinate pair, and returns true if the position is an invalid spot for the knight (either due to being taken or out of bounds)
		try {
			boolean value = ((board[x][y] != 0) || (x > 4) || (x < 0) || (y > 4) || (y < 0));
		} catch (Exception e) {
			return true;
		}
		return ((board[x][y] != 0) || (x > 4) || (x < 0) || (y > 4) || (y < 0));
	}



	public void solve(int x, int y) { // x and y specify initial space coordinates on the board 
		if (isInvalid(x, y)) {
			System.out.println("Stepped on taken or invalid position. Reverting to position " + current);
			return;
		} else if (!isInvalid(x,y)) {
			current++; 
			board[x][y] = current;
			if (current == 25) {
				System.out.println("Success! Landed on 25.");
				return;
			}
			System.out.println("Stepped on open position. Labelling it " + current); 
			solve(x + 2, y + 1);
			if (!solved)
				solve(x + 2, y - 1);
			if (!solved)
				solve(x - 2, y + 1);
			if (!solved)
				solve(x - 2, y - 1);
			if (!solved)
				solve(x + 1, y + 2);
			if (!solved)
				solve(x + 1, y - 2);
			if (!solved)
				solve(x - 1, y + 2);
			if (!solved)
				solve(x - 1, y - 2);
		}
	}

	public String toString() {
		String boardString = ""; 
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				boardString += board[i][j] + " ";
			}
			boardString += "\n";
		}
		return boardString;
	}
}