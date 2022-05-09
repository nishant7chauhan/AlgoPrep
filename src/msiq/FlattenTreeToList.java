package msiq;

//TC - O(N) 
//SC - O(N)
//FlattenTreeToLinkList

public class FlattenTreeToList {

	TreeNode prev = null;
	
    public void flatten(TreeNode root) {
        if(root == null) return; 
        
        flatten(root.right); 
        flatten(root.left); 
        
        root.right = prev;
        root.left = null; 
        prev = root; 
    }
	
}
