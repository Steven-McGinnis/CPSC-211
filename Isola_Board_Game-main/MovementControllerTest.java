import static org.junit.Assert.*;

import org.junit.Test;

public class MovementControllerTest {

	@Test
	public void testCheckplayermoveNE() {//Checks Moving off the top of the board
		//Setup
		IsolaBoard board = new IsolaBoard();
		MovementController move = new MovementController();
		//Method Execution
		BoardPosition thismove = move.checkplayermove(board, "NE", BoardSpace.Player1);
		//Verification
		if (thismove != null)
		fail("North East move off board did not report null it reported" + thismove);	
	}
	
	@Test
	public void testCheckplayermoveNE2() {//Checks moving into a available space
		//Setup
		IsolaBoard board = new IsolaBoard();
		MovementController move = new MovementController();
		int moverow = 1;
		int movecolumn = 4;
		BoardPosition newmove = new BoardPosition(moverow, movecolumn);
		board.movePlayer(BoardSpace.Player1, newmove);
		//Method Execution
		BoardPosition thismove = move.checkplayermove(board, "NE", BoardSpace.Player1);
		int currentcolumn = 5;
		int currentrow = 0;
		int checkrow = thismove.getRow();
		int checkcolumn = thismove.getColumn();
		//Verification
		if(currentcolumn != checkcolumn && checkrow != currentrow)
			fail("North East move after moving down 1 did not report correctly");
	}

	@Test
	public void testCheckplayermoveNE3() { //Checks moving off the side of the board
		//Setup
		IsolaBoard board = new IsolaBoard();
		MovementController move = new MovementController();
		int firstrow = 1;
		int firstcolumn = 4;
		BoardPosition position1 = new BoardPosition(firstrow, firstcolumn);
		board.movePlayer(BoardSpace.Player1, position1);
		int secondrow = 1;
		int secondcolumn = 5;
		BoardPosition position2 = new BoardPosition(secondrow, secondcolumn);
		board.movePlayer(BoardSpace.Player1, position2);
		int thirdrow = 1;
		int thirdcolumn = 6;
		BoardPosition position3 = new BoardPosition(thirdrow, thirdcolumn);
		board.movePlayer(BoardSpace.Player1, position3);
		//Method Execution
		BoardPosition thismove = move.checkplayermove(board, "NE", BoardSpace.Player1);
		//Verification
		if(thismove != null)
			fail("North East after moving off the board horizontally did not report correctly");
	}
	
	@Test
	public void testCheckplayermoveNE4() { //Checks moving into an unavailable space
		//Setup
		IsolaBoard board = new IsolaBoard();
		MovementController move = new MovementController();
		int firstrow = 1;
		int firstcolumn = 2;
		BoardPosition position1 = new BoardPosition(firstrow, firstcolumn);
		board.movePlayer(BoardSpace.Player1, position1);
		int secondrow = 0;
		int secondcolumn = 3;
		BoardPosition position2 = new BoardPosition(secondrow, secondcolumn);
		board.movePlayer(BoardSpace.Player1, position2);
		//Method Execution
		BoardPosition thismove = move.checkplayermove(board, "NE", BoardSpace.Player1);
		//Verification
		if(thismove != null)
			fail("North East did not report correctly when trying to move into a unavailable space");
	}
	
	@Test
	public void testCheckplayermoveN() { //Checks Moving off the top of the board
		//Setup
		IsolaBoard board = new IsolaBoard();
		MovementController move = new MovementController();
		//Method Execution
		BoardPosition thismove = move.checkplayermove(board, "N", BoardSpace.Player1);
		//Verification
		if (thismove != null)
		fail("North move did not report null it reported" + thismove);	
	}
	
	@Test
	public void testCheckplayermoveN2() { //Checks moving into an unavailable space
		//Setup
		IsolaBoard board = new IsolaBoard();
		MovementController move = new MovementController();
		int moverow = 1;
		int movecolumn = 3;
		BoardPosition newmove = new BoardPosition(moverow, movecolumn);
		board.movePlayer(BoardSpace.Player1, newmove);
		//Method Execution
		BoardPosition thismove = move.checkplayermove(board, "N", BoardSpace.Player1);
		//Verification
		if(thismove != null)
			fail("Move North after ");
	}
	
