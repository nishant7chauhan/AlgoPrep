package msiq;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a tree, print all cousins of node that is given as input
 * 
 * @author nishantchauhan
 *
 *         O(n) , space O(n) but uses single transaction
 */

public class PrintCousinSingleTraversal {

	// function to print
	// cousins of the node
	static void printCousins(TreeNode root, TreeNode node_to_find) {
		// if the given node is the root itself, then no nodes would be printed
		if (root == node_to_find) {
			System.out.print("Cousin Nodes :" + " None" + "\n");
			return;
		}

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		boolean found = false;
		int size = 0;
		TreeNode p = null;
		q.add(root);

		// the following loop runs until found is not true,or q is not empty. if found
		// has become true => we have found the level in which the node is present and
		// the present queue will contain all the cousins of that node
		while (!q.isEmpty()&& found == false) {

			size = q.size();
			while (size-- > 0) {
				p = q.poll();
				

				// if current node's left or right child is the same as the node to find,then
				// make found = true,and don't push any of them into the queue, as we don't have
				// to print the siblings
				if ((p.left == node_to_find || p.right == node_to_find)) {
					found = true;
				} else {
					if (p.left != null)
						q.add(p.left);
					if (p.right != null)
						q.add(p.right);
				}

			}
		}

		// if found == true then the queue will contain the cousins of the given node
		if (found == true) {
			System.out.print("Cousin Nodes : ");
			size = q.size();

			// size_ will be 0 when the node was at the level just below the root node.
			if (size == 0)
				System.out.print("None");

			for (int i = 0; i < size; i++) {
				p = q.poll();
				

				System.out.print(p.data + " ");
			}
		} else {
			System.out.print("Node not found");
		}

		System.out.println("");
		return;
	}

	// Driver code
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.right = new TreeNode(15);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.left.right = new TreeNode(8);

		TreeNode x = new TreeNode(43);

		printCousins(root, x);
		printCousins(root, root);
		printCousins(root, root.right);
		printCousins(root, root.left);
		printCousins(root, root.left.right);
	}

}
