package linklist;

/**
 * 
 * @author nishantchauhan
 * Reverse linklist normal and recursive
 * O(n) , O(1)
 */


public class ReverseLinkList {
	
	
	static void printlist(Node root) {
		for (Node curPtr = root; curPtr != null; curPtr = curPtr.next) {
			System.out.print("--->"+ curPtr.data);
		}
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
	
	
	static Node recursiveReverse(Node head) {
		
		if(head == null || head.next == null) return head; //empty node and single node;
		
		Node newHead = recursiveReverse(head.next);
		
		head.next.next = head;
		head.next = null;
		
		return newHead;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next = new Node(8);
		
		printlist(head);
		System.out.println("\n"); 
		
		//head = normalReverse(head);
		head = recursiveReverse(head);
		
		printlist(head);
		
		
		
	}

}
