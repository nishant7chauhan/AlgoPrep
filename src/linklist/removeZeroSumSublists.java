package linklist;

import java.util.HashMap;

public class removeZeroSumSublists {

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode removeZeroSumSublists(ListNode head) {
		HashMap<Integer, ListNode> map = new HashMap<>();

		map.put(0, new ListNode(-1));
		map.get(0).next = head;

		ListNode temp = head;
		int sum = 0;
		while (temp != null) {
			sum += temp.val;

			// Sum value is coming again, there is subarray with sum zero, remove all these
			// nodes
			if (map.containsKey(sum)) {
				ListNode node = map.get(sum);
				ListNode next = node.next;

				int auxSum = sum;
				while (next != temp) {
					auxSum += next.val;
					map.remove(auxSum);
					next = next.next;
				}
				node.next = temp.next;
			} else {
				map.put(sum, temp);
			}

			temp = temp.next;
		}

		return map.get(0).next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
