import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReplayController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReplayController controller = new ReplayController();
		controller.go();	
	}
	
	
	public void go() {
		int index = 0;
		File file = new File ("Output.dat");
		Scanner input = null;
		
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Could Not read output.dat");
			return;
		}
		IsolaBoard board = new IsolaBoard();//create board
		IsolaTextView view = new IsolaTextView(board);//create a view attached to that board
		MovementController movement = new MovementController();
		while (input.hasNextLine()){
			view.display();//	display board
			String move = input.nextLine();//	read player move from output.da
			BoardPosition newPosition = movement.checkplayermove(board, move, movement.who(index));
			board.movePlayer(movement.who(index), newPosition);//	make move on board
			index = (index + 1) % 2;//switch to next player
			//
			try
			{
				//Sleep time is in milliseconds
				Thread.sleep(1000);// delay for 1 second
			} catch (Exception e)
			{
				//This should never happen	
			}
		}
		view.display();
		input.close();//close output.dat
		}
	}
