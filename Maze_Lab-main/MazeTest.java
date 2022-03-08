import static org.junit.Assert.*;

import org.junit.Test;

public class MazeTest {

	@Test
	public void testMaze() {
		//Setup
		int mazeHeight = 3;
		int mazeWidth = 3;
		//Method Execution
		Maze maze = new Maze(mazeWidth, mazeHeight);
		int Htest = maze.getHeight();
		int Wtest = maze.getWidth();
		//Validation
		if (Wtest != 3 && Htest != 3)
		fail("The Width should have been 3 but was " + maze.getWidth() + 
				" and the hieght should have been 3 but was " + maze.getHeight());
	}

	@Test
	public void testGetWidth() {
		//Setup
		int mazeHeight = 4;
		int mazeWidth = 5;
		Maze maze = new Maze(mazeWidth, mazeHeight);
		//Mathod Execution
		int test = maze.getWidth();
		//Verification
		if (test != 5)
		fail("Maze Width should be 5 but got " + maze.getWidth());
	}

	@Test
	public void testGetHeight() {
		//Setup
		int mazeHeight = 8;
		int mazeWidth = 6;
		Maze maze = new Maze(mazeWidth, mazeHeight);
		//Method Execution
		int test = maze.getHeight();
		//Verification
		if (test != 8)
		fail("Maze Height should be 8 but got " + maze.getHeight());
	}

	@Test
	public void testSet() {
		//Setup
		int mazeHeight = 3;
		int mazeWidth = 3;
		Maze maze = new Maze(mazeWidth, mazeHeight);	
		//Method Execution
		maze.set('#', 0, 0);
		maze.set('@', 0, 1);
		maze.set('#', 0, 2);
		maze.set('&', 1, 0);
		maze.set('*', 1, 1);
		maze.set('%', 1, 2);	
		//Verification
		if (maze.get(0, 0) != '#' && maze.get(0, 1) != '@' && maze.get(0,2) != '#')
		fail("The Position should have reported # however got " + maze.get(0, 0));
	}

	@Test
	public void testSolve() {
		//Setup
		int mazeH = 10;
		int mazeW = 10;
		Maze maze = new Maze(mazeW, mazeH);
		for(int i = 0; i < maze.getWidth(); i ++) {
			for(int j = 0; j < maze.getHeight(); j ++) {
				maze.set('#', i, j);
			}
		}
		maze.set(' ', 1, 1);
		maze.set(' ', 1, 2);
		maze.set(' ', 1, 3);
		maze.set(' ', 2, 3);
		maze.set(' ', 3, 3);
		maze.set(' ', 4, 3);
		maze.set(' ', 4, 2);
		maze.set(' ', 4, 1);
		maze.set(' ', 5, 1);
		maze.set(' ', 5, 3);
		maze.set(' ', 5, 4);
		maze.set(' ', 5, 5);
		maze.set(' ', 6, 3);
		maze.set(' ', 6, 2);
		maze.set(' ', 6, 5);
		maze.set(' ', 7, 5);
		maze.set(' ', 8, 1);
		maze.set(' ', 8, 2);
		maze.set(' ', 8, 3);
		maze.set(' ', 8, 4);
		maze.set(' ', 8, 5);
		maze.set(' ', 8, 6);
		maze.set(' ', 8, 7);
		maze.set(' ', 8, 8);
		maze.set(' ', 8, 8);
		maze.set(' ', 7, 7);
		maze.set(' ', 6, 7);
		maze.set(' ', 5, 7);
		maze.set(' ', 4, 7);
		maze.set(' ', 4, 8);
		maze.set(' ', 3, 8);
		maze.set(' ', 2, 8);
		maze.set(' ', 1, 8);
		maze.set(' ', 2, 7);
		maze.set(' ', 2, 6);
		maze.set(' ', 2, 5);
		maze.set(' ', 1, 5);
		//Method Execution
		String result = maze.solve(1, 1, 1, 5, null);
		maze.resetMaze();
		String result2 = maze.solve(1, 5, 1, 1, null);
		maze.resetMaze();
		String result3 = maze.solve(1, 1, 6, 8, null);
		//Validation
		if (! result.equals("1,3-4,3-5,3-5,5-8,5-8,7-4,7-4,8-2,8-2,5-1,5"))
		fail("String did not report correct moves to Solve Maze");
		if (!result2.equals("2,5-2,8-4,8-4,7-8,7-8,5-5,5-5,3-4,3-1,3-1,1"))
		fail("String2 did not report correct move to Solve Maze");	
		if (result3 != null)
		fail("Tried to Solve A Non Maze Coordinate and Got Something Else");
	}
	
	@Test
	public void testResetMaze() {
		//Setup
		int mazeW = 3;
		int mazeH = 3;
		Maze maze = new Maze(mazeW, mazeH);
		for(int i = 0; i < maze.getWidth(); i ++) {
			for(int j = 0; j < maze.getHeight(); j ++) {
				maze.set('#', i, j);
			}
		}
		maze.set('*', 1, 1);
		//Method Execution
		maze.resetMaze();
		//Verification
		if(maze.get(1, 1) != ' ')
		fail("Tested Reset yet it didnt reset the Space to ' '");
	}
}
