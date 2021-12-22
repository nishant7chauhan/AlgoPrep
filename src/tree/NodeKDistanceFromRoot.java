package tree;

/**
 * Print nodes at k distance from root[6]
 * @author nishant.chauhan
 * O(n)
 */



public class NodeKDistanceFromRoot {

	Node root;

	private void printKdistance(Node root, int k) {
		// TODO Auto-generated method stub

		if (root == null)
			return;
		if (k == 0) {
			System.out.print(root.data + " ");
			return;
		} else {
			printKdistance(root.left, k-1);
			printKdistance(root.right, k-1);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NodeKDistanceFromRoot tree = new NodeKDistanceFromRoot();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(8);

		tree.printKdistance(tree.root, 2); // k=2;
	}

}
