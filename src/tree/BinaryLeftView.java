package tree;

/**
 * Left View Of Binary Tree.
 * @author nishantchauhan
 * O(n), O(n)
 */

public class BinaryLeftView {

	
	int maxLevel;
	  
	  public void leftViewOfTree(Node node, int level) {
	    if(node == null) {
	      return;
	    }
	    
	    if(level >= maxLevel) {
	      System.out.print(node.data + " ");
	      maxLevel++;
	    }
	    
	    leftViewOfTree(node.left, level + 1);
	    leftViewOfTree(node.right, level + 1);
	  }
	  

	  public static void main(String[] args) {

		  BinaryLeftView a = new BinaryLeftView();

	    Node root = new Node(2);
	    root.left = new Node(7);
	    root.right = new Node(5);
	    root.left.left = new Node(2);
	    root.left.right = new Node(6);
	    root.left.right.left = new Node(5);
	    root.left.right.right = new Node(11);
	    root.right.right = new Node(9);
	    root.right.right.left = new Node(4);

	    a.leftViewOfTree(root, 0);
	  }
	
	
}
