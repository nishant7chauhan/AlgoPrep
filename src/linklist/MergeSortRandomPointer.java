package linklist;


/**
 * Put the given random pointers in linklist to point to next greater node such that if u transverse list in using random pointer, list become sorted.
 * @author nishantchauhan
 * O(nlogn)
 */

public class MergeSortRandomPointer {

	static NodeRandom head;

	public NodeRandom arbitraryPointToNextGreaterElement(NodeRandom head) {
		if (head == null || head.next == null) {
			return head;
		}

		NodeRandom node = head;
		while (node != null) {
			node.random = node.next;
			node = node.next;
		}

		return sortLinkedList(head);

	}

	public NodeRandom sortLinkedList(NodeRandom node) {
		if (node == null || node.random == null) {
			return node;
		}

		NodeRandom middle = getMiddleNode(node);
		NodeRandom second = middle.random;
		middle.random = null;

		return mergeTwoList(sortLinkedList(node), sortLinkedList(second));
	}

	public NodeRandom getMiddleNode(NodeRandom node) {
		if (node == null || node.random == null) {
			return node;
		}

		NodeRandom slow, fast;
		slow = node;
		fast = node.next;

		while (fast != null && fast.random!= null) {
			slow = slow.random;
			fast = fast.random.random;
		}

		return slow;
	}

	/*
	 * It'll print the complete linked list
	 */
	public void printList(NodeRandom node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data + " ");
		printList(node.next);
	}

	/*
	 * It'll print the complete linked list
	 */
	public void printListRandom(NodeRandom node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data + " ");
		printListRandom(node.random);
	}

	public NodeRandom mergeTwoList(NodeRandom first, NodeRandom second) {
		if (first == null && second == null) {
			return null;
		}

		NodeRandom tmp = new NodeRandom();
		NodeRandom finalList = tmp;
		while (first != null && second != null) {
			if (first.data < second.data) {
				tmp.random = first;
				first = first.random;
			} else {
				tmp.random = second;
				second = second.random;
			}

			tmp = tmp.random;
		}

		tmp.random = (first != null) ? first : second;

		return finalList.random;
	}

	public static void main(String[] args) {
		MergeSortRandomPointer a = new MergeSortRandomPointer();

		head = new NodeRandom(22);
		head.next = new NodeRandom(5);
		head.next.next = new NodeRandom(3);
		head.next.next.next = new NodeRandom(15);
		head.next.next.next.next = new NodeRandom(37);

		a.printList(head);

		head = a.arbitraryPointToNextGreaterElement(head);
		System.out.println("\n");
		a.printListRandom(head);

	}
}
