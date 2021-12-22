package tree;

/*
 * Convert a Binary tree to its mirror in-place.
 * O(n)
 */

public class ConvertTreeMirror {

	Node root;
	
	
	Node mirror(Node node) 
    { 
        if (node == null) 
            return node; 
  
        /* do the subtrees */
        Node left = mirror(node.left); 
        Node right = mirror(node.right); 
  
        /* swap the left and right pointers */
        node.left = right; 
        node.right = left; 
  
        return node; 
    } 
	
	void inOrder(Node node) 
    { 
        if (node == null) 
            return; 
  
        inOrder(node.left); 
        System.out.print(node.data + " "); 
  
        inOrder(node.right); 
    } 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* creating a binary tree and entering the nodes */
		ConvertTreeMirror tree = new ConvertTreeMirror(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
  
        /* print inorder traversal of the input tree */
        System.out.println("Inorder traversal of input tree is :"); 
        tree.inOrder(tree.root); 
        
        System.out.println(""); 
  
        /* convert tree to its mirror */
        tree.mirror(tree.root); 
  
        /* print inorder traversal of the minor tree */
        System.out.println("Inorder traversal of binary tree is : "); 
        tree.inOrder(tree.root); 
        

	}

}
