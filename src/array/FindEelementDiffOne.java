package array;

/**
 * Given an array with adjacent numbers differing by an absolute value of 1. A
 * number is given and we have to search it
 * 
 * @author nishantchauhan
 *
 *         less than O(n)
 */

public class FindEelementDiffOne {

	// Return the index of the
	// element to be searched.
	static int search(int arr[], int n, int x) {
		// Searching x in arr[0..n-1]
		int i = 0;
		while (i <= n - 1) {
			// Checking if element is found.
			if (arr[i] == x)
				return i;

			// Else jumping to abs(arr[i]-x).
			i += Math.abs(arr[i] - x);
		}

		return -1;
	}

	// Driver code
	public static void main(String[] args) {
		int arr[] = { 5, 4, 5, 6, 5, 4, 3, 2 };
		int n = arr.length;
		int x = 2;

		System.out.println(search(arr, n, x));
	}

}
