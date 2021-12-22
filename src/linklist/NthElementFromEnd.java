package linklist;

/**
 * Find Nth element from end
 * @author nishant.chauhan
 * O(n)
 */

public class NthElementFromEnd {

	Node head; // head of the list 
	  
    /* Function to get the nth node from end of list */
    void printNthFromLast(int n) 
    { 
        Node main_ptr = head; 
        Node ref_ptr = head; 
  
        int count = 0; 
        if (head != null) { 
            while (count < n) { 
                if (ref_ptr == null) { 
                    System.out.println(n + " is greater than the no "
                                       + " of nodes in the list"); 
                    return; 
                } 
                ref_ptr = ref_ptr.next; 
                count++; 
            } 
            while (ref_ptr != null) { 
                main_ptr = main_ptr.next; 
                ref_ptr = ref_ptr.next; 
            } 
            System.out.println("Node no. " + n + " from last is " + main_ptr.data); 
        } 
    } 
  

  
    /*Driver program to test above methods */
    public static void main(String[] args) 
    { 
    	NthElementFromEnd list = new NthElementFromEnd(); 
        list.head = new Node(20);
        list.head.next = new Node(4);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(35);
  
        list.printNthFromLast(4); 
    } 
	
}
