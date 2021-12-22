package tree;

import java.util.HashSet;

/**
 * pair with given sum in bst
 * @author nsihatchauhan
 * O(n),O(n)
 */




public class PairWithGivenSumBST {

	static Node insert(Node root, int key) {
		if (root == null)
			return new Node(key);
		if (key < root.data)
			root.left = insert(root.left, key);
		else
			root.right = insert(root.right, key);
		return root;
	}

	static boolean findpairUtil(Node root, int sum, HashSet<Integer> set) {
		if (root == null)
			return false;

		if (set.contains(sum - root.data)) {
			System.out.println("Pair is found (" + (sum - root.data) + ", " + root.data + ")");
			return true;
		} else
			set.add(root.data);

		if (findpairUtil(root.left, sum, set))
			return true;
		return findpairUtil(root.right, sum, set);
	}

	static void findPair(Node root, int sum) {
		HashSet<Integer> set = new HashSet<Integer>();
		if (!findpairUtil(root, sum, set))
			System.out.print("Pairs do not exit" + "\n");
	}

	// Driver code
	public static void main(String[] args) {
		Node root = null;
		root = insert(root, 15);
		root = insert(root, 10);
		root = insert(root, 20);
		root = insert(root, 8);
		root = insert(root, 12);
		root = insert(root, 16);
		root = insert(root, 25);
		root = insert(root, 10);

		int sum = 33;
		findPair(root, sum);

	}

}
