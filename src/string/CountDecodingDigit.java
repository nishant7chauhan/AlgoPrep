package string;

/**
 * 3. Given a map where. 1->a, 2->b, 3->c and so on till 26->z. Now we are given
 * a number lets say 123. We need to print all possible way to print it in
 * alphabetical form using the map. ex: for 123 we have (abc, Lc) where 12->L.
 * 
 * @author nishantchauhan
 *
 *
 *         O(n) and it requires O(n) auxiliary space //check space and time complexity of fibonacci series
 */

public class CountDecodingDigit {

	// A Dynamic Programming based
	// function to count decodings
	static int countDecodingDP(char digits[], int n) {
		// A table to store results of subproblems
		int count[] = new int[n + 1];
		count[0] = 1; // base case check geeks(0 character and 1 character return 1 count)
		count[1] = 1;
		if (digits[0] == '0') // for base condition "01123" should return 0
			return 0;
		for (int i = 2; i <= n; i++) {
			count[i] = 0;

			// If the last digit is not 0,
			// then last digit must add to
			// the number of words
			if (digits[i - 1] > '0')
				count[i] = count[i - 1];

			// If second last digit is smaller
			// than 2 and last digit is smaller
			// than 7, then last two digits
			// form a valid character
			if (digits[i - 2] == '1' || (digits[i - 2] == '2' && digits[i - 1] < '7'))
				count[i] += count[i - 2];
		}
		return count[n];
	}

	// Driver Code
	public static void main(String[] args) {
		char digits[] = { '1', '2', '3' };
		int n = digits.length;
		System.out.println("Count is " + countDecodingDP(digits, n));
	}

}
