package tree;

/**
 * finding a deadlock in a BST.
 * @author nishantchauhan
 * O(n)
 */


public class Deadlock {
	static Node root;

	// A recursive function
	// to insert a new key in BST
	Node insert(Node root, int data) {

		// If the tree is empty,
		// return a new node
		if (root == null) {
			root = new Node(data);
			return root;
		}

		/* Otherwise, recur down the tree */
		if (data < root.data)
			root.left = insert(root.left, data);
		else if (data > root.data)
			root.right = insert(root.right, data);

		/* return the (root,unchanged) node pointer */
		return root;
	}

	// Returns true if tree with given root contains
	// dead end or not. min and max indicate range
	// of allowed values for current node. Initially
	// these values are full range.
	boolean deadEnd(Node root, int min, int max) {
		// if the root is null or the recursion moves
		// after leaf node it will return false
		// i.e no dead end.
		if (root == null)
			return false;

		// if this occurs means dead end is present.
		if (min == max)
			return true;

		// heart of the recursion lies here.
		return deadEnd(root.left, min, root.data - 1) || deadEnd(root.right, root.data + 1, max);
	}

	// Driver Program
	public static void main(String[] args) {
		Deadlock tree = new Deadlock();
		root = tree.insert(root, 8);
		root = tree.insert(root, 5);
		root = tree.insert(root, 2);
		root = tree.insert(root, 3);
		root = tree.insert(root, 7);
		root = tree.insert(root, 11);
		root = tree.insert(root, 4);

		if (tree.deadEnd(root, 1, Integer.MAX_VALUE) == true)

			System.out.println("Yes ");
		else
			System.out.println("No ");
	}

}
