package tree;

import java.util.ArrayList;
import java.util.List;
/**
 *  find path in the tree such that the sum of nodes in path is equal to given K
 * 
 * @author nishantchauhan
 *
 *
 */


public class PrintAllPathSumK {

	List<Integer> elements = new ArrayList<Integer>();

	public void printKPathEqualToSum(Node node, int val) {
		if (node == null) {
			return;
		}

		elements.add(node.data);

		printKPathEqualToSum(node.left, val);
		printKPathEqualToSum(node.right, val);

		int sum = 0;

		for (int i = elements.size() - 1; i >= 0; i--) {

			sum = sum + elements.get(i);

			if (sum == val) {

				for (int j = i; j < elements.size(); j++) {
					System.out.print(elements.get(j) + " ");
				}

				System.out.println();
			}
		}

		elements.remove(elements.size() - 1);
	}


	public static void main(String[] args) {

		PrintAllPathSumK a = new PrintAllPathSumK();

		Node root = new Node(2);
		root.left = new Node(4);
		root.left.left = new Node(1);
		root.left.right = new Node(6);
		root.right = new Node(5);
		root.right.right = new Node(7);

		a.printKPathEqualToSum(root, 6);

	}
}
