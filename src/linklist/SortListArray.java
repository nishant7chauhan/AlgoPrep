package linklist;

import java.util.HashMap;

/**
 * 1.Given array and a Linked List where elements will be from the array but can
 * also be duplicated.[done] Sort the linked list in the order, elements are
 * appearing in the array. O(n) complexity was expected. Complete running code
 * on paper was expected. All boundary condition checks were expected. Input :
 * arr = {5, 1, 3, 2, 8} list = 3 -> 2 -> 5 -> 8 -> 5 -> 2 -> 1 -> X
 * 
 * 
 * @author nishantchauhan
 * 
 *         O(n) ,O(n)
 *
 */

public class SortListArray {

	private static void sortlist(int[] arr, int n, Node head) {
		// TODO Auto-generated method stub

		HashMap<Integer, Integer> hm = new HashMap<>();
		Node temp = head;

		while (temp != null) {
			if (hm.containsKey(temp.data))
				hm.put(temp.data, hm.get(temp.data) + 1);
			else
				hm.put(temp.data, 1);
			temp = temp.next;
		}

		temp = head;

		for (int i = 0; i < n; i++) {
			int freq = hm.get(arr[i]);

			while (freq > 0) {
				temp.data = arr[i];
				temp = temp.next;
				freq--;
			}

		}

	}

	static void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + "->");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		Node head = null;
		int arr[] = { 5, 1, 3, 2, 8 };
		int N = arr.length;

		// creating the linked list
		head = new Node(3);
		head.next = new Node(2);
		head.next.next = new Node(5);
		head.next.next.next = new Node(8);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(2);
		head.next.next.next.next.next.next = new Node(1);

		// Function call to sort the list in order
		// elements are apperaing in an array

		sortlist(arr, N, head);

		// print the modified linked list
		System.out.print("Sorted List:" + "\n");
		printList(head);

	}
}
