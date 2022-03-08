
public class IsolaTextView {
	private IsolaBoard board;
	
	public IsolaTextView(IsolaBoard board)
	{
		this.board = board;
	}
	
	public void display() {
		System.out.println();
		for (int i = 0; i < board.getWidth(); i++) {
			for (int j = 0; j < board.getHeight(); j++) {
				if (board.get(i, j).toString().equals("Available"))
				{
					System.out.print("-");
				}
				else if (board.get(i, j).toString().equals("Player 1")) 
				{
					System.out.print("1");
				}
				else if (board.get(i, j).toString().equals("Player 2"))
				{
					System.out.print("2");
				}
				else {
					System.out.print(" ");
				}
				
			}
			System.out.println();
		}
	}
}
