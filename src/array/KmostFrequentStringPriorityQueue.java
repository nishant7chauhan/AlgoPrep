package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 35.Find the k most frequent words from a file/input stream (or a stream of
 * input)
 * 
 * @author nishantchauhan
 *
 *
 *         O(Nlogk), O(n)
 */

public class KmostFrequentStringPriorityQueue {

	public static void kMostFrequent(String[] words, int k) {

		// Map which stores number and it's occurrence count
		Map<String, Integer> map = new HashMap<>();
		// Traverse an array
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				int freq1 = map.get(o1);
				int freq2 = map.get(o2);

				if (freq1 == freq2)
					return o2.compareTo(o1);

				return freq1 - freq2;
			}

		});

		for (String word : map.keySet()) {

			pq.add(word);

			if (pq.size() > k)
				pq.poll();

		}

		List<String> result = new ArrayList<>();

		while (!pq.isEmpty())
			result.add(pq.poll());

		Collections.reverse(result);

		for (String word : result)
			System.out.print(word + " ");

	}

	public static void main(String[] args) {
		String[] arr = { "nishant", "yes", "good", "yes", "nishant", "to", "nishant" };
		kMostFrequent(arr, 2);
	}

}
