package array;

/**
 * 22.Given an array and an operation -> foo(index, value), the value can be
 * either 1 or -1, if foo(index, value) is called, it will add ‘value’ to all
 * elements from index till end of the array, find minimum number of operation
 * to make all array elements 0.
 * https://www.geeksforgeeks.org/minimum-no-of-operations-required-to-make-all-array-elements-zero/
 * 
 * @author nishant.chauhan
 * 
 * O(n)
 */

public class MinimumOperationToMake0Array {

	private static int minOperation(int arr[], int n) {
		// TODO Auto-generated method stub
		int counter = 0;

		for (int i = 0; i < n - 1; i++) {

			if (arr[i] == 1 && arr[i + 1] == 0) {
				counter++;
			}
		}
		if (arr[n - 1] == 1)
			counter++;

		return counter;
	}

	public static void main(String[] args) {

		int arr[] = { 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1 };
		int n = arr.length;

		System.out.println("Minimum changes required to make all array element 0 is: " + minOperation(arr, n));
	}
}
