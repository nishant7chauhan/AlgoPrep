package array;

/**
 * Find if there exist a subset with given sum DP solution
 * 
 * @author nishantchauhan
 *
 *         * Time complexity - O(input.size * total_sum) Space complexity -
 *         O(input.size*total_sum)
 */

public class SubsetSum {

	static boolean T[][];

	public boolean subsetSum(int input[], int total) {

		T = new boolean[input.length + 1][total + 1];
		for (int i = 0; i <= input.length; i++) {
			T[i][0] = true;
		}

		for (int i = 1; i <= input.length; i++) {
			for (int j = 1; j <= total; j++) {
				if (j - input[i - 1] >= 0) {
					T[i][j] = T[i - 1][j] || T[i - 1][j - input[i - 1]];
				} else {
					T[i][j] = T[i - 1][j];
				}
			}
		}
		return T[input.length][total];

	}

	public void path(boolean[][] T, int i, int j, int[] input) {

		while (i > 0 && j > 0) {
			if (T[i][j] && T[i - 1][j]) {
				i--;
			} else {
				System.out.print(input[i-1] + " ");
				j = j - input[i-1];
				i--;
			}
		}

	}

	public static void main(String args[]) {
		SubsetSum ss = new SubsetSum();

		int arr1[] = { 2, 3, 7, 8 };
		System.out.print(ss.subsetSum(arr1, 11) + "\n");
		System.out.print("Elements are: ");
		ss.path(T, arr1.length, 11, arr1);

	}

}
