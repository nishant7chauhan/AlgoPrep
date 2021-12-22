package linklist;

/**
 * reverse alternate k group
 * @author nishantchauhan
 * O(n)
 */

public class ReverseAlternateKnodes {

	static void printlist(Node root) {
		for (Node curPtr = root; curPtr != null; curPtr = curPtr.next) {
			System.out.print("--->" + curPtr.data);
		}
	}

	public static Node reverseKgroup(Node node, int k, boolean b) {

		if(node == null) {
			return null;
		}
		
		Node current = node;
		Node prev = null;
		Node next = null;

		int count = 0;

		while (count < k && current != null) {
		
			next = current.next;
			if (b == true) {
				current.next = prev;    //modified recursion
			}
			prev = current;
			current = next;
			count++;
		}

		if (b == true) {
			node.next = reverseKgroup(next, k, !b); // make diagram call like node.next then prev.next and finally return
			return prev; //last return
		} else {
			prev.next = reverseKgroup(next, k, !b); // make diagram call like node.next then prev.next and finally return
			return node;
		}

	}

	public static void main(String[] args) {

		Node root = new Node(1);
		root.next = new Node(2);
		root.next.next = new Node(3);
		root.next.next.next = new Node(4);
		root.next.next.next.next = new Node(5);
		root.next.next.next.next.next = new Node(6);
		root.next.next.next.next.next.next = new Node(7);
		root.next.next.next.next.next.next.next = new Node(8);
		root.next.next.next.next.next.next.next.next = new Node(9);
		root.next.next.next.next.next.next.next.next.next = new Node(10);
		root.next.next.next.next.next.next.next.next.next.next = new Node(11);

		printlist(root);
		Node head = reverseKgroup(root, 3, true);
		System.out.print("\n");
		printlist(head);

	}

}
