import java.util.LinkedList;
import java.util.Queue;

public class LascaBoard {
	// Private Variable for Board
	private Queue<Character>[][] board;

	// Public board Constructor
	public LascaBoard() {
		createBoard(7, 7);
	}

	// Method Overload LascaBoard Size
	public LascaBoard(int height, int width) {
		createBoard(height, width);
	}

	// Peeks at the front of the Queue
	public Character get(int row, int column) {
		if (row < 0 || row >= board.length || column < 0 || column >= board[0].length)
			return null;
		return board[row][column].peek();
	}

	// Gets the Width of the Board
	public int getWidth() {
		return board[0].length;
	}

	// Gets the Height of the Board
	public int getHeight() {
		return board.length;
	}

	// Shows the Stack that The player is interested in looking at
	public String showQueue(int row, int column) {
		LinkedList<Character> peekQueue = new LinkedList<Character>(board[row][column]);
		String q = peekQueue.toString();
		return q;
	}

	// Adds a single Character to the Queue
	public void set(int row, int column, char newcharacter) {
		board[row][column].add(newcharacter);
	}

	// Empty Spaces for Concession
	public void clearContents(int row, int column) {
		board[row][column].clear();
	}

	// Scans the Board For Missing Player Pieces
	public boolean checkWinner() {
		boolean hasRed = false;
		boolean hasBlack = false;
		for (int i = 0; i < getWidth(); i++) {
			for (int j = 0; j < getHeight(); j++) {
				if (get(i, j) == null) {

				} else if (get(i, j) == 'R') {
					hasRed = true;
				} else if (get(i, j) == 'B') {
					hasBlack = true;
				}
			}
		}
		if (hasRed == true && hasBlack == true) {
			return false;
		} else {
			return true;
		}
	}

	public boolean move(int row, int column, int nextrow, int nextcol, int jumprow, int jumpcol) {
		// Check If the Move is on the Board
		if (nextrow >= getHeight() || nextrow < 0 || nextcol < 0 || nextcol >= getWidth()) {
			return false;
		}
		// Check if the Piece is a Players Piece
		else if (board[nextrow][nextcol].peek() == board[row][column].peek()) {
			return false;
		}
		// Check if the Space is Available
		else if (board[nextrow][nextcol].isEmpty() == true) {
			emptyQueueTransfer(row, column, nextrow, nextcol);
			return true;
		}
		// Check if the Player is Jumping Another Player
		else if (board[nextrow][nextcol].peek() != board[row][column].peek()) {
			// Check if The Jump Goes off the Board
			if (jumprow >= getHeight() || jumprow < 0 || jumpcol < 0 || jumpcol >= getWidth()) {
				return false;
			}
			// Check if the Space Jumping to Is Available to Jump Into
			else if (board[jumprow][jumpcol].isEmpty()) {
				// DO MANIPULATION
				emptyQueueTransfer(row, column, jumprow, jumpcol);
				char transfer = board[nextrow][nextcol].poll();
				set(jumprow, jumpcol, transfer);
				return true;
			} else if (board[jumprow][jumpcol].peek() == 'R' || board[jumprow][jumpcol].peek() == 'B') {
				return false;
			}
		}
		return false;
	}

	// Adjust the Move Values based on User Choice
	public boolean adjustMove(int row1, int col1, int move) {
		int row = row1;
		int col = col1;
		if (move == 1) {
			int nextrow = row + 1;
			int nextcol = col - 1;
			int jumprow = row + 2;
			int jumpcol = col - 2;
			boolean result = move(row, col, nextrow, nextcol, jumprow, jumpcol);
			return result;
		} else if (move == 3) {
			int nextrow = row + 1;
			int nextcol = col + 1;
			int jumprow = row + 2;
			int jumpcol = col + 2;
			boolean result = move(row, col, nextrow, nextcol, jumprow, jumpcol);
			return result;
		} else if (move == 7) {
			int nextrow = row - 1;
			int nextcol = col - 1;
			int jumprow = row - 2;
			int jumpcol = col - 2;
			boolean result = move(row, col, nextrow, nextcol, jumprow, jumpcol);
			return result;
		} else if (move == 9) {
			int nextrow = row - 1;
			int nextcol = col + 1;
			int jumprow = row - 2;
			int jumpcol = col + 2;
			boolean result = move(row, col, nextrow, nextcol, jumprow, jumpcol);
			return result;
		}
		return false;
	}

	// Takes a Queue and Moves it to the new Empty Location
	public void emptyQueueTransfer(int startrow, int startcol, int endrow, int endcol) {
		while (!board[startrow][startcol].isEmpty()) {
			char transfer = board[startrow][startcol].poll();
			board[endrow][endcol].add(transfer);
		}
	}

