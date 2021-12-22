package linklist;

/**
 * Given a Singly Linked list, Update the second half of the list such that n-th
 * element becomes sum(1st + nth) element, (n-1)st element becomes sum(2nd +
 * n-1st) element and so on.[done] Eg: 2->3->4->5->6 =>
 * 2->3->(4+4)->(5+3)->(6+2)
 * 
 * @author nishantchauhan
 *
 * O(n) , O(1)   [O(n/2) in case of stack] 
 */

public class RearrangeList {

	static Node front, back;

	/*
	 * Split the nodes of the given list into front and back halves, and return the
	 * two lists using the reference parameters. Uses the fast/slow pointer
	 * strategy.
	 */
	static void frontAndBackSplit(Node head) {
		Node slow, fast;

		slow = head;
		fast = head.next;

		/*
		 * Advance 'fast' two nodes, and advance 'slow' one node
		 */
		while (fast != null) {
			fast = fast.next;
			if (fast != null) {
				slow = slow.next;
				fast = fast.next;
			}
		}

		/*
		 * 'slow' is before the midpoint in the list, so split it in two at that point.
		 */
		front = head;
		back = slow.next;
		slow.next = null;
	}

	/* Function to reverse the linked list */
	static Node reverseList(Node head_ref) {
		Node current, prev, next;
		current = head_ref;
		prev = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head_ref = prev;
		return head_ref;
	}

	// perfrom the required subtraction operation
	// on the 1st half of the linked list
	static void modifyTheContentsOf2ndHalf() {
		Node front1 = front, back1 = back;
		// traversing both the lists simultaneously
		while (back1 != null) {
			// subtraction operation and node data
			// modification
			back1.data = back1.data + front1.data;

			front1 = front1.next;
			back1 = back1.next;
		}
	}

	// function to concatenate the 2nd(back) list
	// at the end of the 1st(front) list and
	// returns the head of the new list
	static Node concatFrontAndBackList(Node front, Node back) {
		Node head = front;

		if (front == null)
			return back;

		while (front.next != null)
			front = front.next;

		front.next = back;

		return head;
	}

	// function to modify the contents of the linked list
	static Node modifyTheList(Node head) {
		// if list is empty or contains only single node
		if (head == null || head.next == null)
			return head;
		front = null;
		back = null;

		// split the list into two halves
		// front and back lists
		frontAndBackSplit(head);

		// reverse the 2nd(back) list
		front = reverseList(front);

		// modify the contents of 1st half
		modifyTheContentsOf2ndHalf();

		// agains reverse the 2nd(back) list
		front = reverseList(front);

		// concatenating the 2nd list back to the
		// end of the 1st list
		head = concatFrontAndBackList(front, back);

		// pointer to the modified list
		return head;
	}

	// function to print the linked list
	static void printList(Node head) {
		if (head == null)
			return;

		while (head.next != null) {
			System.out.print(head.data + " -> ");
			head = head.next;
		}
		System.out.println(head.data);
	}

	// Driver Code
	public static void main(String args[]) {
		Node head = null;

		// creating the linked list
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		//head.next.next.next.next.next = new Node(2);

		// modify the linked list
		head = modifyTheList(head);

		// print the modified linked list
		System.out.println("Modified List:");
		printList(head);
	}
}
