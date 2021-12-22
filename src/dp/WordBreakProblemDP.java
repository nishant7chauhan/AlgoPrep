package dp;

import java.util.HashSet;
import java.util.Set;

/**
 * * Given a string and a dictionary, split this string into multiple words such
 * that each word belongs in dictionary.
 * 
 * e.g peanutbutter -> pea nut butter e.g Iliketoplay -> I like to play
 * 
 * Solution DP solution to this problem if( input[i...j] belongs in dictionary)
 * T[i][j] = i else{ T[i][j] = k if T[i][k-1] != -1 && T[k][j] != -1
 * 
 * @author nishant.chauhan
 *
 *         O(n2), O(n2) this solution will only print one sequence , for
 *         multiple check trie
 */

public class WordBreakProblemDP {

	public String breakWordDP(String word, Set<String> dict) {
		int n = word.length();
		int T[][] = new int[n][n];

		for (int i = 0; i < T.length; i++) {
			for (int j = 0; j < T[i].length; j++) {
				T[i][j] = -1; // -1 indicates string between i to j cannot be split
			}
		}

		// fill up the matrix in bottom up manner
		for (int l = 0; l < n; l++) { // length 0 means 1
			for (int i = 0; i < n - l; i++) {
				int j = i + l;
				String str = word.substring(i, j + 1);
				// if string between i to j is in dictionary T[i][j] is true
				if (dict.contains(str)) {
					T[i][j] = i;
					continue;
				}
				// find a k between i+1 to j such that T[i][k-1] && T[k][j] are both true
				for (int k = i + 1; k <= j; k++) {
					if (T[i][k - 1] != -1 && T[k][j] != -1) {
						T[i][j] = k;
						break;
					}
				}
			}
		}
		if (T[0][n - 1] == -1) {
			return null;
		}

		
		/*
		 * for (int i = 0; i < T.length; i++) { for (int j = 0; j < T[i].length; j++) {
		 * System.out.print(T[i][j]+ " "); } System.out.print("\n"); }
		 */
		
		// create space separate word from string is possible
		StringBuffer buffer = new StringBuffer();
		int i = 0;
		int j = n - 1;
		while (i < j) {
			int k = T[i][j];
			if (i == k) {
				buffer.append(word.substring(i, j + 1));
				break;
			}
			buffer.append(word.substring(i, k) + " ");
			i = k;
		}

		return buffer.toString();
	}

	public static void main(String args[]) {
		Set<String> dictionary = new HashSet<String>();
		dictionary.add("I");
		dictionary.add("like");
		dictionary.add("had");
		dictionary.add("play");
		dictionary.add("to");
		String str = "Ihadliketoplay"; //
		WordBreakProblemDP bmw = new WordBreakProblemDP();
		String result1 = bmw.breakWordDP(str, dictionary);

		
		System.out.print(result1);
	}

}
