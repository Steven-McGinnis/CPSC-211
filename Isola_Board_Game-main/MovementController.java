
public class MovementController {

	/**
	 * Model That Manipulates and Calculates if a move is Valid and Returns it to the Controller
	 * @param board
	 * @param move
	 * @param who
	 * @return
	 */
	
	public BoardPosition checkplayermove(IsolaBoard board, String move, BoardSpace who)
	{
		//Create Necessary Constructors and Varaibles
		BoardPosition Position = board.findPosition(who);//Gets players position on the board
		int row = Position.getRow();//Pulls out the players row and assigns it for manipulation
		int column = Position.getColumn();//Pulls out the players column and assigns it for manipulation
		
		
		//Begin Cardinal Direction Testing
		if (move.equals("N")) {// North Cardinal Direction
			int rowtest = row - 1;
			if(rowtest == -1) {//Checks to See if Move Leaves Board
				System.out.println("This is not a valid move.");
				return null;//Returns to Loop To Restart Turn
			}
			row = row - 1;//Modify the Row to Return for new move
			BoardPosition newPosition = new BoardPosition(row, column);//Create the New Coordinates for a move
			if (board.get(row, column).toString().equals("Available")) {//Add A test to see if the position is available to move into
				return newPosition;//If Yes Return it as a safe move
			}
			else {
				System.out.println("This is not a valid move.");
				return null;//If not Return Null to Restart Loop
			}
		}
		
		
		else if (move.equals("NE")) {//North East Cardinal Direction
			int rowtest = row - 1;//Reduce Row to See if its Negative
			int columntest = column + 1;// Add Column to See if it Excedes Board Size
			if (rowtest == -1 || columntest > board.getWidth() - 1) {//Test Both Conditions
				System.out.println("This is not a valid move");
				return null;//Returns to Loop To Restart On Failure
			}
			row = row - 1;//Modify For Position Final
			column = column + 1;//Modify for Position Final

			BoardPosition newPosition = new BoardPosition(row, column);//Create the New Coordinates for a move
			if (board.get(row, column).toString().equals("Available")) {//Add a test to see if the position is available to move into
				return newPosition;//If Yes Return it as a safe move
			}
			else {
				System.out.println("This is not a valid move.");
				return null;//If Nor Return Null to Restart Loop
			}
		}
		
		
		else if (move.equals("NW")) {//North West Cardinal Direction
			int rowtest = row - 1;//Reduce Row to see if its negative
			int columntest = column -1;//Reduce Column to see if its negative
			if (rowtest == -1 || columntest == -1) {//Compare new cordinates and test
				System.out.println("This is not a valid move");
				return null;//Returs to Loop to Restart on Failure
			}
			row = row - 1;//Modify for Final Position
			column = column - 1;//Modify for Final Position
			
			BoardPosition newPosition = new BoardPosition(row, column);//Create the New Coordinates for a move
			if (board.get(row, column).toString().equals("Available")) {//Add a test to see if the position is available to move into
				return newPosition;//if yes return it as a safe move
			}
			else {
				System.out.println("This is not a valid move.");
				return null;// if not return null to restart loop
			}
		}
		
		
		else if (move.equals("E")) {//East Cardinal Direction
			int columntest = column + 1;//Incriment column to push bounds
			if (columntest > board.getWidth() -1 ) {//Check to see if the increase leaves board
				System.out.println("This is not a valid move");
				return null;//Restarts if yes
			}
			column = column + 1;//Creates for final position
			
			BoardPosition newPosition = new BoardPosition(row, column);//Create the New Coordinates for the move
			if (board.get(row, column).toString().equals("Available")) {//Test if spot is available to move into
				return newPosition;//If yes Return Move
			}
			else {
				System.out.println("This is not a valid move.");
				return null;//If Not Return Null
			}
		}
		
		
		else if (move.equals("SE")) {//South East Cardinal Direction
			int columntest = column + 1;//Incriment to test
			int rowtest = row + 1;//Incriment to test
			
			if (columntest > board.getWidth() - 1 || rowtest > board.getHeight() - 1) {//Test to See if its out of the Board
				System.out.println("This is not a valid move");
				return null;//Restart if it is
			}
			
			column = column + 1;//Incriment for move
			row = row + 1;//Incriment for move
			
			BoardPosition newPosition = new BoardPosition(row, column);//New Move
			if (board.get(row, column).toString().equals("Available")) {//Check if Available
				return newPosition;//Return if Safe
			}
			else {
				System.out.println("This is not a valid move.");
				return null;//Restart if not
			}
		}
		
		
		
		else if (move.equals("S")) {//South Cardinal Direction
			int rowtest = row  + 1;
			if (rowtest > board.getHeight() -1) {
				System.out.println("This is not a valid move");
				return null;
			}
			
			
			row = row + 1;
			BoardPosition newPosition = new BoardPosition(row, column);
			if (board.get(row, column).toString().equals("Available")) {
				return newPosition;
			}
			else {
				System.out.println("This is not a valid move.");
				return null;
			}
		}
		
		
		else if (move.equals("SW")) {
			int rowtest = row + 1;
			int columntest = column -1;
			if (rowtest > board.getHeight() - 1 || columntest == -1) {
				System.out.println("This is not a valid move.");
				return null;
			}
			
			row = row + 1;
			column = column - 1;
			
			BoardPosition newPosition = new BoardPosition(row, column);
			if (board.get(row, column).toString().equals("Available")) {
				return newPosition;
			}
			else {
				System.out.println("This is not a valid move.");
				return null;
			}
		}
		
		
		else if(move.equals("W")) {
			int columntest = column - 1;
			if (columntest == -1) {
				System.out.println("This is not a valid move.");
				return null;
			}
			column = column - 1;
			BoardPosition newPosition = new BoardPosition(row, column);
			if (board.get(row, column).toString().equals("Available")) {
				return newPosition;
			}
			else {
				System.out.println("This is not a valid move.");
				return null;
			}
		}
		return null;
	}
	
	
	public BoardSpace who(int index) {
		if (index == 0) {
			return BoardSpace.Player1;
		}
		else {
			return BoardSpace.Player2;
		}
	}
	
	public Boolean checkwinner(BoardSpace isThereWinner) {
		if (isThereWinner.equals(BoardSpace.Available)){//Handles CheckWinner Output
			//continues game
		}
		else if (isThereWinner.equals(BoardSpace.Player1)) {//Handles Winner Player 1
			System.out.println("Player 1 Wins");
			return true;//Changes Boolean for game over loop
		}
		else if (isThereWinner.equals(BoardSpace.Player2)) {//Handles Winner Player 2
			System.out.println("Player 2 Wins");
			return true;//Changes Boolean for game over loop
			//Displays Final Board
		}
		return false;
	}
}
