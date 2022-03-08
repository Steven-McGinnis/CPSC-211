import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Board {
	private int hieght;
	private int width;
	private int[][] adjMat;
	private ArrayList<Integer> visited = new ArrayList<Integer>();
	
	public Board(int size) {
		this.hieght = size;
		this.width = size;
		adjMat = new int[width][hieght];
	}
	
	public int[][] sendBoard() {
		return adjMat;
	}
	public void solve(int node, int adjSize) {	
		 Queue<Integer> q = new LinkedList<>();
		 q.add(node);
		 
		 while(!q.isEmpty()) {
			 int current = q.peek();
			 System.out.println(current);
			 q.poll();
			 
			 for(int i = 0; i < getWidth(); i ++) {
				 if(get(node, i) != 0 && isVisited(node) == false) {
					 q.add(i);
					 System.out.println(q);
				 }
			 }

			 if(isVisited(current) != true) {
				System.out.println(current);
				 visited.add(current);
			 }
		 }
		 System.out.println(q);
		 System.out.println(visited);
	}
	
	private boolean isVisited(int node) {
		for(int i = 0; i < visited.size(); i++) { 
			if (node == visited.get(i)) {
				return true;
			}
		}
		return false;
	}
	
	public void addEdge(int node, int edge) {
		adjMat[node][edge] = 1;
	}
	
	public int getWidth(){
		return adjMat[0].length;
	}
	
	public int getHeight() {
		return adjMat.length;
	}
	
	public int get(int one, int two) {
		return adjMat[one][two];
	}
	
	public void displayBoard() {
		for (int i = 0; i < getWidth(); i++) {
			for(int j = 0; j < getHeight(); j++) {
			System.out.print(get(i, j));
			}
			System.out.println();
		}
	}
	
	public void applyADJ(ArrayList<String> lines) {
		int node = 0;	
		while (lines.isEmpty() != true) {
			String line = lines.get(0);
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				if (c != ' ') {
					int a=Character.getNumericValue(c); 
					addEdge(node, a);
				}	
			}
			lines.remove(0);
			node ++;
		}
	}
}
