package bs;

//Find peak point in an array
public class PeakElementInArray {

	static int findPeakUtil(int arr[], int low, int high, int n) {
		// Find index of middle element
		int mid = (high + low) / 2; /* (low + high)/2 */

		// Compare middle element with its neighbours (if neighbours
		// exist)
		while (low <= high) {

			if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == n - 1 || arr[mid + 1] <= arr[mid]))
				return mid;

			// If middle element is not peak and its left neighbor is
			// greater than it,then left half must have a peak element
			else if (mid > 0 && arr[mid - 1] > arr[mid])
				high = mid - 1;

			// If middle element is not peak and its right neighbor
			// is greater than it, then right half must have a peak
			// element
			else
				low = mid + 1;
		}

		return 0;
	}

	// A wrapper over recursive function findPeakUtil()
	static int findPeak(int arr[], int n) {
		return findPeakUtil(arr, 0, n - 1, n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 3, 20, 4, 1, 0 };
		int n = arr.length;
		System.out.println("Index of a peak point is " + findPeak(arr, n));

	}

}