	@Test
	public void testCheckplayermoveN3() {//Checks Moving into an available space
		//Setup
		IsolaBoard board = new IsolaBoard();
		MovementController move = new MovementController();
		int moverow = 1;
		int movecolumn = 4;
		BoardPosition newmove = new BoardPosition(moverow, movecolumn);
		board.movePlayer(BoardSpace.Player1, newmove);
		//Method Execution
		BoardPosition thismove = move.checkplayermove(board, "N", BoardSpace.Player1);
		int currentcolumn = 4;
		int currentrow = 0;
		int checkrow = thismove.getRow();
		int checkcolumn = thismove.getColumn();
		//Verification
		if(currentcolumn != checkcolumn && checkrow != currentrow)
			fail("NE after moving did not report correctly");
	}
	
	@Test
	public void testCheckplayermoveNW() { //Checks Moving off the top of the board
		//Setup
		IsolaBoard board = new IsolaBoard();
		MovementController move = new MovementController();
		//Method Execution
		BoardPosition thismove = move.checkplayermove(board, "NW", BoardSpace.Player1);
		//Verification
		if (thismove != null)
		fail("North West move did not report null it reported" + thismove);	
	}
	
	@Test
	public void testCheckplayermoveNW2() {//Checks Moving into an available space
		//Setup
		IsolaBoard board = new IsolaBoard();
		MovementController move = new MovementController();
		int moverow = 1;
		int movecolumn = 3;
		BoardPosition newmove = new BoardPosition(moverow, movecolumn);
		board.movePlayer(BoardSpace.Player1, newmove);
		//Method Execution
		BoardPosition thismove = move.checkplayermove(board, "NW", BoardSpace.Player1);
		int currentcolumn = 2;
		int currentrow = 0;
		int checkrow = thismove.getRow();
		int checkcolumn = thismove.getColumn();
		//Verification
		if(currentcolumn != checkcolumn && checkrow != currentrow)
			fail("NW after moving did not report correctly");
	}
	
	@Test
	public void testCheckplayermoveNW3() { //Checks moving off the side of the board
		//Setup
		IsolaBoard board = new IsolaBoard();
		MovementController move = new MovementController();
		int firstrow = 1;
		int firstcolumn = 2;
		BoardPosition position1 = new BoardPosition(firstrow, firstcolumn);
		board.movePlayer(BoardSpace.Player1, position1);
		int secondrow = 1;
		int secondcolumn = 1;
		BoardPosition position2 = new BoardPosition(secondrow, secondcolumn);
		board.movePlayer(BoardSpace.Player1, position2);
		int thirdrow = 1;
		int thirdcolumn = 0;
		BoardPosition position3 = new BoardPosition(thirdrow, thirdcolumn);
		board.movePlayer(BoardSpace.Player1, position3);
		//Method Execution
		BoardPosition thismove = move.checkplayermove(board, "NW", BoardSpace.Player1);
		//Verification
		if(thismove != null)
			fail("North West after moving off the board horizontally did not report correctly");
	}
	
	@Test
	public void testCheckplayermoveNW4() { //Checks moving into an unavailable space
		//Setup
		IsolaBoard board = new IsolaBoard();
		MovementController move = new MovementController();
		int firstrow = 1;
		int firstcolumn = 4;
		BoardPosition position1 = new BoardPosition(firstrow, firstcolumn);
		board.movePlayer(BoardSpace.Player1, position1);
		int secondrow = 0;
		int secondcolumn = 3;
		BoardPosition position2 = new BoardPosition(secondrow, secondcolumn);
		board.movePlayer(BoardSpace.Player1, position2);
		//Method Execution
		BoardPosition thismove = move.checkplayermove(board, "NW", BoardSpace.Player1);
		//Verification
		if(thismove != null)
			fail("North West did not report correctly when trying to move into a unavailable space");
	}
	
