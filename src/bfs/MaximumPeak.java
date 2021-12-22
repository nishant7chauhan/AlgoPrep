package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Given a 2D boolean array where true represents water and false represents
 * land, generate a grid with highest possible peak. Rules are:
 * 
 * the height of any water cell is 0. the height of any land cell cannot differ
 * for more than one from any of the neighbouring (sharing one edge) cells.
 * 
 * @author nishant.chauhan
 *
 *
 * O(m*n)
 */

public class MaximumPeak {
	static int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

	private static int maxHeight(int[][] landscape) {
		final int m = landscape.length, n = landscape[0].length, heights[][] = new int[m][n];
		boolean[][] visited = new boolean[m][n];
		final Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (landscape[i][j] == 1) { // sea
					heights[i][j] = 0;
					visited[i][j] = true;
					q.offer(new int[] { i, j, heights[i][j] }); // could define i,j,k also k = value
				}
			}
		}
		int h = 0; // define 0 if want to get height only;
		while (!q.isEmpty()) {
			for (int size = q.size(); size > 0; size--) {
				int[] coord = q.poll();
				for (int[] dir : dirs) {
					int r = coord[0] + dir[0], c = coord[1] + dir[1];
					if (withinGrid(m, n, r, c) && !visited[r][c]) {
						q.offer(new int[] { r, c, heights[coord[0]][coord[1]] + 1 });
						visited[r][c] = true;
						heights[r][c] = heights[coord[0]][coord[1]] + 1; // k+1; // Answer 1;
					}
				}
			}
			h++; // Answer 2;
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				System.out.print(heights[i][j] + " ");
			}
			System.out.print("\n");
		}

		return h - 1;

	}

	private static boolean withinGrid(int m, int n, int x, int y) {
		// TODO Auto-generated method stub

		return (x >= 0 && x < m && y >= 0 && y < n);
	}

	public static void main(String[] args) {

		int[][] arr = new int[][] { { 0, 0, 1 }, { 1, 0, 0 }, { 0, 0, 0 } };

		System.out.print(maxHeight(arr));

	}
}
