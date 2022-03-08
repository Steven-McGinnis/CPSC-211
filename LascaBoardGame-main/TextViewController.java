
public class TextViewController {
	private LascaBoard board;
	
	public TextViewController(LascaBoard board) {
		this.board = board;
	}
	
	public void displayBoard() {

		System.out.print(' ');
		System.out.print(' ');
		for (int k = 0; k < board.getWidth(); k ++) {
			System.out.print(k);
		}
		System.out.println();
		
		for (int i = 0; i < board.getHeight(); i++) {
			System.out.print(i);
			System.out.print(' ');
			for (int j = 0; j < board.getWidth(); j++) {
				if (board.get(i, j)== null) {
					System.out.print('-');
				}
				else {
					System.out.print(board.get(i, j));
				}
			}
			System.out.println();
		}	
		System.out.println();
	}
}