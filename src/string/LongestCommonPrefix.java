package string;

/**
 * 
 * Longest Common Prefix
 * 
 * @author nishantchauhan
 * 
 *         Time complexity : O (S) , where S is the sum of all characters
 *         in all strings
 *
 */

public class LongestCommonPrefix {

	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++)
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				// System.out.print(prefix + " ");
				if (prefix.isEmpty())
					return "";
			}
		return prefix;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = { "flower", "flow", "flight" };

		System.out.print(longestCommonPrefix(strs));
	}

}
