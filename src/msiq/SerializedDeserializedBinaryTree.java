package msiq;
import java.util.ArrayList;

/**
 * Serialize and Deserialize a Binary Tree
 * @author nishantchauhan
 * O(n), space O(n+1) for leaf node markers
 */

public class SerializedDeserializedBinaryTree {

	static ArrayList<Integer> array = new ArrayList<Integer>();
	int  index = 0;
	
	
	public void PreOrder(TreeNode root) {
		
		if(root == null){
			return;
		}
		
		System.out.print(" " + root.data);
		PreOrder(root.left);
		PreOrder(root.right);
		
	}
	
	public void Serialized(TreeNode root) {
		
		if(root == null){
			array.add(-1);
			return;
		}
		array.add(root.data);
		Serialized(root.left);
		Serialized(root.right);
		
	}
	
	public TreeNode DeSerialized(ArrayList<Integer> array) {

		if(index == array.size() || array.get(index) == -1) {
			index++;
			return null;
		}
		
		TreeNode root = new TreeNode(array.get(index++));
		root.left = DeSerialized(array);
		root.right = DeSerialized(array);
		
		return root;
	}
	
	public static void main(String args[]) {
		
		SerializedDeserializedBinaryTree obj = new SerializedDeserializedBinaryTree();
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.right = new TreeNode(5);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(8);
		
		System.out.print("PreOrder: ");
		obj.PreOrder(root);
		
		System.out.print("\n"+ "Serialized: ");
		obj.Serialized(root);
		for(int i=0; i<array.size();i++) {
			System.out.print(" " + array.get(i));
		}
		
		System.out.print("\n"+ "DeSerialized: ");
		TreeNode root1 = obj.DeSerialized(array);
		obj.PreOrder(root1);
		
	}

}