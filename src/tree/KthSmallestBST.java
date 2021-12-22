package tree;

/**
 * kth smallest element if modification is allowed i BST
 * @author nishantchauhan	
 * O(h) Time Complexity and O(h) auxiliary space
 */


// A BST NodeM 
class NodeM {
	int data;
	NodeM left, right;
	int lCount;

	NodeM(int x) {
		data = x;
		left = right = null;
		lCount = 0;
	}
}

public class KthSmallestBST {

	// Recursive function to insert an key into BST
	public static NodeM insert(NodeM root, int x) {
		if (root == null)
			return new NodeM(x);

		// If a NodeM is inserted in left subtree, then
		// lCount of this NodeM is increased. For simplicity,
		// we are assuming that all keys (tried to be
		// inserted) are distinct.
		if (x < root.data) {
			root.left = insert(root.left, x);
			root.lCount++;
		}

		else if (x > root.data)
			root.right = insert(root.right, x);
		return root;
	}

	// Function to find k'th largest element in BST
	// Here count denotes the number of
	// NodeMs processed so far
	public static NodeM kthSmallest(NodeM root, int k) {
		// base case
		if (root == null)
			return null;

		int count = root.lCount + 1;
		if (count == k)
			return root;

		if (count > k)
			return kthSmallest(root.left, k);

		// else search in right subtree
		return kthSmallest(root.right, k - count);
	}

	// main function
	public static void main(String args[]) {
		NodeM root = null;
		int keys[] = { 20, 8, 22, 4, 12, 10, 14 };

		for (int x : keys)
			root = insert(root, x);

		int k = 4;
		NodeM res = kthSmallest(root, k);
		if (res == null)
			System.out.println("There are less " + "than k NodeMs in the BST");
		else
			System.out.println("K-th Smallest" + " Element is " + res.data);
	}

}
