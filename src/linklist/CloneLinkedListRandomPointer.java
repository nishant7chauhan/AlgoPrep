package linklist;

/**
 * Clone a linked list with Next and Random pointer.Given the solution using
 * O(1) extra space (using hashmap). 2 (3+2).[done]
 * 
 * @author nishant.chauhan O(n) and O(1)
 */

public class CloneLinkedListRandomPointer {

	public static LinkedListRandomNode copyRandomList(LinkedListRandomNode head) {
		LinkedListRandomNode curr = head;
		LinkedListRandomNode next = null;

		while (curr != null) {
			// Stash the next value of the current node so we do not lose it
			next = curr.next;
			LinkedListRandomNode copy = new LinkedListRandomNode(curr.data);
			curr.next = copy;
			copy.next = next;
			// Advance to next node in the original list
			curr = next;
		}

		// Second pass: Reset curr to the head of the original list.
		curr = head;
		while (curr != null) {
			if (curr.random != null) {
				curr.next.random = curr.random.next;
			}
			curr = curr.next.next;
		}

		// Third pass: Our goal is to restore the original list, and extract the copy
		// list.

		LinkedListRandomNode original = head;

		LinkedListRandomNode copy = head.next;
		LinkedListRandomNode tempHead = copy;
		while (original != null) {

			original.next = original.next.next;

			copy.next = (copy.next != null) ? copy.next.next : copy.next;

			original = original.next;
			copy = copy.next;

		}

		return tempHead;
	}

	public static void printList(LinkedListRandomNode list) {
		System.out.print("LinkedList: ");
		for (LinkedListRandomNode currNode = list; currNode != null; currNode = currNode.next) {

			System.out.print("[" + currNode.data + " ");
			if (currNode.random == null)
				System.out.print("null], ");
			else
				System.out.print(currNode.random.data + "], ");

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedListRandomNode node = new LinkedListRandomNode(3);
		node.next = new LinkedListRandomNode(6);
		node.next.next = new LinkedListRandomNode(1);
		node.next.next.next = new LinkedListRandomNode(5);
		node.random = node.next.next;
		node.next.next.next.random = node.next;

		printList(node);

		printList(copyRandomList(node));

	}

}
