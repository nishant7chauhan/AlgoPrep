package linklist;

/**
 * Flatten a link list level wise
 * 
 * @author nishantchauhan O(n)
 */

public class FlattenLinkList {

	public NodeRandom flattenEasy(NodeRandom NodeRandom) {
		if (NodeRandom == null) {
			return NodeRandom;
		}

		NodeRandom start, end;
		start = end = NodeRandom;

		while (end.next != null) {
			end = end.next;
		}

		while (start != null) {
			if (start.random != null) {
				end.next = start.random;
				end = end.next;

				while (end.next != null) {
					end = end.next;
				}
			}
			start = start.next;
		}

		return NodeRandom;
	}

	public void printList(NodeRandom NodeRandom) {
		if (NodeRandom == null) {
			return;
		}

		while (NodeRandom != null) {
			System.out.print(NodeRandom.data + " ");
			NodeRandom = NodeRandom.next;
		}

	}

	public NodeRandom createList(int arr[]) {
		NodeRandom head = new NodeRandom();
		NodeRandom node = head;

		for (int i = 0; i < arr.length; i++) {
			node.next = new NodeRandom(arr[i]);
			node = node.next;
		}

		return head.next;
	}

	public static void main(String[] args) {

		FlattenLinkList a = new FlattenLinkList();

		NodeRandom root1, root2, root3, root4, root5;

		int arr1[] = new int[] { 1, 2, 3, 4, 5 };
		int arr2[] = new int[] { 6, 7, 8 };
		int arr3[] = new int[] { 9, 10 };
		int arr4[] = new int[] { 11 };
		int arr5[] = new int[] { 12 };

		root1 = a.createList(arr1);
		root2 = a.createList(arr2);
		root3 = a.createList(arr3);
		root4 = a.createList(arr4);
		root5 = a.createList(arr5);

		root1.random = root2;
		root1.next.next.next.random = root3;
		root2.next.random = root4;
		root3.random = root5;

		// root1 = a.flattenEasy(root1);

		/*
		 * nishant edit a.printList(root1); System.out.print("\n"); a.printList(root2);
		 * System.out.print("\n"); a.printList(root3); System.out.print("\n");
		 * a.printList(root4); System.out.print("\n"); a.printList(root5);
		 */

		root1 = a.flattenEasy(root1);
		a.printList(root1);
	}
}
