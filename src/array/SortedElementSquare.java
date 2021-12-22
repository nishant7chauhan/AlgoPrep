package array;

/**
 * 65.Given an array of integers(pos/neg) in sorted order, return an array of
 * elements square in sorted order.
 * 
 * @author nishant.chauhan
 * 
 *         O(n),O(n)
 */

public class SortedElementSquare {

	private static void sortSquares(int[] arr) {
		// TODO Auto-generated method stub
		int n = arr.length;
		int left = 0;
		int right = n - 1;
		int result[] = new int[n];

		for (int i = n - 1; i >= 0; i--) {
			if (Math.abs(arr[left]) > arr[right]) {

				result[i] = arr[left] * arr[left];
				left++;
			} else {
				result[i] = arr[right] * arr[right];
				right--;
			}
			
		}
		for (int k = 0; k < n; k++)
			arr[k] = result[k];

	}

	// Driver code
	public static void main(String[] args) {
		int arr[] = { -6, -3, -1, 2, 4, 5 };
		int n = arr.length;

		System.out.println("Before sort ");
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");

		sortSquares(arr);
		System.out.println("");
		System.out.println("After Sort ");
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

}
