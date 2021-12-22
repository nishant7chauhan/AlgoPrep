package tree;


/**
 * Two nodes of a BST are swapped, correct the BST
 * @author nishant.chauhan
 *
 */

/*2 Nodes of a BST are swapped , correct the BST(IDeserve)*/

public class CorrectBinarySearchTree {
	Node firstStartPoint, lastEndPoint;
	Node prevNode;

	public void findSegments(Node root) {
		if (root == null)
			return;

		findSegments(root.left);

		if (prevNode != null) {
			if (prevNode.data > root.data) {
				if (firstStartPoint == null) {
					firstStartPoint = prevNode;
				}
				lastEndPoint = root;
			}
		}
		prevNode = root;

		findSegments(root.right);
	}

	public void recoverTree(Node root) {
		findSegments(root);
		int x = firstStartPoint.data;
		firstStartPoint.data = lastEndPoint.data;
		lastEndPoint.data = x;
	}

	public void printInOrder(Node root) {
		if (root == null)
			return;

		printInOrder(root.left);
		System.out.print(root.data + " ");
		printInOrder(root.right);
	}

	public static void main(String[] args) {
		Node root = new Node(6);
		root.left = new Node(10);
		root.right = new Node(2);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.right = new Node(12);
		root.right.left = new Node(7);

		System.out.println("In-Order traversal of BST before recovery: ");
		CorrectBinarySearchTree tree = new CorrectBinarySearchTree();
		tree.printInOrder(root);

		tree.recoverTree(root);
		System.out.println("\nIn-Order traversal of BST after recovery: ");

		tree.printInOrder(root);
	}
}
