package tree;

/**
 * You have a tree, find the minimum length from input node to leaf.Solution:
 * 
 * @author nishant.chauhan
 * 
 * O(n)
 *
 */

public class ClosetLeafFromGivenNode {
	
	Node root;
	int minDist = Integer.MAX_VALUE;

	// This function finds closest leaf to root. This distance
	// is stored at *minDist.
	void findLeafDown(Node root, int lev) {

		// base case
		if (root == null)
			return;

		// If this is a leaf node, then check if it is closer
		// than the closest so far
		if (root.left == null && root.right == null) {
			if (lev < minDist)
				minDist = lev;

			return;
		}

		// Recur for left and right subtrees
		findLeafDown(root.left, lev + 1);
		findLeafDown(root.right, lev + 1);
	}

	// This function finds if there is closer leaf to x through
	// parent node.
	int findThroughParent(Node root, Node x, int minDist) {
		// Base cases
		if (root == null)
			return -1;

		if (root == x) {
			findLeafDown(x, 0);
			return 0;
		}

		// Search x in left subtree of root
		int l = findThroughParent(root.left, x, minDist);

		// If left subtree has x
		if (l != -1) {
			// Find closest leaf in right subtree
			findLeafDown(root.right, l + 2);   //check coding simplified video for k distance
			return l + 1;
		}

		// Search x in right subtree of root
		int r = findThroughParent(root.right, x, minDist);

		// If right subtree has x
		if (r != -1) {
			// Find closest leaf in left subtree
			findLeafDown(root.left, r + 2);   //check coding simplified video for k distance
			return r + 1;
		}

		return -1;
	}

	// Returns minimum distance of a leaf from given node x
	int minimumDistance(Node root, Node x) {
		// See if there is a closer leaf through parent
		findThroughParent(root, x, minDist);

		return minDist;
	}

	// Driver program
	public static void main(String[] args) {
		ClosetLeafFromGivenNode tree = new ClosetLeafFromGivenNode();

		// Let us create Binary Tree shown in above example
		tree.root = new Node(1);
		tree.root.left = new Node(12);
		tree.root.right = new Node(13);

		tree.root.right.left = new Node(14);
		tree.root.right.right = new Node(15);

		tree.root.right.left.left = new Node(21);
		tree.root.right.left.right = new Node(22);
		tree.root.right.right.left = new Node(23);
		tree.root.right.right.right = new Node(24);

		tree.root.right.left.left.left = new Node(1);
		tree.root.right.left.left.right = new Node(2);
		tree.root.right.left.right.left = new Node(3);
		tree.root.right.left.right.right = new Node(4);
		tree.root.right.right.left.left = new Node(5);
		tree.root.right.right.left.right = new Node(6);
		tree.root.right.right.right.left = new Node(7);
		tree.root.right.right.right.right = new Node(8);

		Node x = tree.root.right;

		System.out.println("The closest leaf to node with value " + x.data + " is at a distance of "
				+ tree.minimumDistance(tree.root, x));
	}

}
