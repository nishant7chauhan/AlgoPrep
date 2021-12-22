package linklist;
import java.util.HashSet;

/**
 * Linked List pair sum count
 * @author nishantchauhan
 * O(n), O(n)
 */

public class PairWithGivenSum {

	static Node head;

	/*
	 * Given a reference (pointer to pointer) to the head of a list and an int, push
	 * a new node on the front of the list.
	 */

	/* Takes head pointer of the linked list and sum */
	static void check_pair_sum(Node head, int sum) {
		HashSet<Integer> s = new HashSet<Integer>();
		Boolean flag = false;
		Node p = head;
		while (p != null) {
			int curr = p.data;
			if (s.contains(sum - curr)) {
				System.out.print("("+curr + " " + (sum - curr) + ")"+ "\n");
				flag = true;
			}
			s.add(p.data);
			p = p.next;
		}

		if(!flag) {
			System.out.print("No pair exists");
		}
	}

	// Driver Code
	public static void main(String[] args) {
		/* Start with the empty list */
		head = null;
		head = new Node(0);
		head.next = new Node(2);
		head.next.next = new Node(5);
		head.next.next.next = new Node(7);
		head.next.next.next.next = new Node(4);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(10);
		head.next.next.next.next.next.next.next = new Node(20);
		head.next.next.next.next.next.next.next.next = new Node(-10);
		//head.next.next.next.next.next.next.next.next.next = new Node(14);
		/* function to print the result */
		check_pair_sum(head, 10);
	}

}
