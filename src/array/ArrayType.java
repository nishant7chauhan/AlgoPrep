package array;

/**
 * There are 4 patterns of arrays: monotonic increasing, monotonic decreasing, increasing then decreasing, decreasing then increasing. Given an array, identify accordingly.
 * 
 * @author  nishantchauhan
 * 
 * 
 *
 */

public class ArrayType {

	// Function to check the type of the array
	public static void checkType(int arr[], int n) {

		// If the first two and the last two elements
		// of the array are in increasing order
		if (arr[0] <= arr[1] && arr[n - 2] <= arr[n - 1])
			System.out.println("Increasing");

		// If the first two and the last two elements
		// of the array are in decreasing order
		else if (arr[0] >= arr[1] && arr[n - 2] >= arr[n - 1])
			System.out.println("Decreasing");

		// If the first two elements of the array are in
		// increasing order and the last two elements
		// of the array are in decreasing order
		else if (arr[0] <= arr[1] && arr[n - 2] >= arr[n - 1])
			System.out.println("Increasing then decreasing");

		// If the first two elements of the array are in
		// decreasing order and the last two elements
		// of the array are in increasing order
		else
			System.out.println("Decreasing then increasing");
	}

	// Driver code
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4 };

		int n = arr.length;

		checkType(arr, n);
	}

}
