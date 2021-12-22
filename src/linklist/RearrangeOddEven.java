package linklist;


/**
 * Rearrange a LinkedList –	Before : a->x->b->y->c->z After : a->b->c->x->y->z
 * @author nishantchauhan
 * O(n),O(1)
 */


public class RearrangeOddEven {
	static Node head; // head of the list

	void printlist(Node root) {
		for (Node curPtr = root; curPtr != null; curPtr = curPtr.next) {
			System.out.print("--->" + curPtr.data);
		}
	}

	private void rearrange(Node head) {
		// TODO Auto-generated method stub

		// if(head == null) return null; base condition

		Node odd = head;
		Node even = head.next;
		Node evenHead = even;

		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}

		odd.next = evenHead;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RearrangeOddEven list = new RearrangeOddEven();
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
