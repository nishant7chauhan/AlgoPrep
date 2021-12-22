package heap;

/**
 * Given k sorted arrays, you need to select one element from each array such
 * that the difference of maximum element and minimum element of the selected
 * elements is minimum. Example for k = 3 1 13 27 30 16 20 29 2 3 14 18 19 22 25
 * 28
 * 
 * @author nishantchauhan
 * 
 *         Time complexity : O(n * k *log k). To find the maximum and minimum in
 *         an Min Heap of length k the time required is O(log k), and to
 *         traverse all the k arrays of length n (in worst case), the time
 *         complexity is O(n*k), then the total time complexity is O(n * k *log
 *         k). Space complexity: O(k). The priority queue will store k elements
 *         so the space complexity os O(k)
 *
 */

public class MinRange {

	// A min heap node
	static class Node {
		int ele; // The element to be stored
		int i; // index of the list from which the element is taken
		int j; // index of the next element to be picked from list

		Node(int a, int b, int c) {
			this.ele = a;
			this.i = b;
			this.j = c;
		}
	}

	static class MinHeap {
		Node[] harr; // array of elements in heap
		int size; // size of min heap

		MinHeap(Node[] arr, int size) { // Constructor: creates a min heap of given size
			this.harr = arr;
			this.size = size;
			int i = (size - 1) / 2;
			while (i >= 0) {
				MinHeapify(i);
				i--;
			}
		}

		// to get index of left child
		// of node at index i
		int left(int i) {
			return 2 * i + 1;
		}

		// to get index of right child
		// of node at index i
		int right(int i) {
			return 2 * i + 2;
		}

		// to heapify a subtree with root at given index
		void MinHeapify(int i) {
			int l = left(i);
			int r = right(i);
			int small = i;
			if (l < size && harr[l].ele < harr[i].ele)
				small = l;
			if (r < size && harr[r].ele < harr[small].ele)
				small = r;
			if (small != i) {
				swap(small, i);
				MinHeapify(small);
			}
		}

		void swap(int i, int j) {
			Node temp = harr[i];
			harr[i] = harr[j];
			harr[j] = temp;
		}

		// to get the root
		Node getMin() {
			return harr[0];
		}

		// to replace root with new node x
		// and heapify() new root
		void replaceMin(Node x) {
			harr[0] = x;
			MinHeapify(0);
		}
	}

	// This function takes an k sorted lists
	// in the form of 2D array as an argument.
	// It finds out smallest range that includes
	// elements from each of the k lists.
	static void findSmallestRange(int[][] arr, int k) {
		int range = Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int start = -1, end = -1;

		int n = arr[0].length;
		// Create a min heap with k heap nodes.Every heap node has first element of an
		// list
		Node[] arr1 = new Node[k];
		for (int i = 0; i < k; i++) {
			Node node = new Node(arr[i][0], i, 1);
			arr1[i] = node;
			max = Math.max(max, node.ele); // store max element
		}
		// Create the heap
		MinHeap mh = new MinHeap(arr1, k); // k because we are taking first element
		// Now one by one get the minimum element from min heap and replace it with next
		// element of its list
		while (true) {
			Node root = mh.getMin(); // Get the minimum element and store it in output
			min = root.ele; // update min

			if (range > max - min + 1) { // update range
				range = max - min + 1;
				start = min;
				end = max;
			}

			// Find the next element that will
			// replace current root of heap.
			// The next element belongs to same
			// list as the current root.
			if (root.j < n) {
				root.ele = arr[root.i][root.j];
				root.j++;

				// update max element
				if (root.ele > max)
					max = root.ele;
			}
			// break if we have reached
			// end of any list
			else
				break;

			// Replace root with next element of list
			mh.replaceMin(root);
		}
		System.out.print("The smallest range is [" + start + " " + end + "]");
	}

	// Driver Code
	public static void main(String[] args) {
		int arr[][] = { { 4, 7, 9, 12, 15 }, { 0, 8, 10, 14, 20 }, { 6, 12, 16, 30, 50 } };

		int k = arr.length;

		findSmallestRange(arr, k);
	}

}
