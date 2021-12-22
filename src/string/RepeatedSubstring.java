package string;

/**
 * Repeated Substring Pattern( can be constructed by taking a substring of it and appending multiple copies of the substring together)
 * @author nishantchauhan
 * O(n) KMP
 */


public class RepeatedSubstring {

	// A utility function to fill lps[] or compute
	// prefix function used in KMP string matching

	public static void computeLPSArray(char pattern[], int lps[]) {
		int index = 0;
		for (int i = 1; i < pattern.length;) {
			if (pattern[i] == pattern[index]) {
				lps[i] = index + 1;
				index++;
				i++;                                      //This is same as KMP (Tushar)
			} else {
				if (index != 0) {
					index = lps[index - 1];
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}
	}

	// Returns true if str is repetition of one of its substrings else return false.
	static boolean isRepeat(String str) {
		// Find length of string and create an array to store lps values used in KMP
		int n = str.length();
		int lps[] = new int[n];
		// Preprocess the pattern (calculate lps[] array)
		computeLPSArray(str.toCharArray(), lps);
		// Find length of longest suffix
		// which is also prefix of str.
		int len = lps[n - 1];
		// If there exist a suffix which is also prefix AND Length of the remaining
		// substring divides total length, then str[0..n-len-1]is the substring that
		// repeats n/(n-len) times (Readers can print substring and value of n/(n-len)
		// for more clarity.
		return (len > 0 && n % (n - len) == 0) ? true : false;
	}

	// Driver program to test above function
	public static void main(String[] args) {
		String txt[] = { "ABCABC", "ABABAB", "ABCDABCD", "GEEKSFORGEEKS", "GEEKGEEK", "AAAACAAAAC", "ABCDABC" };
		int n = txt.length;
		for (int i = 0; i < n; i++) {
			if (isRepeat(txt[i]) == true)
				System.out.println("True");
			else
				System.out.println("False");
		}
	}

}
