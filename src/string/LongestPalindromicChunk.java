package string;

/**
 * Longest Possible Chunked Palindrome. https://www.geeksforgeeks.org/longest-possible-chunked-palindrome/
 * @author nishantchauhan
 * O(n/2)
 */


public class LongestPalindromicChunk {

	// Here s is the string whose LCP is needed
	// ln is length of string evaluated till now
	// and str is original string
	private static int LPCRec(String curr_str, int count, int len, String str) {
		// if there is noting at all!!
		if (curr_str == null || curr_str.isEmpty())
			return (0);

		// if a single letter is left out
		if (curr_str.length() <= 1) {
			if (count != 0 && str.length() - len <= 1)
				return (count + 1);
			else
				return (1);
		}

		// for each length of substring chunk in string
		int n = curr_str.length();
		for (int i = 0; i < n / 2; i++) {
			// if left side chunk and right side chunk
			// are same
			if (curr_str.substring(0, i + 1).equals(curr_str.substring(n - 1 - i, n))) {
				// Call LCP for the part between the
				// chunks and add 2 to the result.
				// Length of string evaluated till
				// now is increased by (i+1)*2
				return LPCRec(curr_str.substring(i + 1, n - 1 - i), count + 2, len+(i + 1) * 2, str);
			}
		}

		return count + 1;
	}

	// Wrapper over LPCRec()
	public static int LPC(String str) {
		return LPCRec(str, 0, 0, str);
	}

	// driver function
	public static void main(String[] args) {
		System.out.println("V : " + LPC("V"));
		System.out.println("VOLVO : " + LPC("VOLVO"));
		System.out.println("VOLVOV : " + LPC("VOLVOV"));
		System.out.println("ghiabcdefhelloadamhelloabcdefghi : " + LPC("ghiabcdefhelloadamhelloabcdefghi"));

		System.out.println("ghiabcdefhelloadamhelloabcdefghik : " + LPC("ghiabcdefhelloadamhelloabcdefghik"));

		System.out.println("antaprezatepzapreanta : " + LPC("antaprezatepzapreanta"));
	}

}
