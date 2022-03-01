
package tree;

/**
 * Find In order predecessor/successor in BST.
 * @author nishantchauhan
 * O(n)
 */

/**
1. If root is NULL
      then return
2. if key is found then
    a. If its left subtree is not null
        Then predecessor will be the right most 
        child of left subtree or left child itself.
    b. If its right subtree is not null
        The successor will be the left most child 
        of right subtree or right child itself.
    return
3. If key is smaller then root node
        set the successor as root
        search recursively into left subtree
    else
        set the predecessor as root
        search recursively into right subtree
 */


public class InorderSuccessorPredecessor {

	static int successor, predecessor;

	public void successorPredecessor(Node root, int key) {

		// Base case
		if (root == null)
			return;

		// If key is present at root
		if (root.data == key) {
			// the maximum value in left subtree is predecessor
			if (root.left != null) {
				Node tmp = root.left;
				while (tmp.right != null)
					tmp = tmp.right;
				predecessor = tmp.data;
			}

			// the minimum value in right subtree is successor
			if (root.right != null) {
				Node tmp = root.right;
				while (tmp.left != null)
					tmp = tmp.left;
				successor = tmp.data;
			}
			return;
		}

		// If key is smaller than root's key, go to left subtree
		if (root.data > key) {
			successor = root.data;
			successorPredecessor(root.left, key);
		} else // go to right subtree
		{
			predecessor = root.data;
			successorPredecessor(root.right, key);
		}

	}

	public static void main(String args[]) {
		Node root = new Node(20);
		root.left = new Node(10);
		root.right = new Node(30);
		root.left.left = new Node(5);
		root.left.left.right = new Node(7);
		root.left.right = new Node(15);
		root.right.left = new Node(25);
		root.right.right = new Node(35);
		root.left.right.left = new Node(13);
		root.left.right.right = new Node(18);
		InorderSuccessorPredecessor i = new InorderSuccessorPredecessor();
		i.successorPredecessor(root, 10);
		System.out.println("Inorder Successor of 10 is : " + successor + " and predecessor is : " + predecessor);
		i.successorPredecessor(root, 30);
		System.out.println("Inorder Successor of 30 is : " + successor + " and predecessor is : " + predecessor);
	}

}
