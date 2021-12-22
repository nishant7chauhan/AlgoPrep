package array;

/**
 * 
 * Given a array int a[]={2,5,1,9,3,7,2,8,9,3} and the no. of swap operations.We
 * are allowed to do swap operations.
 * Maximum number formed from array with K number of adjacent swaps allowed
 * @author nishantchauhan
 *
 *
 *
 *         O(N2) , we can use sorted hasmap to store k sorted elements and index
 *         ,thus complexity comes down to NlogN with O(k) space
 */

public class MaxNumKAdjecentSwap {

	// Function to print the
	// elements of the array
	static void print(int arr[], int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// Exchange array elements one by
	// one from right to left side
	// starting from the current position
	// and ending at the target position
	static void swapMax(int[] arr, int target_position, int current_position) {
		int aux = 0;
		for (int i = current_position; i > target_position; i--) {
			aux = arr[i - 1];
			arr[i - 1] = arr[i];
			arr[i] = aux;
		}
	}

	// Function to return the
	// maximum number array
	static void maximizeArray(int[] arr, int length, int swaps) {
		// Base condition
		if (swaps == 0)
			return;

		// Start from the first index
		for (int i = 0; i < length; i++) {
			int max_index = 0, max = Integer.MIN_VALUE;

			// Search for the next K elements
			int limit = (swaps + i) > length ? length : swaps + i;

			// Find index of the maximum
			// element in next K elements
			for (int j = i; j <= limit; j++) {
				if (arr[j] > max) {
					max = arr[j];
					max_index = j;
				}
			}

			// Update the value of
			// number of swaps
			swaps -= (max_index - i);

			// Update the array elements by
			// swapping adjacent elements
			swapMax(arr, i, max_index);

			if (swaps == 0)
				break;
		}
	}

	// Driver code
	public static void main(String[] args) {
		int arr[] = { 1, 2, 9, 8, 1, 4, 9, 9, 9 };
		int length = arr.length;
		int swaps = 4;
		maximizeArray(arr, length, swaps);

		print(arr, length);
	}

}
