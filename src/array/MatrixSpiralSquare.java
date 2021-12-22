package array;

/**
 * print matrix in spiral form
 * @author nishantchauhan
 * O(row*col)
 */


public class MatrixSpiralSquare {

	private static void printSpiral(int row, int col, int[][] mat) {
		// TODO Auto-generated method stub

		for (int i = row - 1, j = 0; i >= 0; i--, j++) {

			for (int k = j; k < i; k++)
				System.out.print(mat[j][k] + " ");

			for (int k = j; k < i; k++)
				System.out.print(mat[k][i] + " ");

			for (int k = i; k > j; k--)
				System.out.print(mat[i][k] + " ");

			for (int k = i; k > j; k--)
				System.out.print(mat[k][j] + " ");
		}

		int middle = (row-1)/2;
		if(row%2 == 1) System.out.print(mat[middle][middle] + " ");
	}

	public static void main(String[] args) {

		int mat[][] = { { 1, 2, 3, 4 }, { 6, 7, 8, 9, }, { 11, 12, 13, 14, }, { 16, 17, 18, 19, } };

		printSpiral(mat.length, mat[0].length, mat);

	}

}
