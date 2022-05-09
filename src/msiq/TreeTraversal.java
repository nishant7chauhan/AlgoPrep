package msiq;

import java.util.Deque;
import java.util.LinkedList;


public class TreeTraversal {

	public void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	public void preOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public void postOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}

	public void inorderItr(TreeNode root) {
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode node = root;
		while (true) {
			if (node != null) {
				stack.addFirst(node);
				node = node.left;
			} else {
				if (stack.isEmpty()) {
					break;
				}
				node = stack.pollFirst();
				System.out.println(node.data);
				node = node.right;
			}
		}
	}

	public void preOrderItr(TreeNode root) {
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		stack.addFirst(root);
		while (!stack.isEmpty()) {
			root = stack.pollFirst();
			System.out.print(root.data + " ");
			if (root.right != null) {
				stack.addFirst(root.right);
			}
			if (root.left != null) {
				stack.addFirst(root.left);
			}
		}
	}

	public void postOrderItr(TreeNode root) {
		Deque<TreeNode> stack1 = new LinkedList<TreeNode>();
		Deque<TreeNode> stack2 = new LinkedList<TreeNode>();
		stack1.addFirst(root);
		while (!stack1.isEmpty()) {
			root = stack1.pollFirst();
			if (root.left != null) {
				stack1.addFirst(root.left);
			}
			if (root.right != null) {
				stack1.addFirst(root.right);
			}
			stack2.addFirst(root);
		}
		while (!stack2.isEmpty()) {
			System.out.print(stack2.pollFirst().data + " ");
		}
	}

	public void postOrderItrOneStack(TreeNode root) {
		TreeNode current = root;
		Deque<TreeNode> stack = new LinkedList<>();
		while (current != null || !stack.isEmpty()) {
			if (current != null) {
				stack.addFirst(current);
				current = current.left;
			} else {
				TreeNode temp = stack.peek().right;
				if (temp == null) {
					temp = stack.poll();
					System.out.print(temp.data + " ");
					while (!stack.isEmpty() && temp == stack.peek().right) {
						temp = stack.poll();
						System.out.print(temp.data + " ");
					}
				} else {
					current = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
