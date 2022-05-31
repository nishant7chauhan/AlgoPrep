package string;

/**
 * Longest Substring Without Repeating Characters
 * 
 * @author nishantchauhan
 * 
 * O(n)
 *
 */

public class LongestSubstringWithOutRepeatingChar {
	static String result = "";

	public static int longestUniqueSubsttr(String str) {
		String test = "";
		

		// Result
		int maxLength = -1;

		// Return zero if string is empty
		if (str.isEmpty()) {
			return 0;
		}
		// Return one if string length is one
		else if (str.length() == 1) {
			return 1;
		}
		for (char c : str.toCharArray()) {
			String current = String.valueOf(c);

			// If string already contains the character
			// Then substring after repeating character
			if (test.contains(current)) {
				test = test.substring(test.indexOf(current) + 1);
			}
			test = test + current;
			
			if(test.length() > maxLength ) {
			maxLength = test.length();
			result = test;
			}
		}

		return maxLength;
	}

	// Driver code
	public static void main(String[] args) {
		String str = "geeksforgeeks";
		System.out.println("The input string is " + str);

		int len = longestUniqueSubsttr(str);
		System.out.println("The length of the longest " + "non-repeating character " + "substring is: " + result + " length: "+ len);
	}

}
