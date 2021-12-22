package tree;

/**
 * Check if tree T1 is a subset of tree T2.
 * @author nishantchauhan
 * isSubTree O(NM) and isSubTreeOptimized O(n) //O(n) time using KMP string matching algorithm.
 */



public class SubTree {

	public boolean isSubTree(Node main, Node sub) {
		if (sub == null) {
			return true;
		}

		if (main == null) {
			return false;
		}

		if (ifIdenticalTrees(main, sub)) {
			return true;
		}

		return isSubTree(main.left, sub) || isSubTree(main.right, sub);
	}

	public boolean ifIdenticalTrees(Node a, Node b) {
		if (a == null && b == null) {
			return true;
		}

		if (a == null || b == null) {
			return false;
		}

		return a.data == b.data && ifIdenticalTrees(a.left, b.left) && ifIdenticalTrees(a.right, b.right);
	}

	public boolean isSubTreeOptimized(Node main, int mainTreeNodes, Node sub, int subTreeNodes) {
		if (sub == null) {
			return true;
		}

		if (main == null) {
			return false;
		}

		int mainInorder[] = new int[mainTreeNodes];
		inorderFillArray(main, mainInorder);
		i = 0;

		int subInorder[] = new int[subTreeNodes];
		inorderFillArray(sub, subInorder);
		i = 0;

		String mainInorderString = arrayToString(mainInorder);
		String subInorderString = arrayToString(subInorder);

		if (!mainInorderString.contains(subInorderString)) {
			return false;
		}

		int mainPreorder[] = new int[mainTreeNodes];
		preorderFillArray(main, mainPreorder);
		i = 0;

		int subPreorder[] = new int[subTreeNodes];
		preorderFillArray(sub, subPreorder);

		String mainPreorderString = arrayToString(mainPreorder);
		String subPreorderString = arrayToString(subPreorder);

		return mainPreorderString.contains(subPreorderString);
	}

	int i;

	public void inorderFillArray(Node node, int a[]) {
		if (node == null) {
			return;
		}

		inorderFillArray(node.left, a);

		a[i++] = node.data;

		inorderFillArray(node.right, a);
	}

	public void preorderFillArray(Node node, int a[]) {
		if (node == null) {
			return;
		}

		a[i++] = node.data;

		preorderFillArray(node.left, a);
		preorderFillArray(node.right, a);
	}

	public String arrayToString(int a[]) {
		String s = "";
		for (int i = 0; i < a.length; i++) {
			s = s + a[i];
		}

		return s;
	}

	public static void main(String[] args) {

		SubTree a = new SubTree();

		Node root = new Node(2);
		root.left = new Node(4);
		root.left.left = new Node(1);
		root.left.right = new Node(6);
		root.right = new Node(5);
		root.right.right = new Node(7);

		Node root2 = new Node(4);
		root2.left = new Node(1);
		root2.right = new Node(6);

		System.out.println(a.isSubTree(root, root2));
		System.out.println(a.isSubTreeOptimized(root, 6, root2, 3));
	}

}
