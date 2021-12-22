package tree;

/**
 * Given a binary tree, find the maximum BST subtree with the root of the max
 * BST
 * 
 * @author nishantchauhan
 * 
 *         O(n)
 *
 */

class MinMax {
	int min;
	int max;
	boolean isBST;
	int size;

	MinMax() {
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		isBST = true;
		size = 0;
	}
}

public class LargestBSTInBinaryTree {

	static Node root;

	public static int largestBST(Node root) {
		MinMax m = largest(root);
		return m.size;
	}

	private static MinMax largest(Node root) {
		// if root is null return min as Integer.MAX and max as Integer.MIN
		if (root == null) {
			return new MinMax();
		}

		// postorder traversal of First visit left and right then
		// use information of left and right to calculate largest BST.
		MinMax leftMinMax = largest(root.left);
		MinMax rightMinMax = largest(root.right);

		MinMax m = new MinMax();

		// if either of left or right subtree says its not BST or the data
		// of this node is not greater/equal than max of left and less than min of right
		// then subtree with this node as root will not be BST.
		// Return false and max size of left and right subtree to parent
		if (leftMinMax.isBST == false || rightMinMax.isBST == false
				|| (leftMinMax.max > root.data || rightMinMax.min <= root.data)) {
			m.isBST = false;
			m.size = Math.max(leftMinMax.size, rightMinMax.size);
			return m;
		}

		// if we reach this point means subtree with this node as root is BST.
		// Set isBST as true. Then set size as size of left + size of right + 1.
		// Set min and max to be returned to parent.
		m.isBST = true;
		m.size = leftMinMax.size + rightMinMax.size + 1;

		// if root.left is null then set root.data as min else
		// take min of left side as min
		m.min = root.left != null ? leftMinMax.min : root.data;

		// if root.right is null then set root.data as max else
		// take max of right side as max.
		m.max = root.right != null ? rightMinMax.max : root.data;

		return m;
	}

	public static void main(String args[]) {
		root = new Node(50);
		root.left = new Node(10);
		root.right = new Node(60);
		root.left.left = new Node(5);
		root.left.right = new Node(20);
		root.right.left = new Node(55);
		root.right.left.left = new Node(45);
		root.right.right = new Node(70);
		root.right.right.left = new Node(65);
		root.right.right.right = new Node(80);
		int largestBSTSize = largestBST(root);
		System.out.println("Size of largest BST  is " + largestBSTSize);
		assert largestBSTSize == 8;
	}

}
