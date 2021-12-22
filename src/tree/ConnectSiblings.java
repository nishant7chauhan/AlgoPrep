package tree;
/**
 * Connect nodes at same level
 * @author nishant.chauhan
 * O(n)
 */


class NodeS {
	public int data;
	public NodeS left;
	public NodeS right;
	public NodeS nextSibling;

	public NodeS(int num) {
		this.data = num;
		this.left = null;
		this.right = null;
		this.nextSibling = null;
	}

	public NodeS() {
		this.left = null;
		this.right = null;
		this.nextSibling = null;
	}

	public static NodeS createNode(int number) {
		return new NodeS(number);
	}
}

class NextSiblingPointer {
	public static void nextSiblingPointer(NodeS node) {
		if (null == node) {
			return;
		}
		// if we have left child
		if (node.left != null) {
			node.left.nextSibling = node.right;
		}

		// if we have right child
		if (node.right != null) {
			// if current node has sibling, then left set
			//
			if (node.nextSibling != null) {
				node.right.nextSibling = node.nextSibling.left;
			} else {
				node.right.nextSibling = null;
			}
		}
		nextSiblingPointer(node.left);
		nextSiblingPointer(node.right);
	}

	public static void printUsingNextSibling(NodeS root) {
		NodeS node = null;
		int level = 0;
		while (root != null) {
			node = root;
			System.out.printf("Level %d data ", level++);
			while (node != null) {
				System.out.printf("%d ", node.data);
				node = node.nextSibling;
			}
			System.out.println("");
			root = root.left;
		}
	}
}

public class ConnectSiblings {

	public static void main(String[] args) {
		/*
		 * 		 1 
		 * 		/  \ 
		 *	   2    3
		 *    / \  / \ 
		 *   4  5 6   7
		 * 
		 */
		NodeS root = NodeS.createNode(1);
		root.left = NodeS.createNode(2);
		root.right = NodeS.createNode(3);

		// left sub tree
		root.left.left = NodeS.createNode(4);
		root.left.right = NodeS.createNode(5);

		// right subtree
		root.right.left = NodeS.createNode(6);
		root.right.right = NodeS.createNode(7);

		NextSiblingPointer.nextSiblingPointer(root);
		NextSiblingPointer.printUsingNextSibling(root);
	}
}
