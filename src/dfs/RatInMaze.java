package dfs;

/****** rat in maze (2 direction allowed ,down and forward *******/
// O(2(n^2))
// O(ROW * COL) as result matrix is taken for extra space

public class RatInMaze {

	public static int ROW = 4, COL = 4;

	void printSolution(int[][] sol) {
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				System.out.print(" " + sol[i][j] + " ");

			}
			System.out.println();
		}
	}

	boolean isSafe(int[][] maze, int i, int j) {
		if (i >= 0 && i < ROW && j >= 0 && j < COL && maze[i][j] == 1 )
			return true;
		return false;
	}

	boolean solveMaze(int maze[][]) {
		int sol[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

		if (solveMazeUtil(maze, 0, 0, sol) == false) {
			System.out.print("Solution doesn't exist");
			return false;
		}
		printSolution(sol);
		return true;
	}

	boolean solveMazeUtil(int[][] maze, int i, int j, int[][] sol) {
		if (i == ROW - 1 && j == COL - 1) {
			sol[i][j] = 1;
			return true;
		}

		if (isSafe(maze, i, j)) {
			sol[i][j] = 1;

			if (solveMazeUtil(maze, i + 1, j, sol)) {
				return true;
			}
			if (solveMazeUtil(maze, i, j + 1, sol)) {
				return true;
			}

			sol[i][j] = 0;
			return false;
		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RatInMaze rat = new RatInMaze();
		int maze[][] = { 
				{ 1, 0, 0, 0 }, 
				{ 1, 1, 1, 1 }, 
				{ 0, 1, 0, 1 }, 
				{ 1, 1, 0, 1 } };
		rat.solveMaze(maze);
	}
}
