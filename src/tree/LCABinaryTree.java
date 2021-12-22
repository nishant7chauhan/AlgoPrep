package tree;

/**
 * LCA of binary tree
 * @author nishantchauhan
 * O(n)
 */


public class LCABinaryTree {

	boolean ifN1Present = false;
	boolean ifN2Present = false;

	public Node findLowestCommonAncestor(Node node, int n1, int n2) {

		Node lca = this.findLowestCommonAncestorUtil(node, n1, n2);

		if (ifN1Present && ifN2Present) {
			return lca;
		}
		return null;
	}

	public Node findLowestCommonAncestorUtil(Node node, int n1, int n2) {
		if (node == null) {
			return null;
		}

		// Store result in temp, in case of key match so that we can search for other
		// key also.
		Node temp = null;

		if (node.data == n1) {
			ifN1Present = true;
			temp = node;
		}

		if (node.data == n2) {
			ifN2Present = true;
			temp = node;
		}

		Node leftLCA = findLowestCommonAncestorUtil(node.left, n1, n2);
		Node rightLCA = findLowestCommonAncestorUtil(node.right, n1, n2);

		if (temp != null)
			return temp;

		if (leftLCA != null && rightLCA != null) {
			return node;
		}

		return leftLCA != null ? leftLCA : rightLCA;
	}

	public static void main(String[] args) {

		LCABinaryTree a = new LCABinaryTree();

		Node root = new Node(2);
		root.left = new Node(7);
		root.right = new Node(9);
		root.right.right = new Node(3);
		root.left.left = new Node(10);
		root.left.right = new Node(6);
		root.left.right.left = new Node(5);
		root.left.right.right = new Node(11);

		Node lca = a.findLowestCommonAncestor(root, 2, 10);
		if (lca != null) {
			System.out.println(lca.data);
		} else {
			System.out.println("LCA is null");
		}
	}

}
