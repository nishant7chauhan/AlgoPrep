package array;

/**
 * print matrix in zigzag motion
 * @author nishantchauhan
 * O(row*col)
 */

public class MatrixZigZag {

	// Method to print matrix in zig-zag form
	static void printZigZag(int row, int col, int a[][]) {
		int evenRow = 0; // starts from the first row
		int oddRow = 1; // starts from the next row

		while (evenRow < row) {
			for (int i = 0; i < col; i++) {
				// evenRow will be printed in the same direction
				System.out.print(a[evenRow][i] + " ");
			}

			// Skipping next row so as to get the next evenRow
			evenRow = evenRow + 2;

			if (oddRow < row) {
				for (int i = col - 1; i >= 0; i--) {
					// oddRow will be printed in the opposite direction
					System.out.print(a[oddRow][i] + " ");
				}
			}

			// Skipping next row so as to get the next oddRow
			oddRow = oddRow + 2;
		}
	}

	public static void main(String[] args) {
		
		int mat[][] = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 } };

		printZigZag(mat.length, mat[0].length, mat);

	}
}
