package linklist;

/**
 *  Reverse every k element set of singly linked list. [done]
	list: 1 2 3 4 5 6 7 8 9, k:3 � output: 7 8 9 4 5 6 1 2 3
	list: a b c d e f g h i j k l, k : 4 � output: i j k l e f g h a b c d
 *  @author nishantchauhan
 *  O(n)
 */


public class ReverseLinkListAndKGroup {

	static void printlist(Node root) {
		for (Node curPtr = root; curPtr != null; curPtr = curPtr.next) {
			System.out.print("--->" + curPtr.data);
		}
	}

	public static Node reverseKgroup(Node root, int k) {

		Node current = root;
		Node prev = null;
		Node next = null;

		int count = 0;

		while (count < k && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		if (current != null) {
			root.next = reverseKgroup(next, k);
		}

		return prev;
	}
	
	static Node normalReverse(Node head){
		
		if(head == null || head.next == null) return head; //empty node and single node;
		
		Node current = head;
		Node next = null;
		Node prev = null;
		
		
		while(current!=null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
		
		return head;
	}

	public static void main(String[] args) {

		Node root = new Node(1);
		root.next = new Node(2);
		root.next.next = new Node(3);
		root.next.next.next = new Node(4);
		root.next.next.next.next = new Node(5);
		root.next.next.next.next.next = new Node(6);
		root.next.next.next.next.next.next = new Node(7);
		root.next.next.next.next.next.next.next = new Node(8);

		printlist(root);
		Node head = reverseKgroup(root, 3);
		System.out.print("\n");
		printlist(head);
		System.out.print("\n");
		Node node = normalReverse(head);
		printlist(node);

	}
}
