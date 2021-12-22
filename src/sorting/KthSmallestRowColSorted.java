package sorting;

/**
 * Kth smallest element in a row-wise and column-wise sorted 2D array
 * 
 * @author nishantchauhan Building a min-heap which takes O(n) time.Heapify k
 *         times which takes O(k Logn) time.
 */

public class KthSmallestRowColSorted {

	// A structure to store entry of heap.
	// The entry contains value from 2D array,
	// row and column numbers of the value
	static class HeapNode {

		// Value to be stored
		int val;

		// Row number of value in 2D array
		int r;

		// Column number of value in 2D array
		int c;

		HeapNode(int val, int r, int c) {
			this.val = val;
			this.r = r;
			this.c = c;

		}
	}

	// A utility function to swap two HeapNode items.
	static void swap(int i, int min, HeapNode[] arr) {
		HeapNode temp = arr[i];
		arr[i] = arr[min];
		arr[min] = temp;
	}

	// A utility function to minheapify the node
	// harr[i] of a heap stored in harr[]
	static void minHeapify(HeapNode harr[], int i, int heap_size) {
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int min = i;

		if (l < heap_size && harr[l].val < harr[i].val) {
			min = l;
		}
		if (r < heap_size && harr[r].val < harr[i].val) {
			min = r;
		}

		if (min != i) {
			swap(i, min, harr);
			minHeapify(harr, min, heap_size);
		}
	}

	// A utility function to convert
	// harr[] to a max heap
	static void buildHeap(HeapNode harr[], int n) {
		int i = (n - 1) / 2;
		while (i >= 0) {
			minHeapify(harr, i, n);
			i--;
		}
	}

	// This function returns kth smallest
	// element in a 2D array mat[][]
	public static int kthSmallest(int[][] mat, int n, int k) {

		// k must be greater than 0 and
		// smaller than n*n
		if (k <= 0 || k > n * n) {
			return Integer.MAX_VALUE;
		}

		// Create a min heap of elements
		// from first row of 2D array
		HeapNode harr[] = new HeapNode[n];

		for (int i = 0; i < n; i++) {
			harr[i] = new HeapNode(mat[0][i], 0, i);
		}
		buildHeap(harr, n);

		HeapNode hr = new HeapNode(0, 0, 0);

		for (int i = 0; i < k; i++) {

			// Get current heap root
			hr = harr[0];

			// Get next value from column of root's
			// value. If the value stored at root was
			// last value in its column, then assign
			// INFINITE as next value
			int nextVal = hr.r < n - 1 ? mat[hr.r + 1][hr.c] : Integer.MAX_VALUE;

			// Update heap root with next value
			harr[0] = new HeapNode(nextVal, hr.r + 1, hr.c);

			// Heapify root
			minHeapify(harr, 0, n);
		}

		// Return the value at last extracted root
		return hr.val;
	}

	// Driver code
	public static void main(String args[]) {
		int mat[][] = { { 10, 20, 30, 40 }, 
						{ 15, 25, 35, 45 }, 
						{ 25, 29, 37, 48 }, 
						{ 32, 33, 39, 50 } 
					};

		int res = kthSmallest(mat, 4, 2);

		System.out.print("kth smallest element is " + res);
	}
}
