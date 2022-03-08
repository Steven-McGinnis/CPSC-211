import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CoordinateHandlerTest {

	@Test
	void testAddStart() {
		// Setup
		CoordinateHandler cords = new CoordinateHandler();
		// Method Execution
		cords.addStart(20, 10);
		// Verification
		if (cords.getStartRow() != 20)
			fail("Added 20 to StartCords got " + cords.getStartRow());
	}

	@Test
	void testAddEnd() {
		// Setup
		CoordinateHandler cords = new CoordinateHandler();
		// Method Execution
		cords.addEnd(89, 20);
		// Verification
		if (cords.getEndRow() != 89)
			fail("Added end Coordinate 89 got " + cords.getEndRow());
	}

	@Test
	void testIsEmpty() {
		//Setup
		CoordinateHandler cords = new CoordinateHandler();
		//Method Execution
		boolean test1 = cords.isEmpty();
		cords.addStart(8765, 0);
		boolean test2 = cords.isEmpty();
		//Verification
		if (test1 != true)
		fail("Asked if Array StartCords is Empty and Got " + test1);
		if(test2 != false)
		fail("Asked EndCords if Empty and it should have 8765 so should be false but got " + test2);
	}

	@Test
	void testGetStartRow() {
		//Setup
		CoordinateHandler cords = new CoordinateHandler();
		cords.addStart(632, 750);
		//Method Execution
		int test1 = cords.getStartRow();
		//Verification
		if(test1 != 632)
		fail("Added 632 and got " + test1);
	}

	@Test
	void testGetStartColumn() {
		//Setup
		CoordinateHandler cords = new CoordinateHandler();
		cords.addStart(76, 34);
		//Method Execution
		int test1 = cords.getStartColumn();
		int test2 = cords.getStartColumn();
		//Verification
		if (test1 != 76)
		fail("Wanted Column was 76 but got " + test1);
		if(test2 != 34)
		fail("Wanted 34 but got " + test2);
	}

	@Test
	void testGetEndRow() {
		//Setup
		CoordinateHandler cords = new CoordinateHandler();
		cords.addEnd(891, 450);
		//Method Execution
		int test1 = cords.getEndRow();
		int test2 = cords.getEndRow();
		//Verification
		if(test1 != 891)
		fail("Asked for EndRow 891 got " + test1);
		if(test2 != 450)
		fail("Asked for EndRow 450 got " + test2);
	}

	@Test
	void testGetEndColumn() {
		//Setup
		CoordinateHandler cords = new CoordinateHandler();
		cords.addEnd(221, 457);
		//Method Execution
		int test1 = cords.getEndColumn();
		int test2 = cords.getEndColumn();
		//Verification
		if(test1 != 221)
		fail("Asked for EndRow 891 got " + test1);
		if(test2 != 457)
		fail("Asked for EndRow 450 got " + test2);
	}

	@Test
	void testgetStartCordRow() {
		//Setup
		CoordinateHandler cords = new CoordinateHandler();
		cords.addStart(5, 8);
		//Method Execution
		int test1 = cords.getStartCordRow();
		//Verification
		if(test1 != 5)
		fail("Asked for Row 5 but got " + test1);
	}
	
	@Test
	void testgetStartCordCol() {
		//Setup
		CoordinateHandler cords = new CoordinateHandler();
		cords.addStart(8, 4);
		//Method Execution
		int test1 = cords.getStartCordCol();
		//Verification
		if(test1 != 4)
		fail("Asked for Column 4 but got " + test1);
	}
	
	
	
	
}
