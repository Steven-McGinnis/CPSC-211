import static org.junit.Assert.*;

import org.junit.Test;

public class LascaBoardTest {

	@Test
	public void testLascaBoard() {
		//Setup
		LascaBoard board = new LascaBoard();
		//Verification
		if (board.getHeight() != 7 && board.getWidth() != 7)
		fail("Board Initialization should be 7, 7 but got " + board.getHeight() + " " + board.getWidth());
	}

	@Test
	public void testLascaBoard2() {
		//Setup
		LascaBoard board = new LascaBoard(20, 25);
		//Method Execution
		//Verification
		if (board.getHeight() != 20 && board.getWidth() != 25)
		fail("Board Initialization should be 20, 25 but got " + board.getHeight() + " , " + board.getWidth());
	}
	
	@Test
	public void testGet() {
		//Setup
		LascaBoard board = new LascaBoard();
		//Method Execution
		boolean test2 = board.get(-1, 0) != null;
		char test = board.get(0, 0);
		char test3 = board.get((board.getHeight() - 3), 0);
		
		//Verification
		if(test != 'R')
		fail("Test Case 1 Should have been R but got " + test);
		
		//if (test2 != null)
		//fail("Test Case 2 shold have been null but got " + test2);		
		

		if(test3 != 'B')
		fail("Test Case 3 should have been B but got " + test3);
	}

	@Test
	public void testGetWidth() {
		//Setup
		LascaBoard board = new LascaBoard();
		//Method Execution
		int test = board.getWidth();
		//Verification
		if(test != 7)
		fail("Board initialized to 7 width however got " + board.getWidth());
	}

	@Test
	public void testGetHeight() {
		//Setup
		LascaBoard board = new LascaBoard(9, 9);
		//Method Execution
		int test = board.getHeight();
		//Verification
		if(test != 9)
		fail("Board initialized to 9 height however got " + board.getHeight());
	}

	@Test
	public void testSet() {
		//Setup
		LascaBoard board = new LascaBoard();
		//Method Execution
		board.set(3, 3, 'Y');
		//Verification
		if(board.get(3, 3) != 'Y')
		fail("Should have been y but got something else");
	}

	@Test
	public void testshowQueue() {
		//Setup
		LascaBoard board = new LascaBoard();
		board.set(0, 0, 'B');
		board.set(0, 0, 'F');
		board.set(0, 0, 'G');
		
		//Method Execution
		String test1 = board.showQueue(0, 0);
		//Verificiation
		if (!test1.equals("[R, B, F, G]"))
		fail("The Queue should have contained [R, B, F, G] but has " + test1);
	}

	@Test
	public void testMove() {
		//Setup
		LascaBoard board = new LascaBoard();
		board.set(3, 3, 'R');
		board.set(2, 2, 'B');
		board.set(2, 2, 'G');
		board.set(2, 2, 'R');
		board.set(3, 5, 'R');
		board.set(4, 4, 'F');
		board.clearContents(5, 3);
		//Method Execution
		boolean test1 = board.adjustMove(2, 0, 1);
		boolean test2 = board.adjustMove(1, 1, 1);
		boolean test3 = board.adjustMove(2, 2, 1);
		boolean test4 = board.adjustMove(3, 5, 1);
		boolean test5 = board.adjustMove(6, 2, 1);
		boolean test6 = board.adjustMove(0, 0, 9);
		boolean test7 = board.adjustMove(3, 6, 9);
		//Verification
		if (test1 != false)
		fail("Test Case Moving off the board should be false and first catch however we got " + test1);
		
		if (test2 != false) 
		fail("Test Case Moving into your own piece should have resulted in failure however we got " + test2);
		
		if (test3 != true)
		fail("Test Case Moving into an empty string should be true however got " + test3);
		
		if (test4 != true)
		fail("Not yet Implimented");
		
		if(test5 != false)
		fail("Test Case Moving off the board south should be false and first catch however we got " + test5);
		
		if(test6 != false)
		fail("The Test case moving off the board to the north should be an error but got " + test6);
		
		if(test7 != false)
		fail("The Test Case moving off the board to the right should be an error but got " + test7);
		
	}

	
	@Test
	public void testMove2() {
		//Setup
		LascaBoard board = new LascaBoard();
		board.set(3, 1, 'B');
		board.set(3, 5, 'B');
		board.clearContents(4, 4);
		board.clearContents(1, 5);
		board.set(1, 5, 'B');
		board.clearContents(1, 3);
		board.set(1, 3, 'B');
		//Method Execution
		boolean test1 = board.adjustMove(2, 2, 1);
		boolean test2 = board.adjustMove(2, 6, 1);
		boolean test3 = board.adjustMove(1, 5, 9);
		boolean test4 = board.adjustMove(1, 3, 9);
		boolean test5 = board.adjustMove(3, 1, 7);
		//Verification
		if(test1 != false)
		fail("Test to jump a player and have a piece behind it failed");
		
		if(test2 != true)
		fail("Test to jump into a unfilled space should have worked but failed.");
		
		if(test3 != false) {
		fail("Test to jump off the board should have failed yet didnt.");
		}
		if(test4 != false) {
		fail("Test to jump off the board should have failed yet didnt.");
		}
		if(test5 != false) 
		fail("Test to jump off the board should have failed yet didnt");
	}
	
