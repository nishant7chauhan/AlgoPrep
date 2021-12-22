package graph;

import graph.Trie.TrieNode;

/**
 * Print all valid words that are possible using Characters of Array
 * 
 * @author nishant.chauhan
 *
 */

public class DictionaryValidWords {
	static final int SIZE = 26;

	// A recursive function to print all possible valid
	// words present in array
	static void searchWord(TrieNode trieNode, boolean hash[], StringBuilder str) {
		// if we found word in trie / dictionary
		if (trieNode.endOfWord == true)
			System.out.println(str);

		// traverse all child's of current root
		for (int k = 0; k < SIZE; k++) {
			if (hash[k] == true && trieNode.children.get((char) (k + 'a')) != null) {
				// add current character
				char c = (char) (k + 'a');

				// Recursively search reaming character
				// of word in trie
				searchWord(trieNode.children.get((char) (k + 'a')), hash, str.append(c));
			}
		}
	}

	// Prints all words present in dictionary.
	static void PrintAllWords(char arr[], Trie root) {
		// create a 'has' array that will store all present character in arr[]
		boolean[] hash = new boolean[SIZE];

		for (int i = 0; i < arr.length; i++)
			hash[arr[i] - 'a'] = true;

		// tempary node
		Trie pChild = root;

		// string to hold output words
		StringBuilder str = new StringBuilder();

		// Traverse all matrix elements. There are only 26 character possible in char
		// array
		for (int i = 0; i < SIZE; i++) {
			// we start searching for word in dictionary if we found a character which is
			// child of Trie root
			if (hash[i] == true && pChild.root.children.get((char) (i + 'a')) != null) {
				str = str.append((char) (i + 'a'));
				searchWord(pChild.root.children.get((char) (i + 'a')), hash, str);
				str.setLength(0);
			}
		}
	}

	public static void main(String[] args) {
		// Let the given dictionary be following
		String dict[] = { "go", "bat", "me", "eat", "goal", "boy", "run" };

		// Root Node of Trie
		Trie root = new Trie();

		// insert all words of dictionary into trie
		for (int i = 0; i < dict.length; i++)
			root.insert(dict[i]);

		// System.out.print(root.search("goal"));

		char arr[] = { 'e', 'o', 'b', 'a', 'm', 'g', 'l' };

		PrintAllWords(arr, root);
	}

}
