package linklist;

/**
 * mergesort link list
 * 
 * @author nishantchauhan O(nlogn)
 */

public class MergeSortlinkList {

	static Node root;

	public Node mergeSort(Node node) {
		if (node == null || node.next == null) {
			return node;
		}

		Node middle = middleNode(node);
		Node secondHalf = middle.next;
		middle.next = null;

		return merge(mergeSort(node), mergeSort(secondHalf));
	}

	/*
	 * It'll find the middle node of the linked list
	 */
	public Node middleNode(Node node) {
		
		Node a = node;
		Node b = node.next;  // always use fast pointer one ahead of slow at start( for  2 element)

		while (b != null && b.next != null) {
			a = a.next;
			b = b.next.next;
		}

		return a;
	}

	/*
	 * It'll merge both linked list
	 */
	public Node merge(Node a, Node b) {
		Node temp = new Node();
		Node finalList = temp;

		while (a != null && b != null) {
			if (a.data < b.data) {
				temp.next = a;
				a = a.next;
			} else {
				temp.next = b;
				b = b.next;
			}
			temp = temp.next;
		}
		temp.next = (a == null) ? b : a;
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

		Node root;
		MergeSortlinkList a = new MergeSortlinkList();

		root = new Node(99);
		root.next = new Node(12);
		root.next.next = new Node(37);
		root.next.next.next = new Node(8);
		root.next.next.next.next = new Node(18);

		a.printList(root);
		System.out.println();

		Node sorted = a.mergeSort(root);
		a.printList(sorted);
	}

}
