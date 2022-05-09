package msiq;

/**
 * LCA of binary tree
 * @author nishantchauhan
 * O(n)
 */


public class LCABinaryTree {

	boolean ifN1Present = false;
	boolean ifN2Present = false;

	public TreeNode findLowestCommonAncestor(TreeNode node, int n1, int n2) {

		TreeNode lca = this.findLowestCommonAncestorUtil(node, n1, n2);

		if (ifN1Present && ifN2Present) {
			return lca;
		}
		return null;
	}

	public TreeNode findLowestCommonAncestorUtil(TreeNode node, int n1, int n2) {
		if (node == null) {
			return null;
		}

		// Store result in temp, in case of key match so that we can search for other
		// key also.
		TreeNode temp = null;

		if (node.data == n1) {
			ifN1Present = true;
			temp = node;
		}

		if (node.data == n2) {
			ifN2Present = true;
			temp = node;
		}

		TreeNode leftLCA = findLowestCommonAncestorUtil(node.left, n1, n2);
		TreeNode rightLCA = findLowestCommonAncestorUtil(node.right, n1, n2);

		if (temp != null)
			return temp;

		if (leftLCA != null && rightLCA != null) {
			return node;
		}

		return leftLCA != null ? leftLCA : rightLCA;
	}

	public static void main(String[] args) {

		LCABinaryTree a = new LCABinaryTree();

		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(7);
		root.right = new TreeNode(9);
		root.right.right = new TreeNode(3);
		root.left.left = new TreeNode(10);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(5);
		root.left.right.right = new TreeNode(11);

		TreeNode lca = a.findLowestCommonAncestor(root, 2, 10);
		if (lca != null) {
			System.out.println(lca.data);
		} else {
			System.out.println("LCA is null");
		}
	}

}
