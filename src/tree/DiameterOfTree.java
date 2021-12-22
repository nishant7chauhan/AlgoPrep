package tree;

/**
 * https://www.youtube.com/watch?v=kFuYJi-Pvyg&ab_channel=CodingSimplified
 * 
 * @author IN006166
 * 
 * O(n)
 *
 */

public class DiameterOfTree {

	int diameter = 0;
	Node root;

	int diameter(Node root) {

		if (root == null) {
			return 0;
		}

		int lh = diameter(root.left);
		int rh = diameter(root.right);

		/*
		 * Height of current node is max of heights of left and right subtrees plus 1
		 */
		diameter = Math.max(diameter, (lh + rh + 1));

		return Math.max(lh, rh) + 1;
	}

	public static void main(String args[]) {
		/* creating a binary tree and entering the nodes */
		DiameterOfTree tree = new DiameterOfTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		tree.diameter(tree.root);
		System.out.println("The diameter of given binary tree is : " + tree.diameter);
	}
}
