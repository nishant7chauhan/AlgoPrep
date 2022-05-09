package msoa;

/**
 * Given a binary tree root, a node X in the tree is named good if in the path
 * from root to X there are no nodes with a value greater than X.
 * 
 * Return the number of good nodes in the binary tree.
 * 
 * 
 * @author nishantchauhan
 *
 */

class TreeNode{
	int val;
	TreeNode left,right;
	
	TreeNode(int val){
		this.val = val;
		left = right = null;
	}
}

public class GoodNodes {	
	int count = 0;

	public int goodNodes(TreeNode root) {
		goodNode(root, root.val);
		return count;
	}

	public void goodNode(TreeNode x, int ref) {
		if (x == null)
			return;
		if (x.val >= ref) {
			count++;
			ref = x.val;
		}
		goodNode(x.left, ref);
		goodNode(x.right, ref);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//GoodNodes obj = new GoodNodes();
		
		TreeNode node = new TreeNode(5);
		node.left = new TreeNode(1);
		node.right = new TreeNode(3);
				
		
	}

}
