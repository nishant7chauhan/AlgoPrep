package stack;

/**
 * 
 * @author nishantchauhan
 *
 */



public class MinimumReversal {

	// Returns count of minimum reversals for making
	// expr balanced. Returns -1 if expr cannot be
	// balanced.
	static int countMinReversals(String expr) {
		int len = expr.length();

		// length of expression must be even to make
		// it balanced by using reversals.
		if (len % 2 != 0)
			return -1;

		// To store number of reversals required.
		int ans = 0;

		int i;

		// To store number of unbalanced opening brackets.
		int open = 0;

		// To store number of unbalanced closing brackets.
		int close = 0;

		for (i = 0; i < len; i++) {

			// If current bracket is open then increment
			// open count.
			if (expr.charAt(i) == '{')
				open++;

			// If current bracket is close, check if it
			// balances opening bracket. If yes then
			// decrement count of unbalanced opening
			// bracket else increment count of
			// closing bracket.
			else {
				if (open == 0)
					close++;
				else
					open--;
			}
		}

		ans = (close / 2) + (open / 2);

		// For the case: "}{" or when one closing and
		// one opening bracket remains for pairing, then
		// both need to be reversed.
		close %= 2;
		open %= 2;
		if (close != 0)
			ans += 2;

		return ans;
	}

	// Driver Code
	public static void main(String args[]) {
		String expr = "}}{{";

		System.out.println(countMinReversals(expr));
	}

}
