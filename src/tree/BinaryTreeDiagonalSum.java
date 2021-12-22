package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Diagonal sum of binary tree
 * @author nishantchauhan
 * O(n),O(n)
 */


public class BinaryTreeDiagonalSum {

	public void diagonalSum(Node node) {
		if (node == null) {
			return;
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(node);

		while (!q.isEmpty()) {

			int size = q.size();
			int s = 0;
			while (size > 0) {
				Node temp = q.remove();

				while (temp != null) {
					s = s + temp.data;

					if (temp.left != null) {
						q.add(temp.left);
					}

					temp = temp.right;
				}

				size--;
			}

			System.out.println(s);
		}
	}

	public boolean ifLeafNode(Node node) {
		if (node == null) {
			return false;
		}

		if (node.left == null && node.right == null) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {

		BinaryTreeDiagonalSum a = new BinaryTreeDiagonalSum();

		Node root = new Node(2);
		root.left = new Node(4);
		root.left.left = new Node(6);
		root.right = new Node(3);
		root.right.right = new Node(1);
		root.right.left = new Node(5);
		root.right.left.left = new Node(3);
		root.right.left.right = new Node(2);
		root.right.left.left.left = new Node(1);

		a.diagonalSum(root);

	}

}
