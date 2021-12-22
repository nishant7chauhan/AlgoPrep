package dp;

/**
 * 21.Given a string, find the longest substring which is palindrome.(2)
 * 
 * @author nishant.chauhan
 * 
 *         Time complexity: O(n^2). Two nested traversals are needed. Auxiliary
 *         Space: O(n^2). Matrix of size n*n is needed to store the dp array.
 *
 */

public class LongestPalinSubstringSet1 {
	// A utility function to print
	// a substring str[low..high]
	static void printSubStr(String str, int low, int high) {
		System.out.println(str.substring(low, high));
	}

	// This function prints the longest
	// palindrome substring of str[].
	// It also returns the length of the
	// longest palindrome
	static int longestPalSubstr(String str) {

		boolean T[][] = new boolean[str.length()][str.length()];

		// All substrings of length 1 are palindromes
		int maxLength = 1;
		for (int i = 0; i < str.length(); i++) {
			T[i][i] = true;
		}
		int start = 0;
		for (int l = 2; l <= str.length(); l++) {
			for (int i = 0; i <= str.length() - l; i++) {
				int j = i + l - 1;
				if (l == 2 && str.charAt(i) == str.charAt(j)) { // check for sub-string of length 2
					T[i][j] = true;
					start = i;
					maxLength = 2;
				} else if (T[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
					T[i][j] = true;
					if (l > maxLength) {
						start = i;
						maxLength = l;
					}
				}
			}
		}

		System.out.print("Longest palindrome substring is; ");
		// System.out.print("start " + start + " length: "+ maxLength);
		printSubStr(str, start, start + maxLength);

		// return length of LPS
		return maxLength;// to convert index to length
	}

	// Driver program to test above functions
	public static void main(String[] args) {

		String str = "forgeeksskeegfor";
		System.out.println("Length is: " + longestPalSubstr(str));
	}
}
