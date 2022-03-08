import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class MazeController {
	private File userFile;
	PrintWriter output = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MazeController controller = new MazeController();
		controller.go(null);

	}

	public void go(Maze maze) {
		CoordinateHandler cords = new CoordinateHandler();
		maze = readMazeFromFile(cords);
		createOutput();
		while (!cords.isEmpty()) {
			int startRow = cords.getStartCordRow();
			int startCol = cords.getStartCordCol();
			maze.resetMaze();
			String result = solvemaze(cords, maze);
			if (result == null) {
				output.println("Impossible");
			} else {
				output.print(startRow + "," + startCol + "-");
				printResult(result);
			}
		}
		outputClose();
	}

	public Maze readMazeFromFile(CoordinateHandler cords) {
		File file = getMazeFileFromUser(); // Gets File from filechooser

		if (file == null) { // Catch if Cancel Was Selected
			return null; //
		}
		Scanner input = null;// Create Scanner
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Could not find the file " + file.getName());
			return null;
		}
		int mazeHeight = input.nextInt();
		int mazeWidth = input.nextInt();
		input.nextLine(); // Go to next line for read
		Maze maze = new Maze(mazeWidth, mazeHeight); // Create Maze with new Sizes

		for (int row = 0; row < mazeWidth; row++) {
			String mazerow = input.nextLine(); // Assign String for Maze Row
			for (int column = 0; column < mazeHeight; column++) { // Run through row from left to right
				char character = mazerow.charAt(column); // read character
				maze.set(character, row, column);
			}
		}

		while (input.hasNext()) { // while we have start and end coordinates
			int rowstart = input.nextInt();
			int columnstart = input.nextInt();
			int rowend = input.nextInt();
			int columnend = input.nextInt();
			cords.addStart(rowstart, columnstart); // read start coordinates and add them to list
			cords.addEnd(rowend, columnend); // read end coordinates and add them to the list
		}
		input.close();// Close scanner
		return maze;
	}

	private File getMazeFileFromUser()

	{
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(null);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			this.userFile = file;
			return file;
		} else if (returnVal == JFileChooser.CANCEL_OPTION) {
			System.out.println("No File Selected");
			return null;
		}
		return null;
	}

	/**
	 * Takes the Cordinate Handler and Maze Reads the Start and End Coordinates from
	 * the Coordinate Handler Then Passes Them into Maze Solve Which runs the
	 * algorithm for Solving the Maze Returns the Resulting String up to Go
	 * 
	 * @param cords Passes Cordinate Handler to solve
	 * @param maze  Passes The Maze to solve
	 * @return String result;
	 */
	private String solvemaze(CoordinateHandler cords, Maze maze) {
		//output.print(cords.getStartCordRow() + "," + cords.getStartCordCol() + "-");
		String result = maze.solve(cords.getStartRow(), cords.getStartColumn(), cords.getEndRow(),
				cords.getEndColumn(), null);
		return result;
	}

	// Creates Output File
	private void createOutput() {
		File file = new File(userFile + ".out");

		try {
			output = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Close Output File
	private void outputClose() {
		output.close();
	}

	// Print Result to File
	private void printResult(String result) {
		output.print(result);
		output.println();
	}

}
