package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Given a sorted dictionary of an alien language, find order of characters
 * https://www.youtube.com/watch?v=LA0X_N-dEsg
 * 
 * @author nishantchauhan
 *
 *
 *         O(n + k) where n is number of words and k is length of words
 */

public class AlienDictionary {

	private static String alienOrder(String[] words) {
		// TODO Auto-generated method stub

		int[] indegree = new int[26];
		Map<Character, Set<Character>> graph = new HashMap<>();
		buildGraph(graph, words, indegree);
		return bfs(graph, indegree);
	}

	private static void buildGraph(Map<Character, Set<Character>> graph, String[] words, int[] indegree) {
		// TODO Auto-generated method stub

		for (String word : words) {
			for (char c : word.toCharArray()) {
				graph.putIfAbsent(c, new HashSet<>());
			}
		}

		for (int i = 1; i < words.length; i++) {
			String first = words[i - 1];
			String second = words[i];

			int len = Math.min(first.length(), second.length());

			for (int j = 0; j < len; j++) {
				if (first.charAt(j) != second.charAt(j)) {
					char out = first.charAt(j);
					char in = second.charAt(j);

					if (!graph.get(out).contains(in)) {
						graph.get(out).add(in);
						indegree[in - 'a']++;
					}
				} else
					continue;
				break;// do not need to check next character(check example)
			}

		}

	}

	private static String bfs(Map<Character, Set<Character>> graph, int[] indegree) {
		// TODO Auto-generated method stub

		StringBuilder sb = new StringBuilder();
		int totalNodes = graph.size();

		Queue<Character> queue = new LinkedList<>();

		for (char c : graph.keySet()) {

			if (indegree[c - 'a'] == 0) {
				queue.offer(c);
			}
		}
		while (!queue.isEmpty()) {
			char cur = queue.poll();
			sb.append(cur);

			if (graph.get(cur) == null || graph.get(cur).size() == 0) //for seperate graph like single node
				continue;

			for (char neigh : graph.get(cur)) {

				if (--indegree[neigh - 'a'] == 0) {
					queue.offer(neigh);

				}

			}

		}

		// System.out.print("totalNodes: " + totalNodes + "sb: " + sb.length());

		return sb.length() == totalNodes ? sb.toString() : "";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] words = { "baa", "abcd", "abca", "cab", "cad" };
		System.out.print(alienOrder(words));

	}

}
