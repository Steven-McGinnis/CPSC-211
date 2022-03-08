import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class Controller {
	private Board board;
	private int adjSize;
	private ArrayList<String> lines;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controller controller = new Controller();
		controller.go();
	}

	private void go() {
		// TODO Auto-generated method stub

		File file = filePrompt();
		this.lines = readFile(file);
		Board board = new Board(adjSize);
		board.applyADJ(lines);
		board.displayBoard();
		board.solve(0, adjSize);
		
		
		
	}

	private ArrayList<String> readFile(File file) {
		// TODO Auto-generated method stub
		if (file == null) { // Catch if Cancel Was Selected
		}
		Scanner input = null;// Create Scanner
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Could not find the file " + file.getName());
			System.exit(0);
		}
		
		ArrayList<String> lines = new ArrayList<String>();
		
		adjSize = input.nextInt();
		while (input.hasNextLine()) {
			String line = input.nextLine();
			lines.add(line);
		}
		lines.remove(0);
		return lines;
	}

	private File filePrompt() {
		// TODO Auto-generated method stub
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(null);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			return file;
		} else if (returnVal == JFileChooser.CANCEL_OPTION) {
			System.out.println("No File Selected");
			System.exit(0);
			return null;
		}
		return null;
	}
}
