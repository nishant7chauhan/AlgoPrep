package string;

/**
 * 21.Given a string, find the longest substring which is palindrome.(2)
 * 
 * @author nishant.chauhan
 * 
 *         Time complexity: O(n^2). Two nested traversals are needed. Auxiliary
 *         Space: O(1).
 *
 */

public class LongestPalinSubstringSet2 {

	public static String longestPalenSubstr(String str) {
		// TODO Auto-generated method stub

		if (str == null || str.length() < 1)
			return "";

		int start = 0;
		int end = 0;

		for (int i = 0; i < str.length(); i++) {
			int len1 = expandFromMiddle(str, i, i);
			int len2 = expandFromMiddle(str, i, i + 1);

			int len = Math.max(len1, len2);

			if (len > end - start) {
				start = i - ((len - 1) / 2);
				end = i + (len / 2);
			}

		}

		return str.substring(start, end + 1);

	}

	public static int expandFromMiddle(String s, int left, int right) {

		if (s == null || left > right)
			return 0;

		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;

		}

		return right - left - 1; // correct -1 as left and right indexed has moved so need to subtract
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "forgeeksskeegfor";
		System.out.println("Length is: " + longestPalenSubstr(str));

	}

}
