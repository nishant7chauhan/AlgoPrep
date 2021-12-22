package tree;

/**
 * Add all greater values to every node in a given BST(means recur for right as it is greater value in BST , 1st greatest + 2nd Greatest i.e inorder reverse)
 * @author nishantchauhan
 * O(n)
 */

public class SumTreeGreaterBST {
	// tree.root of BST
	Node root;

	void inorderUtil(Node node) {
		if (node == null)
			return;

		inorderUtil(node.left);
		System.out.print(node.data + " ");
		inorderUtil(node.right);
	}


	Node insert(Node node, int data) {
		/* If the tree is empty, return a new node */
		if (node == null) {
			root = new Node(data);
			return root;
		}

		/* Otherwise, recur down the tree */
		if (data <= node.data) {
			node.left = this.insert(node.left, data);
		} else {
			node.right = this.insert(node.right, data);
		}
		return node;
	}

	// This class initialises the value of sum to 0
	public class Sum {
		int sum = 0;
	}

	// Recursive function to add all greater values in
	// every node
	void modifyBSTUtil(Node node, Sum S) {
		// Base Case
		if (node == null)
			return;

		// Recur for right subtree
		this.modifyBSTUtil(node.right, S);

		// Now *sum has sum of nodes in right subtree, add
		// tree.root->data to sum and update tree.root->data
		S.sum = S.sum + node.data;
		node.data = S.sum;

		// Recur for left subtree
		this.modifyBSTUtil(node.left, S);
	}

	// A wrapper over modifyBSTUtil()
	void modifyBST(Node node) {
		Sum S = new Sum();
		this.modifyBSTUtil(node, S);
	}

	// Driver Function
	public static void main(String[] args) {
		SumTreeGreaterBST tree = new SumTreeGreaterBST();

		tree.root = tree.insert(tree.root,50);
		tree.root = tree.insert(tree.root,30);
		tree.root = tree.insert(tree.root,20);
		tree.root = tree.insert(tree.root,40);
		tree.root = tree.insert(tree.root,70);
		tree.root = tree.insert(tree.root,60);
		tree.root = tree.insert(tree.root,80);

		tree.modifyBST(tree.root);

		// print inoder tarversal of the modified BST
		tree.inorderUtil(tree.root);
	}

}
