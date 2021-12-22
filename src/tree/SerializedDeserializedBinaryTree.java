package tree;
import java.util.ArrayList;

/**
 * Serialize and Deserialize a Binary Tree
 * @author nishantchauhan
 * O(n), space O(n+1) for leaf node markers
 */

public class SerializedDeserializedBinaryTree {

	static ArrayList<Integer> array = new ArrayList<Integer>();
	int  index = 0;
	
	
	public void PreOrder(Node root) {
		
		if(root == null){
			return;
		}
		
		System.out.print(" " + root.data);
		PreOrder(root.left);
		PreOrder(root.right);
		
	}
	
	public void Serialized(Node root) {
		
		if(root == null){
			array.add(-1);
			return;
		}
		array.add(root.data);
		Serialized(root.left);
		Serialized(root.right);
		
	}
	
	public Node DeSerialized(ArrayList<Integer> array) {

		if(index == array.size() || array.get(index) == -1) {
			index++;
			return null;
		}
		
		Node root = new Node(array.get(index++));
		root.left = DeSerialized(array);
		root.right = DeSerialized(array);
		
		return root;
	}
	
	public static void main(String args[]) {
		
		SerializedDeserializedBinaryTree obj = new SerializedDeserializedBinaryTree();
		Node root = new Node(7);
		root.left = new Node(2);
		root.left.left = new Node(1);
		root.right = new Node(5);
		root.right.left = new Node(3);
		root.right.right = new Node(8);
		
		System.out.print("PreOrder: ");
		obj.PreOrder(root);
		
		System.out.print("\n"+ "Serialized: ");
		obj.Serialized(root);
		for(int i=0; i<array.size();i++) {
			System.out.print(" " + array.get(i));
		}
		
		System.out.print("\n"+ "DeSerialized: ");
		Node root1 = obj.DeSerialized(array);
		obj.PreOrder(root1);
		
	}

}