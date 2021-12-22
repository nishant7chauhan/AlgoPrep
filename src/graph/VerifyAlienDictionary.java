package graph;

/**
 * check if given dictionary is sorted lexographically  in alien language (valid)
 * 
 * @author nishant.chauhan
 *
 *
 *         O(N*min length of string)
 */
public class VerifyAlienDictionary {

	static int[] order_map;

	private static boolean alienOrderUtil(String[] words, String order) {

		order_map = new int[26];

		for (int i = 0; i < order.length(); i++)
			order_map[order.charAt(i) - 'a'] = i;

		for (int j = 1; j < words.length; j++) {
			if (compare(words[j - 1], words[j]) > 0) {
				return false;
			}
		}
		return true;
	}

	private static int compare(String word1, String word2) {

		int i = 0, j = 0, compare_value = 0;

		while (i < word1.length() && j < word2.length() && compare_value == 0) {
			compare_value = order_map[word1.charAt(i) - 'a'] - order_map[word1.charAt(j) - 'a'];
			i++;
			j++;
		}

		if (compare_value == 0) {
			return word1.length() - word2.length(); // exp: "hel","hello" (then need to check next words)
		} else {
			return compare_value;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 1. words = { "hello", "leetcode" }; Output: true Explanation: As 'h' comes
		 * before 'l' in this language, then the sequence is sorted.
		 */

		// String[] words = { "hello", "leetcode" };
		// String order = "hlabcdefgijkmnopqrstuvwxyz";
		// System.out.print(alienOrderUtil(words, order));

		/*
		 * 2. Input: words = ["word","world","row"], order =
		 * "worldabcefghijkmnpqstuvxyz" Output: false Explanation: As 'd' comes after
		 * 'l' in this language, then words[0] > words[1], hence the sequence is
		 * unsorted.
		 */

		String[] words = { "word", "world", "row" };
		String order = "worldabcefghijkmnpqstuvxyz";
		System.out.print(alienOrderUtil(words, order));

	}

}
