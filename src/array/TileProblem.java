package array;

/**
 * Count the number of ways to tile the floor of size n x m using 1 x m size
 * tiles
 * 
 * Given a ?2 x n? board and tiles of size ?2 x 1?, count the number of ways to
 * tile the given board using the 2 x 1 tiles[fibonaaci sequence]
 * 
 * @author nishantchauhan
 *
 *
 *         Time Complexity: O(n) Auxiliary Space: O(n)
 */

public class TileProblem {

	// function to count the total number of ways
	static int countWays(int n, int m) {
		// table to store values
		// of subproblems
		int count[] = new int[n + 1];
		count[0] = 0;

		// Fill the table upto value n
		int i;
		for (i = 1; i <= n; i++) {

			// recurrence relation
			if (i > m)
				count[i] = count[i - 1] + count[i - m];

			// base cases
			else if (i < m || i == 1)
				count[i] = 1;

			// i = = m
			else
				count[i] = 2;
		}

		// required number of ways
		return count[n];
	}

	// Driver program
	public static void main(String[] args) {
		int n = 7;
		int m = 4;
		System.out.println("Number of ways = " + countWays(n, m));
	}

}
