package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given binary tree.Find level with maximum sum.
 * @author nishantchauhan
 * O(n),O(n)(queue)
 */



public class LevelWithMaximumSum {

	// Function to find the maximum sum of a level in tree
	// using level order traversal
	static int maxLevelSum(Node root) {
		// Base case
		if (root == null)
			return 0;

		// Do Level order traversal keeping track of number
		// of nodes at every level.
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		int level = 0;
		int maxLevel = 0;
		int maxLevelSum = Integer.MIN_VALUE;

		while (!q.isEmpty()) {
			// Get the size of queue when the level order
			// traversal for one level finishes
			int count = q.size();

			// Iterate for all the nodes in the queue currently
			int sum = 0;
			while (count-- > 0) {
				// Dequeue an node from queue
				Node temp = q.poll();

				// Add this node's value to current sum.
				sum = sum + temp.data;

				// Enqueue left and right children of
				// dequeued node
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
				

			}
			level++;
			// Update the maximum node count value
			if (sum > maxLevelSum) {

				maxLevelSum = sum;
				maxLevel = level;
			}
		}

		System.out.print("maxLevel: " + maxLevel + " maxLevelSum: " + maxLevelSum);

		return maxLevelSum;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(8);
		root.right.right.left = new Node(6);
		root.right.right.right = new Node(7);

		/*
		 * Constructed Binary tree is:  1 
		 * 							  /   \ 
		 * 							 2     3    
		 * 							/  \    \
		 * 						   4    5    8
		 *                                  / \
		 *                                 6   7
		 */
		//System.out.print("Maximum level sum is " + maxLevelSum(root));
		maxLevelSum(root);
	}

}
