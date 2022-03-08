import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoPlayerController {
	private String move;
	private int index = 0;

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoPlayerController controller = new TwoPlayerController();
		controller.go();
		
	}
	
	private void go() 
	{
		TwoPlayerController controller = new TwoPlayerController();//create board
		IsolaBoard board = new IsolaBoard();
		IsolaTextView view = new IsolaTextView(board);//create a view attached to that board
		MovementController movement = new MovementController();
		
		File file = new File("output.dat");//create output.dat		
		PrintWriter output = null;
		try {
			output = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Could Not create output.dat");
			return;
		}	
		
		Boolean gameover = false;//Boolean for Gameover Loop
		while (! gameover) //while game is not over
		{
			view.display();//display board
		
			
			Boolean notMoved = false;
			while (notMoved == false) 
			{
				this.move = controller.playerMoveRequest(index);//ask current player for the move
				BoardPosition newPosition = movement.checkplayermove(board, move, movement.who(index));
				if (newPosition == null) 
				{
					//if its an invalid input restart the loop
				}
				else 
				{

					board.movePlayer(movement.who(index), newPosition);//If Valid Apply Move
					output.println(move);//Print Move to Output File
					notMoved = true;
				}		
			}
			BoardSpace isThereWinner = board.checkWinner();//calls Check Winner to check if games over
			gameover = movement.checkwinner(isThereWinner);
			index = (index + 1) % 2;//switch to next player
		}
		view.display();
		output.close();//close output.dat
	}	
	
	private String playerMoveRequest(int index)
	{
		int hasMoved = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Player " + (index + 1) + " what move would you like to make?" );
		System.out.println("You can input any Cardinal Direction such as N, NE, NW, E, SE, S, SW, W.");
		while (hasMoved == 0) 
		{
			String move = scan.nextLine();
			if (move.equals("N") || move.equals("NE") || move.equals("NW") || move.equals("E") || move.equals("SE") || move.equals("S") || move.equals("SW") || move.equals("W")) {
				hasMoved = 1;
				return move;
			}
			else {
				System.out.println("Im sorry that is not a valid move");
				System.out.println("You can input any Cardinal Direction such as N, NE, NW, E, SE, S, SW, W.");	
			}
		}
		scan.close();
		return move;
	}
	

}

