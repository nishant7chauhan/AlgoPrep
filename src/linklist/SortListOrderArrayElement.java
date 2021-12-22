package linklist;

import java.util.HashMap;

/**
 * 1.1.Sort the linked list in the order, elements are appearing in the array.
 * O(n) complexity was expected. Complete running code on paper was expected.
 * All boundary condition checks were expected. Input : arr = {5, 1, 3, 2, 8}
 * list = 3 -> 2 -> 5 -> 8 -> 5 -> 2 -> 1 -> X Output : 5 5 1 3 2 2 8
 * 
 * @author IN006166
 *
 *
 * O(n) , O(n)
 */

public class SortListOrderArrayElement {

	static Node push(Node head_ref, int new_data) {
		Node new_node = new Node();
		new_node.data = new_data;
		new_node.next = head_ref;
		head_ref = new_node;
		return head_ref;
	}

	// function to print the linked list
	static void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + "->");
			head = head.next;
		}
	}

	// Function that sort list in order of apperaing
	// elements in an array
	static void sortlist(int arr[], int N, Node head) {
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		Node temp = head;
		while (temp != null) {
			if (hash.containsKey(temp.data))
				hash.put(temp.data, hash.get(temp.data) + 1);
			else
				hash.put(temp.data, 1);
			temp = temp.next;
		}

		temp = head;

		// One by one put elements in list according to their appearance in array
		for (int i = 0; i < N; i++) {
			int frequency = hash.get(arr[i]);
			while (frequency-- > 0) {
				temp.data = arr[i];
				temp = temp.next;
			}
		}
	}

	// Driver Code
	public static void main(String[] args) {
		Node head = null;
		int arr[] = { 5, 1, 3, 2, 8 };
		int N = arr.length;

		// creating the linked list
		head = push(head, 3);
		head = push(head, 2);
		head = push(head, 5);
		head = push(head, 8);
		head = push(head, 5);
		head = push(head, 2);
		head = push(head, 1);

		sortlist(arr, N, head);

		// print the modified linked list
		System.out.print("Sorted List:" + "\n");
		printList(head);
	}

}
