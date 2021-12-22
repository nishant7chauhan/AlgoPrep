package tree;

import java.util.Stack;


/**
 * find pair sum in bst
 * @author IN006166
 * O(n),O(logn)
 */



public class PairWithGivenSumBSTLogn {

	private static boolean isPairWithSumPresent(Node root, int sum) {
		// TODO Auto-generated method stub
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		Node cur1 = root;
		Node cur2 = root;

		while (cur1 != null || !stack1.isEmpty() || cur2 != null || !stack2.isEmpty()) {

			while (cur1 != null) {
				stack1.push(cur1);
				cur1 = cur1.left;
			}
			while (cur2 != null) {
				stack2.push(cur2);
				cur2 = cur2.right;
			}

			cur1 = stack1.pop();
			cur2 = stack2.pop();
			// root reached so no pair with sum exists
			if (cur1.data == cur2.data)
				return false;
			// pair found
			if (cur1.data + cur2.data == sum) {
				System.out.println(cur1.data + "," + cur2.data);
				return true;
			}
			// pair sum is more so only let cur2 traverse
			else if (cur1.data + cur2.data > sum) {
				cur2 = cur2.left;
				stack1.push(cur1);
				cur1 = null;
			} // pair sum is less so only let cur1 traverse
			else {
				cur1 = cur1.right;
				stack2.push(cur2);
				cur2 = null;
			}
		}
		// code should never reach here.
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node root = new Node(15);
		root.left = new Node(10);
		root.right = new Node(20);
		root.left.left = new Node(9);
		root.left.right = new Node(12);
		root.right.left = new Node(16);
		root.right.right = new Node(25);

		// change sum to test
		int sum = 28;
		System.out.println("Pair present: " + isPairWithSumPresent(root, sum));

	}

}
