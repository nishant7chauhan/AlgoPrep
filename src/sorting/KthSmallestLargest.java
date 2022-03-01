package sorting;

/**
 * Kth minimun element in array [for kth largest element change heapify to opposite conditions and main for loop if condition] [check KthSmallestRowColSorted.java]
 * @author nishant.chauhan 
 * (n-k)log(k)
 */

public class KthSmallestLargest {

	public void sort(int arr[], int k) {
		int n = arr.length;

		// Build heap (rearrange array)
		for (int i = k / 2 - 1; i >= 0; i--)
			heapify(arr, k, i);

		// One by one extract an element from heap
		for (int i = n - 1; i >= k; i--) // O(n-k)
		{
			// Move current root to end
			if (arr[i] < arr[0]) {
				int temp = arr[0];
				arr[0] = arr[i];
				arr[i] = temp;

				// call max heapify on the reduced heap
				heapify(arr, k, 0);
			}
		}
	}

	// To heapify a subtree rooted with node i which is
	// an index in arr[]. n is size of heap
	void heapify(int arr[], int n, int i) //// log(n) our case it is log(k) as passing k as n
	{
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < n && arr[l] > arr[largest])
			largest = l;

		// If right child is larger than largest so far
		if (r < n && arr[r] > arr[largest])
			largest = r;

		// If largest is not root
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Recursively heapify the affected sub-tree
			heapify(arr, n, largest); // log(n)
		}
	}

	/* A utility function to print array of size n */
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// Driver program
	public static void main(String args[]) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };
		KthSmallestLargest ob = new KthSmallestLargest();
		ob.sort(arr, 2);

		System.out.println("kth smallest element is : " + arr[0]);
		// printArray(arr);
	}

}
