package tree;

/**
 * coding simplified
 * 
 */


import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

class NodeH {
	NodeH left, right;
	int data, height;

	public NodeH(int data) {
		this.data = data;
		left = right = null;
	}
}

public class BinaryTreeTopView {

	public void topView(NodeH NodeH) {
		if (NodeH == null) {
			return;
		}

		TreeMap<Integer, Integer> m = new TreeMap<Integer, Integer>();

		Queue<NodeH> q = new LinkedList<NodeH>();
		q.add(NodeH);

		while (!q.isEmpty()) {
			NodeH temp = q.remove();
			int hd = temp.height;

			if (m.get(hd) == null) {
				m.put(hd, temp.data);
			}

			if (temp.left != null) {
				temp.left.height = hd - 1;
				q.add(temp.left);
			}

			if (temp.right != null) {
				temp.right.height = hd + 1;
				q.add(temp.right);
			}
		}
		System.out.println(m.values());
	}

	public static void main(String[] args) {

		BinaryTreeTopView a = new BinaryTreeTopView();

		NodeH root = new NodeH(2);
		root.left = new NodeH(7);
		root.right = new NodeH(5);
		root.left.right = new NodeH(6);
		root.left.right.left = new NodeH(5);
		root.left.right.left.left = new NodeH(10);
		root.left.right.right = new NodeH(11);
		root.right.right = new NodeH(9);

		a.topView(root);

	}
}
