package linklist;

/**
 * 
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x. You should preserve the
 * original relative order of the nodes in each of the two partitions. For
 * example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 * 
 * @author nishantchauhan
 * 
 * O(n) , in place space
 *
 */

public class PartitionListGivenNumber {

	static Node head; // head of the list

	public static Node partition(Node head, int x) {
		if (head == null)
			return null;
		Node fakeHead1 = new Node(0);
		Node fakeHead2 = new Node(0);

		fakeHead1.next = head;
		Node p = head;
		Node prev = fakeHead1;
		Node p2 = fakeHead2;
		while (p != null) {
			if (p.data < x) {
				p = p.next;
				prev = prev.next;
			} else {
				prev.next = p.next;
				p2.next = p;
				p = prev.next;
				p2 = p2.next;
			}
		}
		prev.next = fakeHead2.next;
		return fakeHead1.next;
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// creating the linked list
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(4);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(1);
		head.next.next.next.next.next = new Node(6);

		System.out.print("Before: ");
		printList(head);

		Node node = partition(head, 3);

		System.out.print("After: ");
		printList(node);

	}

}
