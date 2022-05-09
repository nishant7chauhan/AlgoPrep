package array;
public class MoveZeroToEnd {

	// function to move all zeroes at
	// the end of array
	static void moveZerosToEnd(int arr[], int n) {

		// Count of non-zero elements
		int index = 0;
		int temp;

		// Traverse the array. If arr[i] is
		// non-zero, then swap the element at
		// index 'count' with the element at
		// index 'i'
		for (int i = 0; i < n; i++) {
			if ((arr[i] != 0)) {
				temp = arr[index];
				arr[index++] = arr[i];
				arr[i] = temp;
			}
		}
	}

	// function to print the array elements
	static void printArray(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	// Driver program to test above
	public static void main(String args[]) {
		int arr[] = { 0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9 };
		int n = arr.length;

		System.out.print("Original array: ");
		printArray(arr, n);

		moveZerosToEnd(arr, n);

		System.out.print("\nModified array: ");
		printArray(arr, n);
	}
}
