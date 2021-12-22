package linklist;

/**
 * Clone a linked list with Next and Random pointer.Given the solution using O(1) extra space (using hashmap). 2 (3+2).[done]
 * @author nishant.chauhan
 * O(n) and O(1)
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

		curr = head;
		LinkedListRandomNode dummyHead = new LinkedListRandomNode(0);
		LinkedListRandomNode cloneListCurr = dummyHead;
		LinkedListRandomNode copy = null;
		while (curr != null) {

			next = curr.next.next;
			// curr.next is curr's clone. Let's reference to it
			copy = curr.next;
			// Append the copy to the final list tail
			cloneListCurr.next = copy;
			cloneListCurr = copy;
			// Restore curr (the original node's) next value
			curr.next = next;
			// Advance curr to the stashed next
			curr = next;
		}

		return dummyHead.next;
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
