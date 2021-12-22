package tree;

/**
 * //https://thecodingsimplified.com/print-all-nodes-at-k-distance-from-given-node-in-binary-tree/
 * 
 * @author nishantchauhan O(n)
 */

public class PrintNodeAtKdistance {

	public int printElementsAtKDistance(Node node, Node targetNode, int k) {
		if (node == null || targetNode == null || k < 0) {
			return -1;
		}

		return printElementsAtKDistanceUtil(node, targetNode, k);
	}

	public int printElementsAtKDistanceUtil(Node node, Node targetNode, int k) {
		if (node == null) {
			return -1;
		}

		if (node == targetNode) {
			printNodesAtKDistanceFromParent(node, k);
			return 0;
		}

		int leftDist = printElementsAtKDistanceUtil(node.left, targetNode, k);

		if (leftDist != -1) {
			if (leftDist + 1 == k) {
				System.out.print(node.data + " ");
			} else {
				printNodesAtKDistanceFromParent(node.right, k - 2 - leftDist);
			}

			return leftDist + 1;
		}

		int rightDist = printElementsAtKDistanceUtil(node.right, targetNode, k);

		if (rightDist != -1) {
			if (rightDist + 1 == k) {
				System.out.print(node.data + " ");
			} else {
				printNodesAtKDistanceFromParent(node.left, k - 2 - rightDist);
			}

			return rightDist + 1;
		}

		return -1;
	}

	public void printNodesAtKDistanceFromParent(Node node, int k) {
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

		Node root = new Node(2);
		root.left = new Node(7);
		root.right = new Node(9);
		root.right.right = new Node(3);
		root.left.left = new Node(10);
		root.left.right = new Node(6);
		root.left.right.left = new Node(5);
		root.left.right.right = new Node(11);

		int elements = a.printElementsAtKDistance(root, root.left, 2);

		if (elements == -1) {
			System.out.println("No elements found");
		}
	}
}
