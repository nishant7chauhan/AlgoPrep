package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author nishantchauhan
 * 
 *
 *         int minimumDepth(Node root, int level) {
 *         if (root == null) return level; 
 *         level++;                                           //opposite to Height of BT inverse propositional
 *         return Math.min(minimumDepth(root.left, level),
 *         minimumDepth(root.right, level)); }
 *			
 *			// above time is O(n) but have to traverse whole tree.
 *			
 *			// below time is O(n) and not have to traverse whole tree. 
 */

public class MinimumDepthOfBT {

	// A queue item (Stores pointer to
	// node and an integer)
	static class qItem {
		Node node;
		int depth;

		public qItem(Node node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}

	// Iterative method to find
	// minimum depth of Binary Tree
	static int minDepth(Node root) {
		// Corner Case
		if (root == null)
			return 0;

		// Create an empty queue for level order traversal
		Queue<qItem> q = new LinkedList<>();

		// Enqueue Root and initialize depth as 1
		qItem qi = new qItem(root, 1);
		q.add(qi);

		// Do level order traversal
		while (!q.isEmpty()) {
			// Remove the front queue item
			qi = q.remove();

			// Get details of the remove item
			Node node = qi.node;
			int depth = qi.depth;

			// If this is the first leaf node seen so far
			// Then return its depth as answer
			if (node.left == null && node.right == null) // complete traversal of Binary Tree even when the topmost leaf
															// is close to root. A Better Solution is to do Level Order
															// Traversal.
				return depth;

			// If left subtree is not null,
			// add it to queue
			if (node.left != null) {
				qi.node = node.left;
				qi.depth = depth + 1;
				q.add(qi);
			}

			// If right subtree is not null,
			// add it to queue
			if (node.right != null) {
				qi.node = node.right;
				qi.depth = depth + 1;
				q.add(qi);
			}
		}
		return 0;
	}

	// Driver Code
	public static void main(String[] args) {
		// Let us create binary tree shown in above diagram
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		System.out.println(minDepth(root));
	}

}
