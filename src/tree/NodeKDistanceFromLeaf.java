package tree;
/**
 * Print nodes at k distance from leaf node.
 * @author nishantchauhan
 * O(n) , O(1)
 */


public class NodeKDistanceFromLeaf {

	Node root;

	int printKDistantfromLeaf(Node node, int k) {
		if (node == null)
			return -1;
		int lk = printKDistantfromLeaf(node.left, k);
		int rk = printKDistantfromLeaf(node.right, k);
		boolean isLeaf = lk == -1 && lk == rk;
		if (lk == 0 || rk == 0 || (isLeaf && k == 0))
			System.out.print(" " + node.data);
		if (isLeaf && k > 0)
			return k - 1; // leaf node
		if (lk > 0 && lk < k)
			return lk - 1; // parent of left leaf
		if (rk > 0 && rk < k)
			return rk - 1; // parent of right leaf

		return -2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NodeKDistanceFromLeaf tree = new NodeKDistanceFromLeaf();

		/* Let us construct the tree shown in above diagram */
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(8);

		System.out.println(" Nodes at distance 2 are :");
		
		tree.printKDistantfromLeaf(tree.root, 2);
	}
}

/**
 * O(n) ,O(n)
 * 
 * 
 * public void printAllElementsAtKDistanceFromLeafNode(Node node, int k) { if
 * (node == null || k < 0) { return; }
 * 
 * int arr[] = new int[20]; boolean visited[] = new boolean[20];
 * 
 * printAllElementsAtKDistanceFromLeafNodeUtil(node, k, arr, visited, 0); }
 * 
 * public void printAllElementsAtKDistanceFromLeafNodeUtil(Node node, int k,
 * int[] arr, boolean[] visited, int count) { if (node == null) { return; }
 * 
 * arr[count] = node.data; visited[count] = false;
 * 
 * if (node.left == null && node.right == null && count - k >= 0 &&
 * visited[count - k] == false) { System.out.print(arr[count - k] + " ");
 * visited[count - k] = true; return; }
 * 
 * printAllElementsAtKDistanceFromLeafNodeUtil(node.left, k, arr, visited, count
 * + 1); printAllElementsAtKDistanceFromLeafNodeUtil(node.right, k, arr,
 * visited, count + 1); }
 * 
 */