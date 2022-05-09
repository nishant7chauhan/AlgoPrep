package array;

import java.util.Arrays;

/**
 * 
 * @author nishantchauhan
 * 
 * O(n3)
 *
 */



public class QuadrupleSum {

	static boolean find4Numbers(int A[], int arr_size, int sum) {

		for (int i = 0; i < arr_size - 3; i++) {

			for (int j = i + 1; j < arr_size - 2; j++) {

				// To find the other two elements, start two index variables
				// from two corners of the array and move them toward each other
				int l = j + 1; // index of the first element in the remaining elements
				int r = arr_size - 1; // index of the last element
				while (l < r) {
					if (A[i] + A[j] + A[l] + A[r] == sum) {
						System.out.print("4 element is " + A[i] + ", " + A[j] + ", " + A[l] + ", " + A[r]);
						return true;
					}

					else if (A[i] + A[j] + A[l] + A[r] < sum)
						l++;

					else
						r--; // (A[i] + A[j] +A[l] + A[r] > sum)
				}

			}

		}

		return false;
	}

	public static void main(String[] args) {
		int A[] = { 1, 4, 45, 2, 10, 8, -20 };
		int sum = 0;
		int arr_size = A.length;
		Arrays.sort(A);

		find4Numbers(A, arr_size, sum);

	}

}
