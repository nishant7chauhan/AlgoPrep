package array;

import java.util.Deque;
import java.util.LinkedList;


/**
 * Print min & max (both) of all sub array of size k
 * @author nishantchauhan
 * https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/ for explanations
 * O(n) , O(k)  
 */

public class MaxKSizeArray { 

	public void maxElementOfKSizeSubArray(int[] arr, int k) {
		if (arr.length == 0 || k <= 0 || k > arr.length) {
			return;
		}

		Deque<Integer> queue = new LinkedList<>();    // opposite condition for minimum case`	
		int i;
		for (i = 0; i < k; i++) {
			while (!queue.isEmpty() && arr[i] >= arr[queue.peekLast()]) {
				queue.removeLast();
			}

			queue.addLast(i);
		}

		for (; i < arr.length; i++) {
			System.out.print(arr[queue.peek()] + " ");

			while (!queue.isEmpty() && i - k >= queue.peek()) {
				queue.removeFirst();
			}

			while (!queue.isEmpty() && arr[i] >= arr[queue.peekLast()]) {
				queue.removeLast();
			}

			queue.addLast(i);
		}

		System.out.print(arr[queue.peek()]);
	}

	public static void main(String[] args) {

		MaxKSizeArray a = new MaxKSizeArray();

		int arr[] = { 2, 5, 4, 3, 1, 7 };
		int k = 3;

		a.maxElementOfKSizeSubArray(arr, k);

	}

}
