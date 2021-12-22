package tree;

/**
 * Nodes with no sibling
 * @author nishantchauhan
 * O(n)
 */


public class NodeWithNoSibling {

	Node root;

	// Function to print all non-root nodes
	// that don't have a sibling
	void printSingles(Node node) {
		// Base case
		if (node == null)
			return;

		printSingles(node.left);
		printSingles(node.right);

		if (node.left == null && node.right != null) {
			System.out.print(node.right.data + " ");
		} else if (node.left != null && node.right == null) {
			System.out.print(node.left.data + " ");
		}

		/*
		 * // If this is an internal node, recur for left // and right subtrees if
		 * (node.left != null && node.right != null) { printSingles(node.left);
		 * printSingles(node.right); }
		 * 
		 * // If left child is NULL and right // is not, print right child // and recur
		 * for right child else if (node.right != null) {
		 * System.out.print(node.right.data + " "); printSingles(node.right); }
		 * 
		 * // If right child is NULL and left // is not, print left child // and recur
		 * for left child else if (node.left != null) { System.out.print(node.left.data
		 * + " "); printSingles(node.left); }
		 */
	}

	// Driver program to test the above functions
	public static void main(String args[]) {
		NodeWithNoSibling tree = new NodeWithNoSibling();

		/*
		 * Let us construct the tree shown in above diagram
		 */
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.right.left = new Node(5);
		tree.root.right.left.right = new Node(6);
		tree.printSingles(tree.root);
	}
}