	@Test
	public void testemptyQueueTransfer() {
		//Setup
		LascaBoard board = new LascaBoard();
		board.set(0, 0, 'R');
		board.set(0, 0, 'R');
		board.set(0, 0, 'R');
		board.set(0, 0, 'R');
		//Method Verification
		board.emptyQueueTransfer(0, 0, 0, 1);
		//Verification
		if(!board.showQueue(0, 1).equals("[R, R, R, R, R]"))
		fail("The Queue should have been R five times however " + (board.showQueue(0, 1)));
	}
	
	@Test
	public void testcheckWinnerR() {
		//Setup
		LascaBoard board = new LascaBoard();
		for(int i = 0; i < board.getHeight(); i++) {
			for(int j = 0; j < board.getWidth(); j++) {
				if (board.get(i, j) == null) {
					
				}
				else if (board.get(i, j) == 'R') {
					board.clearContents(i, j);
				}
			}
		}
		//Method Execution
		boolean test = board.checkWinner();
		//Verification
		if (test != true)
		fail("Cleared Board of Red Pieces yet checkwinner returned " + test);
	}
	
	@Test
	public void testcheckWinnerB() {
		//Setup
		LascaBoard board = new LascaBoard();
		for(int i = 0; i < board.getHeight(); i++) {
			for(int j = 0; j < board.getWidth(); j++) {
				if (board.get(i, j) == null) {
					
				}
				else if (board.get(i, j) == 'B') {
					board.clearContents(i, j);
				}
			}
		}
		//Method Execution
		boolean test = board.checkWinner();
		//Verification
		if (test != true)
		fail("Cleared Board of Black Pieces yet checkwinner returned " + test);
	}
	
	@Test
	public void testcheckWinner3() {
		//Setup
		LascaBoard board = new LascaBoard();
		//Method Execution
		boolean test = board.checkWinner();
		//Verification
		if (test != false)
		fail("Board has both pieces so check winner should return false yet returned " + test);
	}
	
	
	@Test
	public void testadjustMove() {
		//Setup
		LascaBoard board = new LascaBoard();
		for(int i = 0; i < board.getHeight(); i++) {
			for(int j = 0; j < board.getWidth(); j++) {
				if (board.get(i, j) == null) {
					
				}
				else if (board.get(i, j) == 'B' || board.get(i,j) == 'R') {
					board.clearContents(i, j);
				}
			}
		}
		board.set(1, 1, 'R');
		board.set(1, 5, 'B');
		board.set(5, 1, 'B');
		board.set(5, 5, 'R');
		//Method Execution
		boolean test = board.adjustMove(1, 1, 7);
		boolean test2 = board.adjustMove(1, 5, 9);
		boolean test3 = board.adjustMove(5, 1, 1);
		boolean test4 = board.adjustMove(5, 5, 3);
		//Verification
		if(test != true)
		fail("Moved up and left and failed");
		
		if (test2 != true)
		fail("Moved up and right and failed");
		
		if(test3 != true)
		fail("Moved down and left and failed");
		
		if(test4 != true)
		fail("Moved down and right and failed");
	}
	
	
	@Test
	public void testcheckHasMoves() {
		//Setup
		LascaBoard board = new LascaBoard();
		for(int i = 0; i < board.getHeight(); i++) {
			for(int j = 0; j < board.getWidth(); j++) {
				if (board.get(i, j) == null) {
					
				}
				else if (board.get(i, j) == 'B' || board.get(i,j) == 'R') {
					board.clearContents(i, j);
					board.set(i, j, 'B');
					board.clearContents(1, 1);
					board.set(1, 1, 'R');
					board.set(3, 3, 'R');
				}
			}
		}
		
		//Method Execution
		boolean test1 = board.checkHasMoves(board, 0);
		boolean test2 = board.checkHasMoves(board, 1);
		
		//Verification
		if(test1 != false)
		fail("Piece is Surrounded on All sides and not jumpable should be false got " + test1);
		
		if(test2 != true)
		fail("Black Pieces can move should return true");
		
	}
	
	@Test
	public void testcheckHasMoves2() {
		//Setup
		LascaBoard board = new LascaBoard();
		for(int i = 0; i < board.getHeight(); i++) {
			for(int j = 0; j < board.getWidth(); j++) {
				if (board.get(i, j) == null) {
					
				}
				else{
					board.clearContents(i, j);
					board.set(i, j, 'B');
				}
			}
		}
		board.set(3, 1, 'B');
		board.set(3, 3, 'B');
		board.set(3, 5, 'B');
		//Method Execution
		boolean test1 = board.checkHasMoves(board, 0);
		boolean test2 = board.checkHasMoves(board, 1);
		
		//Verification
		if(test1 != false)
		fail("Piece is Surrounded on All sides and not jumpable should be false got " + test1);
		
		if(test2 != false)
		fail("Black Pieces can move should return true");
		
	}
	
	@Test
	public void testcheckHasMoves3() {
		//Setup
		LascaBoard board = new LascaBoard();
		for(int i = 0; i < board.getHeight(); i++) {
			for(int j = 0; j < board.getWidth(); j++) {
				if (board.get(i, j) == null) {
					
				}
				else{
					board.clearContents(i, j);
					board.set(i, j, 'B');
				}
			}
		}
		board.set(3, 1, 'B');
		board.set(3, 3, 'B');
		board.set(3, 5, 'B');
		board.clearContents(2, 2);
		board.set(2, 2, 'R');
		//Method Execution
		boolean test1 = board.checkHasMoves(board, 0);
		boolean test2 = board.checkHasMoves(board, 1);
		
		//Verification
		if(test1 != false)
		fail("Piece is Surrounded on All sides and not jumpable should be false got " + test1);
		
		if(test2 != false)
		fail("Black Pieces can move should return true");
		
	}
}