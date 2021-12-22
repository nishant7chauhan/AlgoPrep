package tree;

/**
 * Deepest Node in Tree
 * 
 * @author nishantchauhan O(n)
 */

public class DeepestNodeFromRoot {

	static int maxLevel = -1;
	static int res = -1;

	// maxLevel : keeps track of maximum level seen so far.
	// res : Value of deepest node so far.
	// level : Level of root
	static void find(Node root, int level) {

		if (root == null)
			return;

		find(root.left, level+1);
		find(root.right, level+1);

		if (level > maxLevel) {
			res = root.data;
			maxLevel = level;
		}
	}

	// Returns value of deepest node
	static int deepestNode(Node root) {
		find(root, 0);
		return res;
	}

	// Driver code
	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.right = new Node(7);
		root.right.right.right = new Node(8);
		root.right.left.right.right = new Node(9);
		System.out.println(deepestNode(root) + " maxlevel: "+maxLevel);
	}

}
