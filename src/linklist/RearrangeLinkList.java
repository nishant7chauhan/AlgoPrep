package linklist;

/**
 * https://www.geeksforgeeks.org/rearrange-linked-list-alternate-first-last-element/
 * @author nishantchauhan
 * O(n),O(1)
 */


public class RearrangeLinkList {
	 static Node head; // head of the list

	void printlist(Node root) {
		for (Node curPtr = root; curPtr != null; curPtr = curPtr.next) {
			System.out.print("--->" + curPtr.data);
		}
	}

	void rearrange(Node node) {

		// 1) Find the middle point using tortoise and hare method
		Node slow = node, fast = slow.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// 2) Split the linked list in two halves
		// node1, head of first half 1 -> 2 -> 3
		// node2, head of second half 4 -> 5
		Node node1 = node;
		Node node2 = slow.next;
		slow.next = null;

		// 3) Reverse the second half, i.e., 5 -> 4
		node2 = reverselist(node2);

		// 4) Merge alternate nodes
		Node curr = new Node(); // Assign dummy Node

		// curr is the pointer to this dummy Node, which will
		// be used to form the new list
		//Node curr = node;
		while (node1 != null || node2 != null) {

			// First add the element from first list
			if (node1 != null) {
				curr.next = node1;
				curr = curr.next;
				node1 = node1.next;
			}

			// Then add the element from second list
			if (node2 != null) {
				curr.next = node2;
				curr = curr.next;
				node2 = node2.next;
			}
		}

		// Assign the head of the new list to head pointer
		//node = node.next;
	}

	
	static Node reverselist(Node head){
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
		// TODO Auto-generated method stub
		RearrangeLinkList list = new RearrangeLinkList();
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);

		list.printlist(head); // print original list
		list.rearrange(head); // rearrange list as per ques
		System.out.println("");
		list.printlist(head); // print modified list

	}

}
