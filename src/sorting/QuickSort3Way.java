package sorting;

/**
 * Write code to do three-way partitioning similar to quick-sort
 * 
 * @author nishantchauhan
 *
 *
 *         Not stable O(lg(n)) extra space O(n2) time, but typically O(n�lg(n))
 *         time Adaptive: O(n) time when O(1) unique keys
 */

public class QuickSort3Way {

	static int i, j;

	public static void swap(int arr[], int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	// A utility function to print an array
	static void printarr(int a[], int n) {
		for (int i = 0; i < n; ++i)
			System.out.print(a[i]);

		System.out.print("\n");

	}

	/*
	 * This function partitions a[] in three parts a) a[l..i] contains all elements
	 * smaller than pivot b) a[i+1..j-1] contains all occurrences of pivot c)
	 * a[j..r] contains all elements greater than pivot
	 */

	// It uses Dutch National Flag Algorithm
	static void partition(int a[], int low, int high) {
		// To handle 2 elements
		if (high - low <= 1) {
			if (a[high] < a[low])
				swap(a, high, low);
			i = low;
			j = high;
			return;
		}

		int mid = low;
		int pivot = a[high];
		while (mid <= high) {
			if (a[mid] < pivot)
				swap(a, low++, mid++);
			else if (a[mid] == pivot)
				mid++;
			else if (a[mid] > pivot)
				swap(a, mid, high--);
		}

		// update i and j
		i = low - 1;
		j = mid; // or high+1
	}

	// 3-way partition based quick sort
	static void quicksort(int a[], int low, int high) {

		if (low < high) {
			// Note that i and j are passed as reference
			partition(a, low, high);

			// Recur two halves
			quicksort(a, low, i);
			quicksort(a, j, high);
		}
	}

	// Driver Code
	public static void main(String[] args) {

		int a[] = { 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4 };

		int size = a.length;

		// Function Call
		printarr(a, size);
		quicksort(a, 0, size - 1);
		printarr(a, size);
	}

}
