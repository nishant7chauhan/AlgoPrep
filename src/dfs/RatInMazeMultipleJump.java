package dfs;

public class RatInMazeMultipleJump {

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
		if (i >= 0 && i < ROW && j >= 0 && j < COL && maze[i][j] != 0 )
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

		if (isSafe(maze, i, j) == true) {
			sol[i][j] = 1;

			if (solveMazeUtil(maze, i + maze[i][j], j, sol)) {
				return true;
			}
			if (solveMazeUtil(maze, i, j + maze[i][j], sol)) {
				return true;
			}

			sol[i][j] = 0;
			return false;
		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RatInMazeMultipleJump rat = new RatInMazeMultipleJump();
		int maze[][] = { {1, 1, 0, 0},
		         		{3, 0, 0, 1},
		         		{0, 1, 0, 1},
		         		{0, 0, 0, 1} };
		rat.solveMaze(maze);
	}

}
