public class Maze {

	private int width;
	private int height;
	private char[][] maze;

	public Maze(int width, int height) {
		this.width = width;
		this.height = height;
		maze = new char[width][height];// create the maze array
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void set(char character, int row, int column) {
		maze[row][column] = character;// Should set row and column in the maze to the correct value
	}

	public char get(int row, int height) {// Method to call a Specific Position
		return maze[row][height];
	}

	// Solve algorithm for running through the maze
	public String solve(int startRow, int startcol, int endrow, int endcol, String direction) {

		// Initialize the Result String that will be returned
		String result = "";
		String previousDirection = direction;

		// Change Current Space to * to Prevent Using It again in endless Loop
		set('*', startRow, startcol);

		// base case test if you are already at the starting point
		if (startRow == endrow && startcol == endcol) {
			result = endrow + "," + endcol;
			return result;
		}

		// count number of clear spots and return null if its 0
		if (countdirections(startRow, startcol) == 0) {
			return null;
		}
		
		// If there is only one way to go go that way.
		if (countdirections(startRow, startcol) == 1) {
			if (get(startRow + 1, startcol) == ' ') {// Check South Direction for Empty Character
				String changedDirection = "South";// Create Direction Change String
				if (previousDirection == null) {// If No Moves Have Happened Yet
					return solve((startRow + 1), startcol, endrow, endcol, changedDirection);
				} else if (previousDirection.equals("South")) {
					return solve((startRow + 1), startcol, endrow, endcol, changedDirection);
				} else {
					int southRow = startRow + 1;
					int southCol = startcol;
					result = solve(southRow, southCol, endrow, endcol, changedDirection);
					if (result != null) {
						return startRow + "," + startcol + "-" + result;
					}
				}
			} else if (get((startRow - 1), startcol) == ' ') {
				if (get(startRow - 1, startcol) == ' ') {// Check North Direction for Empty Character
					String changedDirection = "North";// Create Direction Change String
					if (previousDirection == null) {// If No Moves Have Happened Yet
						return solve((startRow - 1), startcol, endrow, endcol, changedDirection);
					} else if (previousDirection.equals("North")) {
						return solve((startRow - 1), startcol, endrow, endcol, changedDirection);
					} else {
						int northRow = startRow - 1;
						int northCol = startcol;
						result = solve(northRow, northCol, endrow, endcol, changedDirection);
						if (result != null) {
							return startRow + "," + startcol + "-" + result;
						}
					}
				}
			} else if (get(startRow, (startcol + 1)) == ' ') {
				if (get(startRow, (startcol + 1)) == ' ') {// Check East Direction for Empty Character
					String changedDirection = "East";// Create Direction Change String
					if (previousDirection == null) {// If No Moves Have Happened Yet
						return solve(startRow, startcol + 1, endrow, endcol, changedDirection);// return solve with new
					} else if (previousDirection.equals("East")) {										
						return solve(startRow, startcol + 1, endrow, endcol, changedDirection);
					} else {
						int eastRow = startRow;
						int eastCol = startcol + 1;
						result = solve(eastRow, eastCol, endrow, endcol, changedDirection);
						if (result != null) {
							return startRow + "," + startcol + "-" + result;
						}
					}
				}
			} else if (get(startRow, (startcol - 1)) == ' ') {
				if (get(startRow, startcol - 1) == ' ') {// Check West Direction for Empty Character
					String changedDirection = "West";// Create Direction Change String
					if (previousDirection == null) {// If No Moves Have Happened Yet
						return solve(startRow, startcol - 1, endrow, endcol, changedDirection);
					} else if (previousDirection.equals("West")) {
						return solve(startRow, startcol - 1, endrow, endcol, changedDirection);
					} else {
						int westRow = startRow;
						int westCol = startcol - 1;
						result = solve(westRow, westCol, endrow, endcol, changedDirection);
						if (result != null) {
							return startRow + "," + startcol + "-" + result;
						}
					}
				}
			}
		}
		// If There are Multiple Ways to Go Determine Path from EAST>SOUTH>WEST>NORTH

		// if we can move east
		if (get(startRow, startcol + 1) == ' ') {
			String changedDirection = "East";
			int eastRow = startRow;
			int eastCol = startcol + 1;
			result = solve(eastRow, eastCol, endrow, endcol, changedDirection);
			if (result != null) {
				return startRow + "," + startcol + "-" + result;
			}
		}
		// if we can move south
		if (get(startRow + 1, startcol) == ' ') {
			String changedDirection = "South";
			int southtRow = startRow + 1;
			int southCol = startcol;
			result = solve(southtRow, southCol, endrow, endcol, changedDirection);
			if (result != null) {
				return startRow + "," + startcol + "-" + result;
			}
		}
		// if we can move west
		if (get(startRow, startcol - 1) == ' ') {
			String changedDirection = "West";
			int westRow = startRow;
			int westCol = startcol - 1;
			result = solve(westRow, westCol, endrow, endcol, changedDirection);
			if (result != null) {
				return startRow + "," + startcol + "-" + result;
			}
		}
		// if we can move north
		if (get(startRow - 1, startcol) == ' ') {
			String changedDirection = "North";
			int northRow = startRow - 1;
			int northCol = startcol;
			result = solve(northRow, northCol, endrow, endcol, changedDirection);
			if (result != null) {
				return startRow + "," + startcol + "-" + result;
			}
		}
		return null;
	}
	//Counts the Number of Directions you can go
	private int countdirections(int currentrow, int currentcol) {
		int directions = 0;
		if (get((currentrow + 1), currentcol) == ' ') {
			directions++;
		}
		if (get((currentrow - 1), currentcol) == ' ') {
			directions++;
		}
		if (get(currentrow, (currentcol + 1)) == ' ') {
			directions++;
		}
		if (get(currentrow, (currentcol - 1)) == ' ') {
			directions++;
		}
		return directions;
	}

	// Resets Maze After Dropping BreadCrumbs
	public void resetMaze() {
		int height = getHeight();
		int width = getWidth();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (get(i, j) == '*') {
					set(' ', i, j);
				}
			}
		}
	}
}