	@Test
	public void testCheckplayermoveE() {//Checks Moving into a Available Space
		//Setup
		IsolaBoard board = new IsolaBoard();
		MovementController move = new MovementController();
		int row = 0;
		int column = 4;
		BoardPosition checkthismove = new BoardPosition(row, column);
		//Method Execution
		BoardPosition thismove = move.checkplayermove(board, "E", BoardSpace.Player1);
		//Verification
		int x = thismove.getColumn();
		int y = thismove.getRow();
		if (x != column && y != row)
		fail("Thismove reported " + thismove + "while checkthismove reported " + checkthismove);	
	}
	
	@Test
	public void testCheckplayermoveE2() { //Checks moving off the side of the board
		//Setup
		IsolaBoard board = new IsolaBoard();
		MovementController move = new MovementController();
		int firstrow = 0;
		int firstcolumn = 4;
		BoardPosition position1 = new BoardPosition(firstrow, firstcolumn);
		board.movePlayer(BoardSpace.Player1, position1);
		int secondrow = 0;
		int secondcolumn = 5;
		BoardPosition position2 = new BoardPosition(secondrow, secondcolumn);
		board.movePlayer(BoardSpace.Player1, position2);
		int thirdrow = 0;
		int thirdcolumn = 6;
		BoardPosition position3 = new BoardPosition(thirdrow, thirdcolumn);
		board.movePlayer(BoardSpace.Player1, position3);
		//Method Execution
		BoardPosition thismove = move.checkplayermove(board, "E", BoardSpace.Player1);
		//Verification
		if(thismove != null)
			fail("East after moving off the board horizontally did not report correctly");
	}
	
	@Test
	public void testCheckplayermoveE3() { //Checks moving into a unavailable space
		//Setup
		IsolaBoard board = new IsolaBoard();
		MovementController move = new MovementController();
		int firstrow = 0;
		int firstcolumn = 2;
		BoardPosition position1 = new BoardPosition(firstrow, firstcolumn);
		board.movePlayer(BoardSpace.Player1, position1);
		//Method Execution
		BoardPosition thismove = move.checkplayermove(board, "E", BoardSpace.Player1);
		//Verification
		if(thismove != null)
			fail("Moving into an unavailable space");
	}
	
	@Test
	public void testCheckplayermoveSE() {//Checks Moving into an Available Space
		//Setup
		IsolaBoard board = new IsolaBoard();
		MovementController move = new MovementController();
		int rowcheck = 1;
		int columncheck = 4;
		//Method Execution
		BoardPosition thismove = move.checkplayermove(board, "SE", BoardSpace.Player1);
		//Verification
		int currentrow = thismove.getRow();
		int curentcolumn = thismove.getColumn();
		
		
		if (currentrow != rowcheck && curentcolumn != columncheck)
		fail("Moving South East into a available space failed to work");	
	}
	
	@Test
	public void testCheckplayermoveSE2() { //Checks moving off the bottom of the board
		//Setup
		IsolaBoard board = new IsolaBoard();
		MovementController move = new MovementController();
		//Method Execution
		BoardPosition thismove = move.checkplayermove(board, "SE", BoardSpace.Player2);
		//Verification
		if(thismove != null)
			fail("South East after moving off the board from the bottom did not report correctly");
	}
	
	@Test
	public void testCheckplayermoveSE3() { //Checks moving off the side of the board
		//Setup
		IsolaBoard board = new IsolaBoard();
		MovementController move = new MovementController();
		int firstrow = 6;
		int firstcolumn = 4;
		BoardPosition position1 = new BoardPosition(firstrow, firstcolumn);
		board.movePlayer(BoardSpace.Player2, position1);
		int secondrow = 6;
		int secondcolumn = 5;
		BoardPosition position2 = new BoardPosition(secondrow, secondcolumn);
		board.movePlayer(BoardSpace.Player2, position2);
		int thirdrow = 5;
		int thirdcolumn = 6;
		BoardPosition position3 = new BoardPosition(thirdrow, thirdcolumn);
		board.movePlayer(BoardSpace.Player2, position3);
		//Method Execution
		BoardPosition thismove = move.checkplayermove(board, "SE", BoardSpace.Player2);
		//Verification
		if(thismove != null)
			fail("South East after moving off the board horizontally did not report correctly");
	}
	
