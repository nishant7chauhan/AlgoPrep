package array;

import java.util.Arrays;

/**
 * 
 * @author nishantchauhan
 *
 * O(n2)
 */


public class SumTripletClosetToZero {

	// Prints the pair with sum cloest to x
	static void printClosest(int arr[], int n, int x) {
		int res_l = 0, res_r = 0, res_i = 0; // To store indexes of result pair

		// Initialize left and right indexes and difference between
		// pair sum and x
		int min = Integer.MAX_VALUE;

		// While there are elements between l and r

		for (int i = 0; i < arr.length - 2; i++) {

			int l = i + 1, r = n - 1;

			while (r > l) {
				int sum = arr[i] + arr[l] + arr[r];
				int diff = Math.abs(sum - x);
				// Check if this pair is closer than the closest pair so far
				if (diff < min) {
					res_i = i;
					res_l = l;
					res_r = r;
					min = diff;
				}

				// If this pair has more sum, move to smaller values.
				if (arr[i] + arr[l] + arr[r] > x)
					r--;
				else // Move to larger values
					l++;
			}

		}

		System.out.println(" The closest pair is " + arr[res_i] + ","  + arr[res_l] + " and " + arr[res_r]);
	}

	// Driver program to test above function
	public static void main(String[] args) {
		int arr[] = { 10, 22, 28, 29, 15, 40 }, x = 54;
		int n = arr.length;
		Arrays.sort(arr);
		printClosest(arr, n, x);
	}

}
