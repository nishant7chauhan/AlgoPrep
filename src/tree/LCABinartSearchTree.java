package tree;

/**
 * LCA of Binary search tree
 * 
 * @author nishantchauhan O(h)
 */

public class LCABinartSearchTree {

	public Node findLCA(Node node, int n1, int n2) {
		if (node == null) {
			return null;
		}

		if (node.data > n1 && node.data > n2) {
			return findLCA(node.left, n1, n2);
		} else if (node.data < n1 && node.data < n2) {
			return findLCA(node.right, n1, n2);
		} else {
			return node;
		}
	}

	public Node insert(Node node, int val) {
		if (node == null) {
			return new Node(val);
		}

		if (val < node.data) {
			node.left = insert(node.left, val);
		} else if ((val > node.data)) {
			node.right = insert(node.right, val);
		}

		return node;
	}

	public static void main(String[] args) {
		LCABinartSearchTree a = new LCABinartSearchTree();
		Node root = null;

		root = a.insert(root, 8);
		root = a.insert(root, 15);
		root = a.insert(root, 6);
		root = a.insert(root, 2);
		root = a.insert(root, 7);
		root = a.insert(root, 13);
		root = a.insert(root, 20);

		Node lca = a.findLCA(root, 6, 7);

		if (lca != null) {
			System.out.println(lca.data);
		}

	}

}
