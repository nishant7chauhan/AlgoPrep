package linklist;

/**
 * Merge K sorted linked lists.Sort linked list(Used merge sort)
 * 
 * @author nishant.chauhan (NKlogK) , O(1) // check complexity below No need to
 *         check K sorted array as this is divide and conquer linklist size is
 *         adjustable which is not in the case of array
 * 
 *         After the first cycle, K/2 lists are left each of size 2*N. After the
 *         second cycle, K/4 lists are left each of size 4*N and so on.
 */

public class MergeKSortedLinkList {

	/*
	 * It merges the k sorted linked lists
	 */
	public Node mergeKSortedLists(Node[] arr, int last) {
		while (last != 0) { // log(k) times
			int i = 0;
			int j = last;

			while (i < j) { // K/2 times
				arr[i] = mergeTwoSortedLinkedList(arr[i], arr[j]);

				i++;
				j--;

				if (i >= j) { // middle element https://www.youtube.com/watch?v=65KAkew7yHU
					last = j;
					break;
				}
			}
		}

		return arr[0];
	}

	/*
	 * It merges two sorted linked list
	 */
	public Node mergeTwoSortedLinkedList(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			return null;
		}

		if (node1 == null || node2 == null) {
			return node1 != null ? node1 : node2;
		}

		return mergeTwoList(node1, node2);
	}

	/*
	 * Helper function to merge two sorted linked list
	 */
	public Node mergeTwoList(Node first, Node second) { // N times
		if (first == null && second == null) {
			return null;
		}

		Node tmp = new Node();
		Node finalList = tmp;
		while (first != null && second != null) {
			if (first.data < second.data) {
				tmp.next = first;
				first = first.next;
			} else {
				tmp.next = second;
				second = second.next;
			}

			tmp = tmp.next;
		}

		tmp.next = (first != null) ? first : second;

		return finalList.next;
	}

	/*
	 * It'll print the complete linked list
	 */
	public void printList(Node node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data + " ");
		printList(node.next);
	}

	public static void main(String[] args) {
		MergeKSortedLinkList a = new MergeKSortedLinkList();

		Node arr[] = new Node[5];

		arr[0] = new Node(1);
		arr[0].next = new Node(3);
		arr[0].next.next = new Node(5);
		arr[0].next.next.next = new Node(7);

		arr[1] = new Node(2);
		arr[1].next = new Node(4);
		arr[1].next.next = new Node(6);
		arr[1].next.next.next = new Node(8);

		arr[2] = new Node(0);
		arr[2].next = new Node(9);
		arr[2].next.next = new Node(10);
		arr[2].next.next.next = new Node(11);

		arr[3] = new Node(12);
		arr[3].next = new Node(14);
		arr[3].next.next = new Node(16);
		arr[3].next.next.next = new Node(18);

		arr[4] = new Node(13);
		arr[4].next = new Node(19);
		arr[4].next.next = new Node(20);
		arr[4].next.next.next = new Node(21);

		Node mergedList = a.mergeKSortedLists(arr, arr.length - 1);
		a.printList(mergedList);

	}

}
