package string;

/**
 * Find i’th index character in a binary string obtained after n iterations
 * (Given a decimal number m, convert it into a binary string and apply n
 * iterations. In each iteration, 0 becomes “01” and 1 becomes “10”. Find the
 * (based on indexing) index character in the string after the nth iteration.)
 * 
 * @author nishant.chauhan O(log Z), where Z is the distance between initially
 *         consecutive bits after N iterations
 */

public class IthBinaryIndexAfterKitration {

	static void KthCharacter(int m, int n, int k) {
// distance between two  
// consecutive elements 
// after N iterations 
		int distance = (int) Math.pow(2, n);
		int Block_number = k / distance;
		int remaining = k % distance;

		int s[] = new int[32];
		int x = 0;

// binary representation of M 
		for (; m > 0; x++) {
			s[x] = m % 2;
			m = m / 2;
		}

// kth digit will be  
// derived from root  
// for sure 
		int root = s[x - 1 - Block_number];

		if (remaining == 0) {
			System.out.println(root);
			return;
		}

// Check whether there is  
// need to flip root or not 
		Boolean flip = true;
		while (remaining > 1) {
			if ((remaining & 1) > 0) {
				flip = !flip;
			}
			remaining = remaining >> 1;
		}

		if (flip) {
			System.out.println((root > 0) ? 0 : 1);
		} else {
			System.out.println(root);
		}
	}

//Driver Code 
	public static void main(String[] args) {
		int m = 5, k = 5, n = 3;
		KthCharacter(m, n, k);
	}

}
