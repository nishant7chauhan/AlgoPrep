package msiq;

/**
 * //https://thecodingsimplified.com/print-all-nodes-at-k-distance-from-given-node-in-binary-tree/
 * 
 * @author nishantchauhan O(n)
 */

public class PrintNodeAtKdistance {

	public int printElementsAtKDistance(TreeNode node, TreeNode targetNode, int k) {
		if (node == null || targetNode == null || k < 0) {
			return -1;
		}

		return printElementsAtKDistanceUtil(node, targetNode, k);
	}

	public int printElementsAtKDistanceUtil(TreeNode node, TreeNode targetNode, int k) {
		if (node == null) {
			return -1;
		}

		if (node == targetNode) {
			printNodesAtKDistanceFromParent(node, k);
			return 1;
		}

		int leftDist = printElementsAtKDistanceUtil(node.left, targetNode, k);

		if (leftDist != -1) {
			if (leftDist == k) {
				System.out.print(node.data + " ");
			} else {
				printNodesAtKDistanceFromParent(node.right, k - 1 - leftDist);
			}

			return leftDist + 1;
		}

		int rightDist = printElementsAtKDistanceUtil(node.right, targetNode, k);

		if (rightDist != -1) {
			if (rightDist == k) {
				System.out.print(node.data + " ");
			} else {
				printNodesAtKDistanceFromParent(node.left, k - 1 - rightDist);
			}

			return rightDist + 1;
		}

		return -1;
	}

	public void printNodesAtKDistanceFromParent(TreeNode node, int k) {
		if (node == null) {
			return;
		}

		if (k == 0) {
			System.out.print(node.data + " ");
		}

		printNodesAtKDistanceFromParent(node.left, k - 1);
		printNodesAtKDistanceFromParent(node.right, k - 1);
	}

	public static void main(String[] args) {

		PrintNodeAtKdistance a = new PrintNodeAtKdistance();

		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(7);
		root.right = new TreeNode(9);
		root.right.right = new TreeNode(3);
		root.left.left = new TreeNode(10);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(5);
		root.left.right.right = new TreeNode(11);

		int elements = a.printElementsAtKDistance(root, root.left, 2);

		if (elements == -1) {
			System.out.println("No elements found");
		}
	}
}
