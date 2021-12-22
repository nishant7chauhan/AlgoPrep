package tree;

import java.util.HashMap;

class RandomNode {
	int data;
	RandomNode left,right,random;
	
	RandomNode(int data){
		this.data = data;
		this.left=this.right=this.random=null;
	}
	
}

public class CloneBinaryTreeRandomPonterSet2 {
	
	static HashMap<RandomNode,RandomNode> hm = new HashMap<>();
	
	private static RandomNode cloneTree(RandomNode root, HashMap<RandomNode,RandomNode> hm) {
		
		if(root == null) return null;
		
		hm.put(root, new RandomNode(root.data));
		
		hm.get(root).left = cloneTree(root.left,hm);
		hm.get(root).right = cloneTree(root.right,hm);
		
		// TODO Auto-generated method stub
		return hm.get(root);
	}
	
	
	private static void connectRandomNode(RandomNode root, HashMap<RandomNode, RandomNode> hm) {
		// TODO Auto-generated method stub
		
		if(root == null) return;
		
		hm.get(root).random = hm.get(root.random);
		connectRandomNode(root.left,hm);
		connectRandomNode(root.right,hm);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomNode tree = new RandomNode(1); 
	    tree.left = new RandomNode(2); 
	    tree.right = new RandomNode(3); 
	    tree.left.left = new RandomNode(4); 
	    tree.left.right = new RandomNode(5); 
	    tree.random = tree.left.right; 
	    tree.left.left.random = tree; 
	    tree.left.right.random = tree.right; 
	    
	    System.out.println("Inorder traversal of original binary tree is:" ); 
	    printInorder(tree); 
	    
	    RandomNode clone = cloneTree(tree,hm); 
	    
	    connectRandomNode(tree,hm);
	    
	    
	    System.out.println("\n\nInorder traversal of cloned binary tree is: "); 
	    printInorder(clone); 
		
	}
	





	static void printInorder(RandomNode node) 
	{ 
	    if (node == null) 
	        return; 
	  
	     //First recur on left sutree 
	    printInorder(node.left); 
	  
	     //then print data of Node and its random 
	    System.out.print( "[" + node.data + " "); 
	    if (node.random == null) 
	    System.out.print("null], "); 
	    else
	    	System.out.print(node.random.data + "], "); 
	  
	     //now recur on right subtree 
	    printInorder(node.right); 
	} 

}
