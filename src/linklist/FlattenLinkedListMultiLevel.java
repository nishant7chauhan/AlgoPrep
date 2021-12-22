package linklist;

/**
 * https://www.youtube.com/watch?v=PazsaUFz9io
 * 
 * @author nishant.chauhan O(N)
 */

class NodeF {
	NodeF right;
	NodeF next;
	int data;
}

/*
 * Linked class contains the necessary functions to make the operations.
 */
class Linked {
	NodeF root;

	public Linked() {
		root = null;
	}

	/*
	 * flatten() method is used to flat the complex Linked List
	 */
	public NodeF flatten(NodeF NodeF) {
		if (NodeF == null || NodeF.right == null)
			return NodeF;
		return merge(NodeF, flatten(NodeF.right));
	}

	/*
	 * merge() method is used to merge the two rows of a list in consecutive and
	 * sorted manner that'll lead to the flattening of Linked List
	 */
	public NodeF merge(NodeF first, NodeF second) {
		// flag new NodeF
		NodeF temp = new NodeF();
		NodeF finalList = temp;
		// Based on NodeF's value, NodeFs would be arranged
		while (first != null && second != null) {
			if (first.data < second.data) {
				temp.next = first;
				first = first.next;
			} else {
				temp.next = second;
				second = second.next;
			}
			temp = temp.next;
		}
		temp.next = (first != null) ? first : second;
		finalList.next.right = null;
		return finalList.next;
	}

	/*
	 * printLinkedList() method is used to print the Linked List (NodeFs)
	 */
	public void printLinkedList(NodeF NodeF) {
		if (NodeF == null)
			return;
		System.out.print(NodeF.data + " ");
		printLinkedList(NodeF.next);
	}

	/*
	 * getNewNodeF() method to generate a new NodeF
	 */
	public NodeF getNewNodeF(int key) {
		NodeF a = new NodeF();
		a.next = null;
		a.right = null;
		a.data = key;
		return a;
	}

	/*
	 * insert method is used to insert the element in Linked List
	 */
	public NodeF insert(NodeF NodeF, int key) {
		if (NodeF == null)
			return getNewNodeF(key);
		NodeF.next = insert(NodeF.next, key);
		return NodeF;
	}
}

public class FlattenLinkedListMultiLevel {

	/*
	 * Flatten class to initiate the operation.
	 */

	public static void main(String[] args) {

		NodeF root = null;
		Linked a = new Linked();
		root = a.insert(root, 20);
		root = a.insert(root, 22);
		root = a.insert(root, 25);
		root = a.insert(root, 65);
		root = a.insert(root, 70);

		root.right = a.insert(root.right, 7);
		root.right = a.insert(root.right, 12);
		root.right = a.insert(root.right, 23);
		root.right = a.insert(root.right, 34);

		root.right.right = a.insert(root.right.right, 10);
		root.right.right = a.insert(root.right.right, 15);
		root.right.right = a.insert(root.right.right, 17);
		root.right.right = a.insert(root.right.right, 18);
		root.right.right = a.insert(root.right.right, 21);
		root.right.right = a.insert(root.right.right, 33);

		root.right.right.right = a.insert(root.right.right.right, 32);
		root.right.right.right = a.insert(root.right.right.right, 39);
		root.right.right.right = a.insert(root.right.right.right, 40);

		NodeF flattenList = a.flatten(root);
		a.printLinkedList(flattenList);
	}
}
