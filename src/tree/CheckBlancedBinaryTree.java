package tree;

/**
 * Height balanced tree
 * https://www.youtube.com/watch?v=Y0fmHaY8lx4&ab_channel=CodingSimplified
 * 
 * @author nishantchauhan O(n) , space - stack
 */

public class CheckBlancedBinaryTree {
	Node root;

	public static int ifHeightBalancedTree(Node node) {
		if (node == null) {
			return 0;
		}

/*		if (node.left == null && node.right == null) {
			return 1;
		}*/

		int lH = ifHeightBalancedTree(node.left);
		int rH = ifHeightBalancedTree(node.right);

		if (lH == -1 || rH == -1 || Math.abs(lH - rH) > 1) {
			return -1;
		}

		return Math.max(lH, rH) + 1;
	}

	public static void main(String[] args) {

		CheckBlancedBinaryTree tree = new CheckBlancedBinaryTree();
		
		tree.root = new Node(2);
		tree.root.left = new Node(7);
		tree.root.left.right = new Node(9);
		tree.root.left.left = new Node(12);
		tree.root.left.left.left = new Node(1);
		tree.root.left.left.right = new Node(10);
		tree.root.right = new Node(5);
		tree.root.right.right = new Node(1);
		
		
		
		//tree.root.left.right = new Node(6);
		//tree.root.left.right.left = new Node(5);
		//tree.root.left.right.right = new Node(11);
		// root.left.right.right.right = new Node(13);

		System.out.println(ifHeightBalancedTree(tree.root) != -1);
	}
}
