package tree;

/******* Height of tree *******/
//O(n), space O(n)


public class HeightOfTree {

	Node root;

	private int height(Node root) {
		// TODO Auto-generated method stub

		if (root == null)
			return 0;

		return Math.max(height(root.left), height(root.right)) + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HeightOfTree tree = new HeightOfTree();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Height of tree is : " + tree.height(tree.root));
	}

}