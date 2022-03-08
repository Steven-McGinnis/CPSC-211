import java.util.ArrayList;
import java.util.List;

public class CoordinateHandler {
	List<Integer> StartCords = new ArrayList<Integer>();
	List<Integer> EndCords = new ArrayList<Integer>();
	
	public void addStart(int row, int column) {
		StartCords.add(row);
		StartCords.add(column);
	}

	public void addEnd(int rowend, int columnend) {
		EndCords.add(rowend);
		EndCords.add(columnend);
	}

	public boolean isEmpty() {
		return StartCords.isEmpty();
	}
	
	public int getStartCordRow() {
		return StartCords.get(0);
	}
	
	public int getStartCordCol() {
		return StartCords.get(1);
	}
	
	public int getStartRow() {
		int startRow = StartCords.get(0);
		StartCords.remove(0);
		return startRow;
		}
	
	public int getStartColumn() {
		int startColumn = StartCords.get(0);
		StartCords.remove(0);
		return startColumn;
	}
	
	public int getEndRow() {
		int endRow = EndCords.get(0);
		EndCords.remove(0);
		return endRow;
	}
	
	public int getEndColumn() {
		int endColumn = EndCords.get(0);
		EndCords.remove(0);
		return endColumn;
	}
}
