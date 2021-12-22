package sorting;

import java.util.Random;

public class QuickSortRandomPartitionAlgo {

	// This Function helps in calculating
	// random numbers between low(inclusive)
	// and high(inclusive)
	static void random(int arr[], int low, int high) {

		Random rand = new Random();
		int pivot = rand.nextInt(high - low) + low;

		int temp = arr[pivot];
		arr[pivot] = arr[high];
		arr[high] = temp;
	}

	/*
	 * This function takes last element as pivot, places the pivot element at its
	 * correct position in sorted array, and places all smaller (smaller than pivot)
	 * to left of pivot and all greater elements to right of pivot
	 */
	static int partition(int arr[], int start, int end) {
		// pivot is choosen randomly
		random(arr, start, end);
		
		int pivot = arr[end];

		int partitionIndex = start;

		for (int i = start; i < end; i++) {
			if (arr[i] <= pivot) {
				int temp = arr[i];
				arr[i] = arr[partitionIndex];
				arr[partitionIndex] = temp;
				partitionIndex++;
			}
		}
		int tempPivot = arr[end];
		arr[end] = arr[partitionIndex];
		arr[partitionIndex] = tempPivot;

		return partitionIndex;
	}

	/*
	 * The main function that implements QuickSort() arr[] --> Array to be sorted,
	 * low --> Starting index, high --> Ending index
	 */
	static void sort(int arr[], int low, int high) {
		if (low < high) {
			/*
			 * pi is partitioning index, arr[pi] is now at right place
			 */
			int pi = partition(arr, low, high);

			// Recursively sort elements before
			// partition and after partition
			sort(arr, low, pi - 1);
			sort(arr, pi + 1, high);
		}
	}

	/* A utility function to print array of size n */
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// Driver Code
	public static void main(String args[]) {
		int arr[] = { 10, 7, 8, 9, 1, 5 };
		int n = arr.length;

		sort(arr, 0, n - 1);

		System.out.println("Sorted array");
		printArray(arr);
	}

}
