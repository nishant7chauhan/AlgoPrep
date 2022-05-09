package msiq;

/*******
 * Search an element in a sorted rotated array in a single pass./ Find pivot in
 * sorted rotated array (2)
 *******/
//O(logn) 
//O(1)

public class FindElementSinglePass {

	static int search(int arr[], int l, int h, int key) {

		// check base conditions check FindPivotInSortedRotatedArray
		// check base conditions check FindPivotInSortedRotatedArray

		while (l <= h) {

			int mid = (l + h) / 2;
			if (arr[mid] == key)
				return mid;

			/* If arr[l...mid] first subarray is sorted */
			if (arr[l] <= arr[mid]) {
				/*
				 * As this subarray is sorted, we can quickly check if key lies in half or other
				 * half
				 */
				if (key >= arr[l] && key <= arr[mid])
					h = mid - 1;
				/*
				 * If key not lies in first half subarray, Divide other half into two subarrays,
				 * such that we can quickly check if key lies in other half
				 */
				else
					l = mid + 1;
			}

			/*
			 * If arr[l..mid] first subarray is not sorted, then arr[mid... h] must be
			 * sorted subarry
			 */
			else if (key >= arr[mid] && key <= arr[h]) // equal to else{ if(){}else{}}
				l = mid + 1;

			else
				h = mid - 1;

		}
		return -1;
	}

	// main function
	public static void main(String args[]) {
		int arr[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		int n = arr.length;
		int key = 4;
		int i = search(arr, 0, n - 1, key);
		if (i != -1)
			System.out.println("Index: " + i);
		else
			System.out.println("Key not found");
	}

}
