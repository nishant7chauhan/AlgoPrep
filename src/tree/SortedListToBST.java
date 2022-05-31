package tree;

/**
 * Sorted list to BST
 * 
 * @author nishantchauhan
 *
 *         O(n)
 *         https://www.geeksforgeeks.org/sorted-linked-list-to-balanced-bst/
 */

public class SortedListToBST {
	Node head, temp;

	public Node sortedListToBST(Node head) {
		if (head == null)
			return null;

		temp = head;
		int len = getLength(head);
		return sortedListToBST(0, len - 1);
	}

	// get list length
	public static int getLength(Node head) { // not using here and tortoise as it takes nlogn time.
		int len = 0;
		Node p = head;
		while (p != null) {
			len++;
			p = p.right;
		}
		return len;
	}

	public static void printPreorder(Node node) {
		if (node == null)
			return;

		/* first print data of node */
		System.out.print(node.data + " ");

		/* then recur on left sutree */
		printPreorder(node.left);

		/* now recur on right subtree */
		printPreorder(node.right);
	}

	// build tree bottom-up
	public Node sortedListToBST(int start, int end) {
		if (start > end)
			return null;
		// mid
		int mid = (start + end) / 2;
		Node left = sortedListToBST(start, mid - 1);
		Node root = new Node(temp.data);
		temp = temp.right;
		root.left = left;
		root.right = sortedListToBST(mid + 1, end);

		return root;
	}

	public static void main(String[] args) {

		SortedListToBST obj = new SortedListToBST();

		obj.head = new Node(1);
		obj.head.right = new Node(2);
		obj.head.right.right = new Node(3);
		obj.head.right.right.right = new Node(4);
		obj.head.right.right.right.right = new Node(5);
		obj.head.right.right.right.right.right = new Node(6);
		obj.head.right.right.right.right.right.right = new Node(7);
		// TODO Auto-generated method stub

		printPreorder(obj.sortedListToBST(obj.head));
	}

}
