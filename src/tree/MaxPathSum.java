package tree;

/**
 * https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/.
 * 
 * @author nishant.chauhan O(n)
 */

class MaxPathSum {

	int maxSum = 0;

	public int maxSumPath(Node node) {
		if (node == null) {
			return 0;
		}

		if (node.left == null && node.right == null) {
			return node.data;
		}

		int l = maxSumPath(node.left);
		int r = maxSumPath(node.right);

		int max_one = Math.max(node.data, node.data + Math.max(l, r));

		int max_two = Math.max(max_one, l + r + node.data);

		maxSum = Math.max(maxSum, max_two);

		return max_one;
	}

	public static void main(String[] args) {

		MaxPathSum a = new MaxPathSum();

		Node root = new Node(2);
		root.left = new Node(4);
		root.left.left = new Node(1);
		root.left.right = new Node(6);
		root.right = new Node(5);
		root.right.right = new Node(7);

		a.maxSumPath(root);
		System.out.println(a.maxSum);

	}
}
