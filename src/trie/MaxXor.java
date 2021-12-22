package trie;

/**
 * 63.Given a non-empty array of numbers, a0, a1, a2, …, an-1, where 0 ? ai <
 * 231. [done] Find the maximum result of ai XOR aj, where 0 ? i, j < n. O(N)
 * complexity was expected Example: Input: [3, 10, 5, 25, 2, 8] Output: 28
 * Explanation: The maximum result is 5 ^ 25 = 28.
 * 
 * @author nishantchauhan
 *
 *
 *O(32*N)
 */

public class MaxXor {

	// Structure of Trie
	static class node {
		node left;
		node right;
	};

	// Function to insert binary
	// representation of element x
	// in the Trie
	static void insert(int x, node head) {

		// Store the head
		node curr = head;

		for (int i = 30; i >= 0; i--) {

			// Find the i-th bit
			int val = (x >> i) & 1;

			if (val == 0) {

				// If curr.left is null
				if (curr.left == null)
					curr.left = new node();

				// Update curr to curr.left
				curr = curr.left;
			} else {

				// If curr.right is null
				if (curr.right == null)
					curr.right = new node();

				// Update curr to curr.right
				curr = curr.right;
			}
		}
	}

	// Function that finds the maximum
	// Bitwise XOR value for all such pairs
	static int findMaximumXOR(int arr[], int n) {

		// head Node of Trie
		node head = new node();

		// Insert each element in trie
		for (int i = 0; i < n; i++) {
			insert(arr[i], head);
		}

		// Stores the maximum XOR value
		int ans = 0;

		// Traverse the given array
		for (int i = 0; i < n; i++) {

			// Stores the XOR with current
			// value arr[i]
			int curr_xor = 0;

			int M = (int) Math.pow(2, 30);

			node curr = head;

			for (int j = 30; j >= 0; j--) {

				// Finding ith bit
				int val = (arr[i] >> j) & 1;

				// Check if the bit is 0
				if (val == 0) {

					// If right node exists
					if (curr.right != null) {

						// Update the currentXOR
						curr_xor += M;
						curr = curr.right;
					} else {
						curr = curr.left;
					}
				}

				else {

					// Check if left node exists
					if (curr.left != null) {

						// Update the currentXOR
						curr_xor += M;
						curr = curr.left;
					} else {
						curr = curr.right;
					}
				}

				// Update M to M/2 for next set bit
				M /= 2;
			}

			// Update the maximum XOR
			ans = Math.max(ans, curr_xor);
		}

		// Return the maximum XOR found
		return ans;
	}

	// Driver Code
	public static void main(String[] args) {

		// Given array arr[]
		int arr[] = { 1, 2, 3, 4 };

		int N = arr.length;

		// Function call
		System.out.print(findMaximumXOR(arr, N));
	}

}
