package dfs;

//Length of largest region in a matrix
//O(row*col)

public class MaxIslandLength {
	// No of rows and columns
	static final int ROW = 5, COL = 5;
	static int length = 0;

	// A function to check if a given cell (row, col) can
	// be included in DFS
	boolean isSafe(int M[][], int row, int col, boolean visited[][]) {
		// row number is in range, column number is in range
		// and value is 1 and not yet visited
		return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (M[row][col] == 1 && !visited[row][col]);
	}

	// A utility function to do DFS for a 2D boolean matrix.
	// It only considers the 8 neighbors as adjacent vertices
	void DFS(int M[][], int row, int col, boolean visited[][]) {
		// These arrays are used to get row and column numbers
		// of 8 neighbors of a given cell
		int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
		int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

		// Mark this cell as visited
		visited[row][col] = true;
		length++;

		// Recur for all connected neighbours
		for (int k = 0; k < 8; ++k)
			if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited))
				DFS(M, row + rowNbr[k], col + colNbr[k], visited);
	}

	// The main function that returns count of islands in a given
	// boolean 2D matrix
	int largestRegion(int M[][]) {
		// Make a bool array to mark visited cells.
		// Initially all cells are unvisited
		boolean visited[][] = new boolean[ROW][COL];

		// Initialize count as 0 and traverse through the all cells
		// of given matrix
		int result = 0;
		for (int i = 0; i < ROW; ++i)
			for (int j = 0; j < COL; ++j)
				if (M[i][j] == 1 && !visited[i][j]) // If a cell with
				{ // value 1 is not
					// visited yet, then new island found, Visit all
					// cells in this island and increment island count
					length = 0;
					DFS(M, i, j, visited);
					result = Math.max(length, result);
					//System.out.println("length: " + length);
				}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int M[][] = new int[][] { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 } };
		MaxIslandLength obj = new MaxIslandLength();
		System.out.println("Maximum length  of islands is: " + obj.largestRegion(M));
	}

}