	@Test
	public void testCheckplayermoveSE4() { //Checks moving into an unavailable space
		//Setup
		IsolaBoard board = new IsolaBoard();
		MovementController move = new MovementController();
		int firstrow = 5;
		int firstcolumn = 2;
		BoardPosition position1 = new BoardPosition(firstrow, firstcolumn);
		board.movePlayer(BoardSpace.Player2, position1);
		//Method Execution
		BoardPosition thismove = move.checkplayermove(board, "SE", BoardSpace.Player2);
		//Verification
		if(thismove != null)
			fail("South East after moving off the board horizontally did not report correctly");
	}
	
	@Test
	public void testCheckplayermoveS() {//Checks Moving into an Available Space
		//Setup
		IsolaBoard board = new IsolaBoard();
		MovementController move = new MovementController();
		int rowcheck = 1;
		int columncheck = 3;
		//Method Execution
		BoardPosition thismove = move.checkplayermove(board, "S", BoardSpace.Player1);
		int currentrow = thismove.getRow();
		int currentcolumn = thismove.getColumn();
		//Verification
		if (rowcheck != currentrow && columncheck != currentcolumn)
		fail("The South coordinate is not reporting the currect position");	
	}
	
	@Test
	public void testCheckplayermoveS2() {//Checks Moving off the Board
		//Setup
		IsolaBoard board = new IsolaBoard();
		MovementController move = new MovementController();
		//Method Execution
		BoardPosition thismove = move.checkplayermove(board, "S", BoardSpace.Player2);
		//Verification
		if (thismove != null)
		fail("Moved off the board to the south");	
	}
	
	@Test
	public void testCheckplayermoveS3() {//Checks Moving into an Unavailable Space
		//Setup
		IsolaBoard board = new IsolaBoard();
		MovementController move = new MovementController();
		int firstrow = 5;
		int firstcolumn = 3;
		BoardPosition newmove = new BoardPosition(firstrow, firstcolumn);
		board.movePlayer(BoardSpace.Player2, newmove);
		//Method Execution
		BoardPosition thismove = move.checkplayermove(board, "S", BoardSpace.Player2);
		//Verification
		if (thismove != null)
		fail("Moved South into an unavailable space");	
	}
	
	@Test
	public void testCheckplayermoveSW() {//Checks Moving into an Available Space
		//Setup
		IsolaBoard board = new IsolaBoard();
		MovementController move = new MovementController();
		int rowcheck = 1;
		int columncheck = 2;
		//Method Execution
		BoardPosition thismove = move.checkplayermove(board, "SW", BoardSpace.Player1);
		int currentrow = thismove.getRow();
		int currentcolumn = thismove.getColumn();
		//Verification
		if (rowcheck != currentrow && columncheck != currentcolumn)
		fail("The South West coordinate is not reporting the correct position");	
	}
	
	@Test
	public void testCheckplayermoveSW2() { //Checks moving off the bottom of the board
		//Setup
		IsolaBoard board = new IsolaBoard();
		MovementController move = new MovementController();
		//Method Execution
		BoardPosition thismove = move.checkplayermove(board, "SW", BoardSpace.Player2);
		//Verification
		if(thismove != null)
			fail("South East after moving off the board from the bottom did not report correctly");
	}
	
	@Test
	public void testCheckplayermoveSW3() { //Checks moving off the side of the board
		//Setup
		IsolaBoard board = new IsolaBoard();
		MovementController move = new MovementController();
		int firstrow = 6;
		int firstcolumn = 2;
		BoardPosition position1 = new BoardPosition(firstrow, firstcolumn);
		board.movePlayer(BoardSpace.Player2, position1);
		int secondrow = 6;
		int secondcolumn = 1;
		BoardPosition position2 = new BoardPosition(secondrow, secondcolumn);
		board.movePlayer(BoardSpace.Player2, position2);
		int thirdrow = 5;
		int thirdcolumn = 0;
		BoardPosition position3 = new BoardPosition(thirdrow, thirdcolumn);
		board.movePlayer(BoardSpace.Player2, position3);
		//Method Execution
		BoardPosition thismove = move.checkplayermove(board, "SE", BoardSpace.Player2);
		//Verification
		if(thismove != null)
			fail("South West after moving off the board horizontally did not report correctly");
	}
	
