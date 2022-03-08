import java.util.Scanner;

public class LascaController { 
	private int player = 0;
	private LascaBoard board; 
	private Scanner scnr = new Scanner (System.in);
	private TextViewController view;
	
	//Main duh....
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LascaController controller = new LascaController();
		controller.go();
	}

	//The High order Method
	private void go() {
		
		this.board = new LascaBoard();
		view = new TextViewController(board);

		
		boolean winner = false;
		while(winner == false) {
			view.displayBoard();
			if(board.checkHasMoves(board, player) == false) {
				winner = true;
				break;
			}
			queryPlayer();
			player = (player + 1) % 2;
			if (board.checkWinner()== true) {
				winner = true;
			}
		}
		scnr.close();
		if (board.checkHasMoves(board, player) == false){
			player = (player + 1) % 2;
			System.out.println("Player " + correctPlayer(player)  +" is the winner");
		}
		else if(board.checkWinner() == true) {
			System.out.println("Player " + correctPlayer(player) + " is the winner");
		}
	}
	

	
	//Allows me to Poll the Correct Player for System outs
	private int correctPlayer(int player) {
		return player + 1;
	}
	
	//Asks the Player what to do.  Then calls the desired Methods
	private void queryPlayer() {
		System.out.println("Player " + correctPlayer(player) + " what would you like to do?");
		System.out.println("1 Move");
		System.out.println("2 Concede");
		System.out.println("3 Look at a Locations stack");
		int playerChoice = scnr.nextInt();
		if (playerChoice == 1) {
			getPlayerPiece();
		}
		else if(playerChoice == 2) {
			playerConcession();
		}
		else if(playerChoice == 3) {
			playerPeek();
		}
		else {
			view.displayBoard();
			queryPlayer();
		}
		
	}
	
	//If a Player Gives Up
	private void playerConcession() {
		for(int i = 0; i < board.getHeight(); i++) {
			for(int j = 0; j < board.getWidth(); j++) {
				if (board.get(i, j) == null) {
					
				}
				else if (player == 0 && board.get(i, j) == 'R') {
					board.clearContents(i, j);
				}
				else if (player == 1 && board.get(i, j) == 'B') {
					board.clearContents(i, j);
				}
			}
		}
		System.out.println("Player "+ correctPlayer(player) +" has Conceded");
	}
	
	//Player Looks at a Stack of Pieces
	private void playerPeek() {
			System.out.println("Which location would you like to peek at enter row");
			int peekRow = scnr.nextInt();
			System.out.println("Which location would you like to peek at enter column");
			int peekCol = scnr.nextInt();
			if (board.get(peekRow, peekCol) == null) {
				System.out.println("Sorry That is not a Valid Space.");
				playerPeek();
			}
			else{
				System.out.println(board.showQueue(peekRow, peekCol));
				view.displayBoard();
				queryPlayer();
			}
	}
	
	//Ask the Player Which Piece They want to Move
	private void getPlayerPiece() {
		System.out.println("Player " + correctPlayer(player) + " please select the piece you want to move by typing the row.");
		int startPieceRow = scnr.nextInt();
		System.out.println("Player " + correctPlayer(player) + " please select the piece you want to move by typing the column.");
		int startPieceColumn = scnr.nextInt();
		boolean isPiece = checkAllowed(startPieceRow, startPieceColumn);
		if (isPiece == true) {
			requestMove(startPieceRow, startPieceColumn);
		}
		else if (isPiece == false) {
			System.out.println("Im sorry that is not your piece please try again.");
			getPlayerPiece();
		}
	}
	
	//Check to see if player is moving their own piece.
	private boolean checkAllowed(int row, int col) {
		if (board.get(row, col) == null) {
			System.out.println(" Im sorry this is not a valid Piece location");
			return false;
		}
		else if (board.get(row, col) == 'R' && player == 0) {
			return true;
		}
		else if (board.get(row, col) == 'B' && player == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Requests which direction the piece should be moved to.
	private void requestMove(int row, int col) {
		System.out.println("What Direction would you like to move?");
		System.out.println("These are Numpad Directions please end the number");
		System.out.println("(1) South West, (3) South East, (7) North East, (9) North East");
		System.out.println("Press -1 to go back");
		
		boolean validMove = false;
		int move;
		while(!validMove) {
			 move = scnr.nextInt();	
			if (move == 1 || move == 3 || move == 7 || move == 9) {
				validMove = true;
				boolean isValid = board.adjustMove(row, col, move);
				if (isValid == false) {
					System.out.println("Im Sorry that is not a valid move.");
					view.displayBoard();
					getPlayerPiece();
				}
			}
			else if (move == -1) {
				view.displayBoard();
				queryPlayer();
			}
			else {
				System.out.println("Im sorry that is not a valid move please try again.");
			}
		}
	}		
}


