package array;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Sort array when it is away at most by K distance.
 * 
 * @author nishantchauhan
 * 
 *         The Min Heap based method takes O(nLogk) time and uses O(k) auxiliary
 *         space.
 */

public class KSortedArray {

	private static void kSort(int[] arr, int n, int k) {

		// min heap
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

		// add first k + 1 items to the min heap
		for (int i = 0; i < k + 1; i++) {
			priorityQueue.add(arr[i]);
		}

		int index = 0;
		for (int i = k + 1; i < n; i++) {
			arr[index++] = priorityQueue.poll();
			priorityQueue.add(arr[i]);
		}

		Iterator<Integer> itr = priorityQueue.iterator();

		while (itr.hasNext()) {
			arr[index++] = priorityQueue.poll();
		}

	}

	// A utility function to print the array
	private static void printArray(int[] arr, int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	// Driver Code
	public static void main(String[] args) {
		int k = 3;
		int arr[] = { 2, 6, 3, 12, 56, 8 };
		int n = arr.length;
		kSort(arr, n, k);
		System.out.println("Following is sorted array");
		printArray(arr, n);
	}

}
