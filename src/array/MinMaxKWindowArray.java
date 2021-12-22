package array;

import java.util.TreeMap;

/**
 * Print min & max (both) of all subarray of size k.The reference link is just for min or max. Here we need both min and max in one program.
 * 
 * @author nishantchauhan
 *
 *
 *
 * (n-k)log(k) ,  O(k)
 */



public class MinMaxKWindowArray {

	
	static void minmax(int arr[], int k) {
		// Creates an empty hashMap hM
		TreeMap<Integer, Integer> hm = new TreeMap<Integer, Integer>();

		// Traverse the first window and store count
		// of every element in hash map
		for (int i = 0; i < k; i++)
			hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);

		// Print count of first window
		System.out.println(hm.firstKey() + "," + hm.lastKey());

		// Traverse through the remaining array
		for (int i = k; i < arr.length; i++) {

			// Remove first element of previous window
			// If there was only one occurrence
			if (hm.get(arr[i - k]) == 1) {
				hm.remove(arr[i - k]);
			}

			else // reduce count of the removed element
				hm.put(arr[i - k], hm.get(arr[i - k]) - 1);

			// Add new element of current window
			// If this element appears first time,
			// set its count as 1,
			hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);

			// Print count of current window
			System.out.println(hm.firstKey() + "," + hm.lastKey());
		}
	}

	// Driver method
	public static void main(String arg[]) {
		int arr[] = { 1, 2, 1, 3, 4, 2, 3 };
		int k = 4;
		minmax(arr, k);
	}

	
}
