package tree;

/**
 * Find level of tree
 * @author nishantchauhan
 * O(n)
 */



public class LevelOfNode {

	Node root;

	private int printKdistance(Node node, int x, int level) {
		// TODO Auto-generated method stub

		if (node == null)
			return 0;
		if (node.data == x)
			return level;
		int result = printKdistance(node.left, x, level+1);
		if (result != 0)
			return result;
		return printKdistance(node.right, x, level+1);
		
		/**
		 * if (root == null)
			return;
		if (k == root.data) {
			System.out.print(level + " ");   //correct
			return;
		} else {
			printKdistance(root.left, k,level+1);
			printKdistance(root.right,k, level+1);
		}
		 */
		

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LevelOfNode tree = new LevelOfNode();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(8);

		int level = tree.printKdistance(tree.root, 3, 0); // k=2;
		System.out.print(level + " ");
	}

}
