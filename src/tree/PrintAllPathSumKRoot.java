package tree;

import java.util.ArrayList;

/**
 * find path in the tree such that the sum of nodes in path is equal to given K
 * from root
 * 
 * @author nishantchauhan
 *
 */

public class PrintAllPathSumKRoot {

	static void printPathsUtil(Node curr_node, int sum, int sum_so_far, ArrayList<Integer> path) {
		if (curr_node == null)
			return;

// Add the current node's value 
		sum_so_far += curr_node.data;

// Add the value to path 
		path.add(curr_node.data);

// Print the required path 
		if (sum_so_far == sum) {
			System.out.print("Path found: ");
			for (int i = 0; i < path.size(); i++)
				System.out.print(path.get(i) + " ");

			System.out.println();
		}

// If left child exists 
		if (curr_node.left != null)
			printPathsUtil(curr_node.left, sum, sum_so_far, path);

// If right child exists 
		if (curr_node.right != null)
			printPathsUtil(curr_node.right, sum, sum_so_far, path);

// Remove last element from path 
// and move back to parent 
		path.remove(path.size() - 1);
	}

//Wrapper over printPathsUtil 
	static void printPaths(Node root, int sum) {
		ArrayList<Integer> path = new ArrayList<>();
		printPathsUtil(root, sum, 0, path);
	}

//Driver code 
	public static void main(String[] args) {

		/*
		 * 10 / \ 28 13 / \ 14 15 / \ / \ 21 22 23 24
		 */
		Node root = new Node(10);
		root.left = new Node(28);
		root.right = new Node(13);

		root.right.left = new Node(14);
		root.right.right = new Node(15);

		root.right.left.left = new Node(21);
		root.right.left.right = new Node(22);
		root.right.right.left = new Node(23);
		root.right.right.right = new Node(24);

		int sum = 38;

		printPaths(root, sum);
	}
}
