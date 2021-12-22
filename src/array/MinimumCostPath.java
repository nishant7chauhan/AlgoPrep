package array;
/**
 * Java program for Dynamic Programming implementation of Min Cost Path problem
 * 
 * @author nishantchauhan O(MN),O(MN) , we can improve space if path not
 *         required by using same array
 */

public class MinimumCostPath {
	static int tc[][];
	static int cost[][];

	/* A utility function that returns minimum of 3 integers */
	private static int min(int x, int y, int z) {
		return ((x < y) ? (x < z ? x : z) : (y < z ? y : z));
	}

	private static int minCost(int cost[][], int m, int n) {
		int i, j;
		tc = new int[m][n];

		tc[0][0] = cost[0][0];

		/* Initialize first column of total cost(tc) array */
		for (i = 1; i < m; i++)
			tc[i][0] = tc[i - 1][0] + cost[i][0];

		/* Initialize first row of tc array */
		for (j = 1; j < n; j++)
			tc[0][j] = tc[0][j - 1] + cost[0][j];

		/* Construct rest of the tc array */
		for (i = 1; i < m; i++)
			for (j = 1; j < n; j++)
				tc[i][j] = min(tc[i - 1][j - 1], tc[i - 1][j], tc[i][j - 1]) + cost[i][j];

		return tc[m - 1][n - 1];
	}

	private static void path(int m, int n) { // TODO Auto-generated
		
		System.out.print(cost[m][n] + "<--");
		while (m > 0 && n > 0) {
			if (tc[m - 1][n] < tc[m][n - 1]) {
				if (tc[m - 1][n] < tc[m - 1][n - 1]) {
					System.out.print(cost[m - 1][n]+ "<--");
					m--;
				} else {
					System.out.print(cost[m - 1][n - 1]+ "<--");
					m--;
					n--;

				}
			} else {
				if (tc[m][n - 1] < tc[m - 1][n - 1]) {
					System.out.print(cost[m][n - 1]+ "<--");
					n--;
				} else {
					System.out.print(cost[m - 1][n - 1]+ "<--");
					m--;
					n--;
				}
			}
		}
		System.out.print(cost[0][0]);
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		cost = new int[][]{ { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
		System.out.println(minCost(cost, 3, 3));
		path(2, 2);

	}
}
