package tree;

import java.util.List;
import java.util.ArrayList;

/**
 * Find triplet whose sum is given sum(same approach for sum = 0 )
 * @author IN006166
 * O(n2),O(n)
 */


public class TripletSum {

	public boolean checkIfPairExists(Node node, int sum) {
		List<Integer> list = new ArrayList<>();
		inorder(node, list);
		return checkIfPairExistsUtil(sum, list);
	}

	public void inorder(Node node, List<Integer> list) {
		if (node == null) {
			return;
		}

		inorder(node.left, list);

		list.add(node.data);

		inorder(node.right, list);
	}

	private boolean checkIfPairExistsUtil(int sum, List<Integer> list) {
		int elementSize = list.size();

		for (int i = 0; i < elementSize - 2; i++) {
			int start = i + 1;
			int end = elementSize - 1;

			while (start < end) {
				int currentSum = list.get(i) + list.get(start) + list.get(end);

				if (currentSum == sum) {
					System.out.print("[" + list.get(i)+ "," + list.get(start) + "," + list.get(end) + "]");
					return true;
				} else if (currentSum < sum) {
					start++;
				} else {
					end--;
				}
			}

		}

		return false;
	}

	public Node insert(Node node, int val) {
		if (node == null) {
			return new Node(val);
		}

		if (val < node.data) {
			node.left = insert(node.left, val);
		} else if ((val > node.data)) {
			node.right = insert(node.right, val);
		}

		return node;
	}

	public static void main(String[] args) {
		TripletSum a = new TripletSum();
		Node root = null;

		root = a.insert(root, 8);
		root = a.insert(root, 15);
		root = a.insert(root, 6);
		root = a.insert(root, 2);
		root = a.insert(root, 7);

		System.out.println(a.checkIfPairExists(root, 29));
	}

}
