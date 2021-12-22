package tree;

/**
 * Inorder,preorder traversal of tree with O(1) space
 * 
 * @author IN006166
 * 
 *         O(n),O(1)
 */

public class MorrisTraversal {
	static Node root;

	public void inorder(Node root) {
		Node current = root;
		while (current != null) {
			// left is null then print the node and go to right
			if (current.left == null) {
				System.out.print(current.data + " ");
				current = current.right;
			} else {
				// find the predecessor.
				Node predecessor = current.left;
				// To find predecessor keep going right till right node is not null or right
				// node is not current.
				while (predecessor.right != current && predecessor.right != null) {
					predecessor = predecessor.right;
				}
				// if right node is null then go left after establishing link from predecessor
				// to current.
				if (predecessor.right == null) {
					predecessor.right = current;
					current = current.left;
				} else { // left is already visit. Go rigth after visiting current.
					predecessor.right = null;
					System.out.print(current.data + " ");
					current = current.right;
				}
			}
		}
	}

	public void preorder(Node root) {
		Node current = root;
		while (current != null) {
			if (current.left == null) {
				System.out.print(current.data + " ");
				current = current.right;
			} else {
				Node predecessor = current.left;
				while (predecessor.right != current && predecessor.right != null) {
					predecessor = predecessor.right;
				}
				if (predecessor.right == null) {
					predecessor.right = current;
					System.out.print(current.data + " ");
					current = current.left;
				} else {
					predecessor.right = null;
					current = current.right;
				}
			}
		}
	}

	public static void main(String args[]) {

		root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(30);
		root.left.left = new Node(-2);
		root.left.right = new Node(6);
		root.right.right = new Node(40);
		root.left.left.right = new Node(2);
		root.left.right.right = new Node(8);
		root.left.left.right.left = new Node(-1);

		MorrisTraversal mt = new MorrisTraversal();
		mt.inorder(root);
		System.out.println();
		mt.preorder(root);
	}

}
