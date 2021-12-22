package array;

import java.util.HashSet;

/**
 * Find triplet sum
 * 
 * @author nishantchauhan O(n2), space for hashset, [user fix and 2 pointer
 *         technique after sorting to avoid extra space check triplet sum in
 *         BST]
 */

// will work for triplet sum = 0 also change sum value to 0

public class TripletSum {

	/**
	 * Now fix the first element one by one and find the other two elements for (int
	 * i = 0; i < arr_size - 2; i++) {
	 * 
	 * // To find the other two elements, start two index variables // from two
	 * corners of the array and move them toward each // other 
	 * l = i + 1; // index
	 * of the first element in the remaining elements 
	 * r = arr_size - 1; // index of  the last element 
	 * while (l < r) { if (A[i] + A[l] + A[r] == sum) {
	 * System.out.print("Triplet is " + A[i] + ", " + A[l] + ", " + A[r]); return
	 * true; } 
	 * else if (A[i] + A[l] + A[r] < sum) l++;
	 * else // A[i] + A[l] + A[r] > sum r--; } }
	 */

	// returns true if there is triplet
	// with sum equal to 'sum' present
	// in A[]. Also, prints the triplet
	static boolean find3Numbers(int A[], int arr_size, int sum) {
		// Fix the first element as A[i]
		for (int i = 0; i < arr_size - 2; i++) {

			// Find pair in subarray A[i+1..n-1]
			// with sum equal to sum - A[i]
			HashSet<Integer> s = new HashSet<Integer>();
			int curr_sum = sum - A[i];
			for (int j = i + 1; j < arr_size; j++) {
				if (s.contains(curr_sum - A[j])) {
					System.out.printf("Triplet is %d, %d, %d", A[i], A[j], curr_sum - A[j]);
					return true;
				}
				s.add(A[j]);
			}
		}

		// If we reach here, then no triplet was found
		return false;
	}

	/* Driver code */
	public static void main(String[] args) {
		int A[] = { 1, 4, 45, 6, 10, 8, -18 };
		int sum = 22;
		int arr_size = A.length;

		find3Numbers(A, arr_size, sum);
	}

}