	// Creates Board and calls Piece Placement
	@SuppressWarnings("unchecked")
	private void createBoard(int height, int width) {
		// TODO Auto-generated method stub
		board = new Queue[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				board[i][j] = new LinkedList<Character>();
				// board[i][j].add('-');
			}
		}
		setRed();
		setBlack();
	}

	// Sets Red Pieces on Board
	private void setRed() {
		for (int i = 0; i < 3; i = i + 2) {
			for (int j = 0; j < board.length; j = j + 2) {
				// board[i][j].remove();
				board[i][j].add('R');
			}
		}
		for (int l = 1; l < board.length; l = l + 2) {
			// board[1][l].remove();
			board[1][l].add('R');
		}
	}

	// Sets Black Pieces on Board
	private void setBlack() {
		for (int i = (getHeight() - 3); i < getHeight(); i = i + 2) {
			for (int j = 0; j < board.length; j = j + 2) {
				// board[i][j].remove();
				board[i][j].add('B');
			}
		}
		for (int l = 1; l < board.length; l = l + 2) {
			int secondLastRow = (getHeight() - 2);
			// board[secondLastRow][l].remove();
			board[secondLastRow][l].add('B');
		}
	}

	
	/*
	 * This method is absolutely ugly
	 * I would prefer to optimize it and shrink it down however I simply have to many other projects to worry about
	 * So while It copies itself and should be split into other methods It does work
	 *  
	 */
	public boolean checkHasMoves(LascaBoard board2, int player) {
		// TODO Auto-generated method stub
		int currentPlayer = player;
		char target = ' ';
		char other = ' ';
		if (currentPlayer == 0) {
			target = 'R';
			other = 'B';
		} else if (currentPlayer == 1) {
			target = 'B';
			other = 'R';
		}

		for (int i = 0; i < getHeight(); i++) {
			for (int j = 0; j < getWidth(); j++) {

				// Up Left 7
				if (board[i][j].isEmpty()) {

				} else if (board[i][j].peek() == target) {// Is a Player Piece
					if ((i - 1) < 0 || (j - 1) < 0 || i > (getHeight() - 1) || j > (getWidth() - 1)) { 

					} else if (board[i - 1][j - 1].isEmpty()) {// Is the Top Left from Piece Empty space
						return true;
					} else if (board[i - 1][j - 1].peek() == target) {// Is Top Left your Piece

					} else if (board[i - 1][j - 1].peek() == other) {// If its a black piece what next
						if ((i - 2) < 0 || (j - 2) < 0) {// Does jumping go off the board

						} else if (board[i - 2][j - 2].isEmpty()) {// Does Jumping go into an empty space
							return true;
						} else if (board[i - 2][j - 2].peek() == target || board[i - 2][j - 2].peek() == other) {

						}
					}
				}

				// Up Right 9
				if (board[i][j].isEmpty()) {

				} else if (board[i][j].peek() == target) {// Is a Player Piece
					if ((i - 1) < 0 || (j + 1) > (getWidth() - 1)) { // Is the from Piece a non space

					} else if (board[i - 1][j + 1].isEmpty()) {// Is the from Piece Empty space
						return true;
					} else if (board[i - 1][j + 1].peek() == target) {// Is your Piece

					} else if (board[i - 1][j + 1].peek() == other) {// If its a black piece what next
						if ((i - 2) < 0 || (j + 2) > (getWidth() - 1)) {// Does jumping go off the board

						} else if (board[i - 2][j + 2].isEmpty()) {// Does Jumping go into an empty space
							return true;
						} else if (board[i - 2][j + 2].peek() == target || board[i - 2][j + 2].peek() == other) {

						}
					}
				}

				// Down Left 1
				if (board[i][j].isEmpty()) {

				} else if (board[i][j].peek() == target) {
					if ((i + 1) > (getHeight() - 1) || (j - 1) < 0) { 

					} else if (board[i + 1][j - 1].isEmpty()) {
						return true;
					} else if (board[i + 1][j - 1].peek() == target) {

					} else if (board[i + 1][j - 1].peek() == other) {
						if ((i + 2) > (getHeight() - 1) || (j - 2) < 0) {

						} else if (board[i + 2][j - 2].isEmpty()) {
							return true;
						} else if (board[i + 2][j - 2].peek() == target || board[i + 2][j - 2].peek() == other) {

						}
					}
				}

				// Down Right 3
				if (board[i][j].isEmpty()) {

				} else if (board[i][j].peek() == target) {// Is a Player Piece
					if ((i + 1) > (getHeight() - 1) || (j + 1) > (getWidth() - 1)) { 

					} else if (board[i + 1][j + 1].isEmpty()) {// Is the Down Right from Piece Empty space
						return true;
					} else if (board[i + 1][j + 1].peek() == target) {// Is Down Right your Piece

					} else if (board[i + 1][j + 1].peek() == other) {// If its a black piece what next
						if ((i + 2) > (getHeight() - 1) || (j + 2) > (getWidth() - 1)) {// Does jumping go off the board

						} else if (board[i + 2][j + 2].isEmpty()) {// Does Jumping go into an empty space
							return true;
						} else if (board[i + 2][j + 2].peek() == target || board[i + 2][j + 2].peek() == other) {

						}
					}
				}
			}
		}
		return false;
	}
}