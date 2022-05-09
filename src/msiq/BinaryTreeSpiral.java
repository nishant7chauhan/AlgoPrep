package msiq;

import java.util.Stack;

/**
 * Level order traversal in spiral form [4]
 * 
 * @author nishant.chauhan O(n) time and O(n) extra space
 */

public class BinaryTreeSpiral {
	TreeNode root;

	private void printSpiral(TreeNode root) {
		// TODO Auto-generated method stub

		if (root == null)
			return;

		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();

		s1.push(root);

		while (!s1.empty() || !s2.empty()) {

			while (!s1.empty()) {
				TreeNode temp = s1.pop();
				
				System.out.print(temp.data + " ");

				if (temp.left != null) {
					s2.push(temp.left);
				}
				if (temp.right != null) {
					s2.push(temp.right);
				}

			}

			while (!s2.empty()) {
				TreeNode temp = s2.pop();
				
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
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(7);
		tree.root.left.left.left = new TreeNode(8);
		tree.root.right.right.left = new TreeNode(9);
		tree.root.right.right.right = new TreeNode(10);
		System.out.println("Spiral Order traversal of Binary Tree is ");
		tree.printSpiral(tree.root);

	}

}
