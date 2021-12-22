package linklist;

/**
 * Detect and remove loop
 * @author nishantchauhan
 * O(n) (handle ace condition also)
 */


public class DetectAndRemoveLoop {

	 Node head;

	// Function that detects loop in the list
	void detectAndRemoveLoop(Node node) {

		// If list is empty or has only one node
		// without loop
		if (node == null || node.next == null)
			return;

		Node slow = node, fast = node;

		// Move slow and fast 1 and 2 steps
		// ahead respectively.
		slow = slow.next;
		fast = fast.next.next;

		// Search for loop using slow and fast pointers
		while (fast != null && fast.next != null) {
			if (slow == fast)
				break;

			slow = slow.next;
			fast = fast.next.next;
		}

		/* If loop exists */
		if (slow == fast) {
			if (fast == head) {               // ace condition
				while (slow.next != fast)
					slow = slow.next;
				slow.next = null;
			} else {
				slow = node;
				while (slow.next != fast.next) {
					slow = slow.next;
					fast = fast.next;
				}
				fast.next = null;
			}

			/* since fast->next is the looping point */
			/* remove loop */
		}
	}

	// Function to print the linked list
	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		DetectAndRemoveLoop list = new DetectAndRemoveLoop();
		list.head = new Node(50);
		list.head.next = new Node(20);
		list.head.next.next = new Node(15);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(10);

		// Creating a loop for testing
		list.head.next.next.next.next.next = list.head;
		list.detectAndRemoveLoop(list.head);
		System.out.println("Linked List after removing loop : ");
		list.printList(list.head);
	}

}
