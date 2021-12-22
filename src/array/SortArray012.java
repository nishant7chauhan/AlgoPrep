package array;

/**
 * Sort an array of 0s, 1s and 2s (Dutch national flag problem.)
 * 
 * @author nishantchauhan
 *
 *
 *         Time Complexity: O(n). Only two traversals of the array is needed.
 *         Space Complexity: O(1). As no extra space is required.
 */

public class SortArray012 {

	private static void sortArray(int[] arr) {
		// TODO Auto-generated method stub
		int i = 0, j = 0;
		int k = arr.length - 1;

		while (j <= k) {

			if (arr[j] == 0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j++;
			} else if (arr[j] == 1) {
				j++;
			} else {
				int temp = arr[k];
				arr[k] = arr[j];
				arr[j] = temp;
				k--;
			}
		}

		for (int l = 0; l < arr.length; l++) {
			System.out.print(arr[l]);
		}

		System.out.print("\n " + i + " : " + k);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] input = { 0, 1, 1, 1, 1, 1, 0, 0, 0, 2, 2, 1, 2, 0, 0, 2, 0, 1, 1, 2, 2 };
		sortArray(input);
	}

}
