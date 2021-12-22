package tree;

import java.util.Stack;

/**
 * Level order traversal in spiral form [4]
 * 
 * @author nishant.chauhan O(n) time and O(n) extra space
 */

public class BinaryTreeSpiral {
	Node root;

	private void printSpiral(Node root) {
		// TODO Auto-generated method stub

		if (root == null)
			return;

		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();

		s1.push(root);

		while (!s1.empty() || !s2.empty()) {

			while (!s1.empty()) {
				Node temp = s1.pop();
				
				System.out.print(temp.data + " ");

				if (temp.left != null) {
					s2.push(temp.left);
				}
				if (temp.right != null) {
					s2.push(temp.right);
				}

			}

			while (!s2.empty()) {
				Node temp = s2.pop();
				
				System.out.print(temp.data + " ");

				if (temp.right != null) {
					s1.push(temp.right);
				}

				if (temp.left != null) {
					s1.push(temp.left);
				}

			}

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTreeSpiral tree = new BinaryTreeSpiral();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.left.left.left = new Node(8);
		tree.root.right.right.left = new Node(9);
		tree.root.right.right.right = new Node(10);
		System.out.println("Spiral Order traversal of Binary Tree is ");
		tree.printSpiral(tree.root);

	}

}
