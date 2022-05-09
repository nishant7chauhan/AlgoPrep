package msiq;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Word Ladder Problem https://www.geeksforgeeks.org/word-ladder-length-of-shortest-chain-to-reach-a-target-word/
 * https://www.youtube.com/watch?v=M9cVl4d0v04&t=878s&ab_channel=NickWhite
 * @author nishant.chauhan
 *
 * O(begin-end string(N)*(word length)(n)*No of Words(W)
 *
 */


public class WordLadder {

	public static int wordLadderUtil(String beginWord, String endWord, HashSet<String> set) {

		if (!set.contains(endWord))
			return 0;

		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		int level = 0;

		while (!queue.isEmpty()) {

			int size = queue.size();

			for (int i = 0; i < size; i++) {

				char[] current_word = queue.poll().toCharArray();

				for (int j = 0; j < current_word.length; j++) {
					char original_char = current_word[j];
					for (char c = 'a'; c <= 'z'; c++) {
						if (current_word[j] == c)
							continue;
						current_word[j] = c;
						if (current_word.equals(endWord)) {
							// System.out.print("return: "+String.valueOf(current_word));
							return level + 1;
						}

						if (set.contains(String.valueOf(current_word))) {
							// System.out.print(String.valueOf(current_word));
							queue.add(String.valueOf(current_word));
							set.remove(String.valueOf(current_word));
						}
					}

					current_word[j] = original_char;
				}
			}
			level++;
		}

		return level;

	}

	public static void main(String[] args) {

		// String beginWord = "hit";
		// String endWord = "cog";
		// HashSet<String> set = new HashSet<>(Arrays.asList("hot", "dot", "dog", "lot",
		// "log", "cog"));

		String beginWord = "toon";
		String endWord = "plea";
		HashSet<String> set = new HashSet<>(Arrays.asList("poon", "plee", "same", "poie", "plea", "plie", "poin"));

		System.out.print(wordLadderUtil(beginWord, endWord, set));

	}

}
