package array;

public class SearchStrictlySortedRowColWise {

	private static boolean searchElement(int[][] mat, int target) {

		if (mat.length == 0)
			return false;

		int n = mat.length;
		int m = mat[0].length;

		int low = 0;
		int high = (n * m) - 1;

		while (low <= high) {

			int mid = (high + low) / 2;

			if (mat[mid / m][mid % m] == target)
				return true;
			if (mat[mid / m][mid % m] < target)
				low = mid + 1;
			else
				high = mid - 1;

		}
		return false;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int mat[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		System.out.print(searchElement(mat, 11));
	}

}
