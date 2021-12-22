package array;

/**
 * Get the local maxima or minima in array
 * 
 * @author nishantchauhan O(log n)
 */

public class LocalMinima {

	// A binary search based function that returns
	// index of a local minima.
	public static int localMinUtil(int[] arr, int low, int high, int n) {

		// Find index of middle element
		while (low <= high) {

			int mid = (low + high) / 2;

			// Compare middle element with its neighbours
			// (if neighbours exist)
			if (mid == 0 || arr[mid] < arr[mid - 1] && mid == n - 1 || // opposite condition for local maxima
					arr[mid] < arr[mid + 1])
				return mid;

			// If middle element is not minima and its left
			// neighbour is smaller than it, then left half
			// must have a local minima.
			else if (mid > 0 && arr[mid] > arr[mid - 1])
				high = mid - 1;

			// If middle element is not minima and its right
			// neighbour is smaller than it, then right half
			// must have a local minima.
			else
				low = mid + 1;
		}
		return -1;
	}

	public static void main(String[] args) {

		int arr[] = { 4, 3, 1, 14, 16, 40 };
		int n = arr.length;
		System.out.println("Index of a local minima is " + localMinUtil(arr, 0, n - 1, n));

	}

}
