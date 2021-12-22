package linklist;

/**
 * Rotate  Linked List by N time clockwise.
 * @author nishantchauhan
 * O(n)
 */



public class RotateLinkListClockWise {
	static Node root;

	public Node rotateClockwise(int k, Node node) {
		if (node == null || k < 0) {
			return node;
		}

		int sizeOfLinkedList = getSizeOfList(node);
		k = k % sizeOfLinkedList;

		if (k == 0) {
			return node;
		}

		Node tmp = node;
		int i = 1;

		while (i < sizeOfLinkedList - k) {
			tmp = tmp.next;
			i++;
		}

		Node temp = tmp.next;
		Node head = temp;
		tmp.next = null;

		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = node;

		return head;
	}

	public int getSizeOfList(Node node) {
		if (node == null) {
			return 0;
		}

		return 1 + getSizeOfList(node.next);
	}

	public void printList(Node node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data + " ");
		printList(node.next);
	}

	public static void main(String[] args) {

		RotateLinkListClockWise a = new RotateLinkListClockWise();
		root = new Node(7);
		root.next = new Node(12);
		root.next.next = new Node(99);
		root.next.next.next = new Node(37);
		root.next.next.next.next = new Node(8);
		root.next.next.next.next.next = new Node(18);

		a.printList(root);
		System.out.println();

		root = a.rotateClockwise(2, root);
		a.printList(root);
		System.out.println();

	}
}
