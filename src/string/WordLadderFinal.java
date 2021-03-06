package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class WordLadderFinal {

	public static int ladderLength(String start, String end, HashSet<String> dict) {
		if (dict.size() == 0)
			return 0;

		dict.add(end);
		LinkedList<String> wordQueue = new LinkedList<String>();
		LinkedList<Integer> distanceQueue = new LinkedList<Integer>();
		wordQueue.add(start);
		distanceQueue.add(1);

		// track the shortest path
		int result = Integer.MAX_VALUE;
		while (!wordQueue.isEmpty()) {
			String currWord = wordQueue.pop();
			Integer currDistance = distanceQueue.pop();
			if (currWord.equals(end)) {
				result = Math.min(result, currDistance);
			}
			for (int i = 0; i < currWord.length(); i++) {
				char[] currCharArr = currWord.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					if (currCharArr[i] == c)
						continue;
					currCharArr[i] = c;
					String newWord = new String(currCharArr);
					if (dict.contains(newWord)) {
						wordQueue.add(newWord);
						distanceQueue.add(currDistance + 1);
						dict.remove(newWord);
					}
				}
			}
		}
		if (result < Integer.MAX_VALUE)
			return result;
		else
			return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String beginWord = "toon";
		String endWord = "plea";
		HashSet<String> set = new HashSet<>(Arrays.asList("poon", "plee", "same", "poie", "plea", "plie", "poin"));

		System.out.print("p:  " + ladderLength(beginWord, endWord, set));

	}

}
