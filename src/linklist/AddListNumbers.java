package linklist;

/**
 * Add Two Numbers Represented by Linked Lists
 * @author nishant.chauhan
 *O(max(m, n)) where m and n are number of nodes in list l1 and list l2 respectively.
 *O(1)
 */

public class AddListNumbers {

	Node head;

	
	// Helper function to traverse 
    void traverse(Node head)  
    { 
        while(head != null) 
        { 
            System.out.print(head.data + "->"); 
            head = head.next; 
        } 
    } 
	
	void insert(int x) {

		Node temp = new Node(x);
		if (head == null)
			head = temp;
		else {
			temp.next = head;
			head = temp;
		}
	}

	 static Node reverse(Node head){
		
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

	// Function to add two lists 
    public static Node sum(Node l1, Node l2) 
    { 
        if(l2 == null) return l1; 
        if(l1 == null) return l2; 
  
        // reverse l1 list 
        l1 = reverse(l1); 
  
        // reverse l2 list 
        l2 = reverse(l2); 
  
        // storing head whose reverse is to be returned 
        // This is where which will be final node 
        Node head = l1; 
        Node prev = null; 
        int c = 0,sum; 
        while(l1 != null && l2 != null) 
        { 
            sum = c + l1.data + l2.data; 
            l1.data = sum % 10; 
            c = sum / 10; 
            prev = l1; 
            l1 = l1.next; 
            l2 = l2.next; 
        } 
  
        if(l1 != null||l2 != null) 
        { 
            if(l2 != null) prev.next = l2; 
            l1 = prev.next; 
            while(l1 != null) 
            { 
                sum = c + l1.data; 
                l1.data = sum % 10; 
                c = sum / 10; 
                prev = l1; 
                l1 = l1.next; 
            } 
        } 
        if(c > 0) prev.next = new Node(c); 
        return reverse(head); 
    } 
    
	
	public static void main(String[] args) {
		AddListNumbers l1 = new AddListNumbers();
		l1.insert(3);
		l1.insert(6);
		l1.insert(5);
		AddListNumbers l2 = new AddListNumbers();
		l2.insert(2);
		l2.insert(4);
		l2.insert(8);
		AddListNumbers l3 = new AddListNumbers();
		Node head = sum(l1.head, l2.head);
		l3.traverse(head);
		System.out.print("Null");
	}
}
