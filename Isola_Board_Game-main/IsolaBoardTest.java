import static org.junit.Assert.*;

import org.junit.Test;

public class IsolaBoardTest {

	@Test
	public void testIsolaBoard() {
		//Setup
		IsolaBoard board = new IsolaBoard();
		//Method Execution
		int h = board.getHeight();
		int w = board.getWidth();
		//Verification
		if (h != 7 || w != 7)
		fail("The Board Initialized to " + h + " hight and " + w + " witdth when it should be 7");
	}

	@Test
	public void testIsolaBoardIntInt() {
		//Setup
		IsolaBoard board = new IsolaBoard(10, 10);
		//Method Execution
		int h = board.getHeight();
		int w = board.getHeight();
		//Verification
		if (h != 10 || w != 10) 
		fail("The Board Initialized to " + h + " hight and " + w + " witdth when it should be 10");
	}

	@Test
	public void testGetWidth() {
		//Setup
		IsolaBoard board = new IsolaBoard();
		//Method Execution
		int w = board.getWidth();
		//Verification
		if(w != 7)
		fail("Get width reported " + w + " instead of 7" );
	}

	@Test
	public void testGetHeight() {
		//Setup
		IsolaBoard board = new IsolaBoard(12, 12);
		//Method Execution
		int h = board.getHeight();
		//Verification
		if(h != 12)
		fail("Hieght reported " + h + " instead of 12");
	}

	@Test
	public void testGet() {
		//Setup
		IsolaBoard board = new IsolaBoard();
		//Method Execution
		BoardSpace what = board.get(0, 3);
		//Verification
		if(what != BoardSpace.Player1)
		fail("Checked for Player 1 and recieved " + what);
	}
	
	@Test
	public void testGet2() {
		//Setup
		IsolaBoard board = new IsolaBoard();
		//Method Execution
		BoardSpace what = board.get(6, 3);
		//Verification
		if(what != BoardSpace.Player2)
		fail("Checked for Player 2 and recieved " + what);
	}
	
	@Test
	public void testGet3() {
		//Setup
		IsolaBoard board = new IsolaBoard();
		//Method Execution
		BoardSpace what = board.get(0, 0);
		//Verification
		if(what != BoardSpace.Available)
		fail("Checked for Available and recieved " + what);
	}
	
	@Test
	public void testGet4() {
		//Setup
		IsolaBoard board = new IsolaBoard();
		//Method Execution
		BoardSpace what = board.get(-1, 3);
		//Verification
		if(what != null)
		fail("Checked for null and recieved " + what);
	}
	
	@Test
	public void testGet5() {
		//Setup
		IsolaBoard board = new IsolaBoard();
		//Method Execution
		BoardSpace what = board.get(1, -1);
		//Verification
		if(what != null)
		fail("Checked for null and recieved " + what);
	}
	
	@Test
	public void testGet6() {
		//Setup
		IsolaBoard board = new IsolaBoard();
		//Method Execution
		BoardSpace what = board.get(8, 3);
		//Verification
		if(what != null)
		fail("Checked for null and recieved " + what);
	}

	@Test
	public void testGet7() {
		//Setup
		IsolaBoard board = new IsolaBoard();
		//Method Execution
		BoardSpace what = board.get(2, 8);
		//Verification
		if(what != null)
		fail("Checked for null and recieved " + what);
	}
	
	
	
	@Test
	public void testFindPosition() {
		//Setup
		IsolaBoard board = new IsolaBoard();
		//Method Execution
		BoardPosition what = board.findPosition(BoardSpace.Player1);
		int r = what.getRow();
		int c = what.getColumn();
		//Verification
		if(r != 0 || c != 3)
		fail("Got The Wrong inputs for row and column");
	}

	
	@Test
	public void testMovePlayer() {
		//Setup
		IsolaBoard board = new IsolaBoard();
		int x = 0;
		int y = 1;
		BoardPosition newPosition = new BoardPosition(x,y);
		//Method Execution
		board.movePlayer(BoardSpace.Available, newPosition);
		BoardSpace what = board.get(x, y);
		//Verification
		if(what != BoardSpace.Available)
		fail("Moved Avialable to Available but not Available");
	}
	
	@Test
	public void testMovePlayer2() {
		//Setup
		IsolaBoard board = new IsolaBoard();
		int x = 0;
		int y = 1;
		BoardPosition newPosition = new BoardPosition(x,y);
		//Method Execution
		board.movePlayer(BoardSpace.Missing, newPosition);
		BoardSpace what = board.get(x, y);
		//Verification
		if(what != BoardSpace.Available)
		fail("Moved Missing to Available which shouldnt workbut got " + what);
	}
	
	@Test
	public void testMovePlayer3() {
		//Setup
		IsolaBoard board = new IsolaBoard();
		int x = 0;
		int y = 1;
		BoardPosition newPosition = new BoardPosition(x,y);
		//Method Execution
		board.movePlayer(BoardSpace.Player1, newPosition);
		BoardSpace what = board.get(x, y);
		//Verification
		if(what != BoardSpace.Available)
		fail("Moved Player1 to Position but got" + what);
	}
	
	@Test
	public void testMovePlayer4() {
		//Setup
		IsolaBoard board = new IsolaBoard();
		int x = 0;
		int y = 4;
		BoardPosition newPosition = new BoardPosition(x,y);
		//Method Execution
		board.movePlayer(BoardSpace.Player1, newPosition);
		BoardSpace what = board.get(x, y);
		//Verification
		if(what != BoardSpace.Player1)
		fail("Moved Player1 to Available but got " + what);
	}

	@Test
	public void testMovePlayer5() {
		//Setup
		IsolaBoard board = new IsolaBoard();
		int x = 6;
		int y = 4;
		BoardPosition newPosition = new BoardPosition(x,y);
		//Method Execution
		board.movePlayer(BoardSpace.Player2, newPosition);
		BoardSpace what = board.get(x, y);
		//Verification
		if(what != BoardSpace.Player2)
		fail("Moved Player2 to Available but got " + what);
	}
	
	@Test
	public void testMovePlayer6() {
		//Setup
		IsolaBoard board = new IsolaBoard();
		int x = -1;
		int y = -1;
		BoardPosition newPosition = new BoardPosition(x,y);
		//Method Execution
		board.movePlayer(BoardSpace.Player1, newPosition);
		BoardSpace what = board.get(x, y);
		//Verification
		if(what != null)
		fail("Moved Out of bounds when not possible");
	}
	
	@Test
	public void testMovePlayer7() {
		//Setup
		IsolaBoard board = new IsolaBoard();
		int x = 8;
		int y = 8;
		BoardPosition newPosition = new BoardPosition(x,y);
		//Method Execution
		board.movePlayer(BoardSpace.Player2, newPosition);
		BoardSpace what = board.get(x, y);
		//Verification
		if(what != null)
		fail("Moved out of bounds when not possible");
	}
	@Test
	public void testCheckWinner() {
		//Setup
		IsolaBoard board = new IsolaBoard();
		//Method Execution
		BoardSpace istherewinner = board.checkWinner();
		//Verification
		if(istherewinner != BoardSpace.Available)
		fail("The Game should still be playable but is not.");
	}

}
