package tree;

/**
 * Find minimum and maximum in binary tree
 * @author nishantchauhan
 *
 */

public class MinMaxInTree {

	int maximum = Integer.MIN_VALUE;
	int minimum = Integer.MAX_VALUE;

	private void findMinMaxValue(Node root) {
		// TODO Auto-generated method stub

		if (root == null)
			return;
		if (root.data < minimum)
			minimum = root.data;
		if (root.data > maximum)
			maximum = root.data;

		findMinMaxValue(root.left);
		findMinMaxValue(root.right);
	}

	public static void main(String[] args) {

		MinMaxInTree a = new MinMaxInTree();

		Node root = new Node(2);
		root.left = new Node(7);
		root.right = new Node(5);
		root.left.left = new Node(2);
		root.left.right = new Node(6);
		root.left.right.left = new Node(5);
		root.left.right.right = new Node(1);
		root.right.right = new Node(9);
		root.right.right.left = new Node(4);

		a.findMinMaxValue(root);
		System.out.println(a.maximum);
		System.out.println(a.minimum);
	}

}
