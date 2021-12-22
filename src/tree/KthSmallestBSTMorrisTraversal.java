package tree;

/**
 * 
 * 
 * 
 * @author nishantchauhan
 *
 */



public class KthSmallestBSTMorrisTraversal {

	static Node root;

	public void inorder(Node root, int k) {
		Node current = root;
		int count = 0;

		while (current != null) {
			// left is null then print the node and go to right
			if (current.left == null) {
				// System.out.print(current.data + " ");
				count++;
				if (k == count) {
					System.out.print(current.data + " ");
				}

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
					// System.out.print(current.data + " ");
					count++;
					if (k == count) {
						System.out.print(current.data + " ");
					}
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

		KthSmallestBSTMorrisTraversal mt = new KthSmallestBSTMorrisTraversal();
		mt.inorder(root, 3);

	}
}