	@Test
	public void testCheckplayermoveSW4() { //Checks moving into an unavailable space
		//Setup
		IsolaBoard board = new IsolaBoard();
		MovementController move = new MovementController();
		int firstrow = 5;
		int firstcolumn = 4;
		BoardPosition position1 = new BoardPosition(firstrow, firstcolumn);
		board.movePlayer(BoardSpace.Player2, position1);
		//Method Execution
		BoardPosition thismove = move.checkplayermove(board, "SW", BoardSpace.Player2);
		//Verification
		if(thismove != null)
			fail("Moved into and Unavailable space");
	}
	
	@Test
	public void testCheckplayermoveW() {//Checks moving into an Available Space
		//Setup
		IsolaBoard board = new IsolaBoard();
		MovementController move = new MovementController();
		int rowcheck = 0;
		int columncheck= 2;
		//Method Execution
		BoardPosition thismove = move.checkplayermove(board, "W", BoardSpace.Player1);
		int currentrow = thismove.getRow();
		int currentcolumn = thismove.getColumn();
		//Verification
		if (rowcheck != currentrow && columncheck != currentcolumn)
		fail("The West Coordinate is not reporting the correct position");	
	}

	@Test
	public void testCheckplayermoveW2() { //Checks moving off the side of the board
		//Setup
		IsolaBoard board = new IsolaBoard();
		MovementController move = new MovementController();
		int firstrow = 0;
		int firstcolumn = 2;
		BoardPosition position1 = new BoardPosition(firstrow, firstcolumn);
		board.movePlayer(BoardSpace.Player1, position1);
		int secondrow = 0;
		int secondcolumn = 1;
		BoardPosition position2 = new BoardPosition(secondrow, secondcolumn);
		board.movePlayer(BoardSpace.Player1, position2);
		int thirdrow = 0;
		int thirdcolumn = 0;
		BoardPosition position3 = new BoardPosition(thirdrow, thirdcolumn);
		board.movePlayer(BoardSpace.Player1, position3);
		//Method Execution
		BoardPosition thismove = move.checkplayermove(board, "W", BoardSpace.Player1);
		//Verification
		if(thismove != null)
			fail("West after moving off the board horizontally did not report correctly");
	}
	
	@Test
	public void testCheckplayermoveW3() { //Checks moving off the side of the board
		//Setup
		IsolaBoard board = new IsolaBoard();
		MovementController move = new MovementController();
		int firstrow = 0;
		int firstcolumn = 4;
		BoardPosition position1 = new BoardPosition(firstrow, firstcolumn);
		board.movePlayer(BoardSpace.Player1, position1);
		//Method Execution
		BoardPosition thismove = move.checkplayermove(board, "W", BoardSpace.Player1);
		//Verification
		if(thismove != null)
			fail("Moved west into an unavailable space");
	}
	
	@Test
	public void testWho() {
		//Setup
		MovementController move = new MovementController();
		int index = 0;
		//Method Execution
		BoardSpace who = move.who(index);
		//Verification
		if(who != BoardSpace.Player1)
		fail("Did not report it was Player Ones Turn");
	}
	
	@Test
	public void testWho2() {
		//Setup
		MovementController move = new MovementController();
		int index = 1;
		//Method Execution
		BoardSpace who = move.who(index);
		//Verification
		if(who != BoardSpace.Player2)
		fail("Did not report it was Player Twos Turn");
	}

	@Test
	public void testCheckwinner() {
		//Setup
		MovementController move = new MovementController();
		IsolaBoard board = new IsolaBoard();
		//Method Execution
		BoardSpace isThereWinner = board.checkWinner();
		Boolean test = move.checkwinner(isThereWinner);
		//Verification
		if(test != false)
		fail("CheckWinner did not report Available False");
	}

}
