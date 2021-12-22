package linklist;
/**
 * reverse linklist k group
 * @author nishantchauhan
 * O(n),O(1)
 */
public class ReverseLinkListKGroup {

	static void printlist(Node root) {
		for (Node curPtr = root; curPtr != null; curPtr = curPtr.next) {
			System.out.print("--->"+ curPtr.data);
		}
	}
	
	public static Node reverseKgroup(Node root, int k){
		
		Node current = root;
		Node prev = null;
		Node next = null;
		
		int count = 0;
		
		while(count < k && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}
		
		if(current!=null) {
			root.next = reverseKgroup(next,k);
		}
		
		return prev;
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
		Node head = reverseKgroup(root,3);
		System.out.print("\n");
		printlist(head);
		
		
	}
	
}
