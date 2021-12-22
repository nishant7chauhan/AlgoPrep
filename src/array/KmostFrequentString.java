package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find the k most frequent words from a file/input stream (or a stream of input)
 * 
 * @author nishantchauhan https://www.youtube.com/watch?v=flZ0hwcJetc
 * 
 *        O(n) , space O(n)
 *
 */

public class KmostFrequentString {

	public static void kMostFrequent(String[] nums, int k) {

		// Map which stores number and it's occurrence count
		Map<String, Integer> countMap = new HashMap<>();

		// Variable which stores maximum frequency of any number
		int maxFreq = 0;

		// Traverse an array
		for (int i = 0; i < nums.length; i++) {

			// Get the occurrence of current element and add 1
			int freq = countMap.getOrDefault(nums[i], 0) + 1;

			// put the elem and it's freq in a map
			countMap.put(nums[i], freq);

			// keep track of maximum occurrence
			maxFreq = Math.max(maxFreq, freq);
		}

		// Declare a bucket, which store multiple values
		@SuppressWarnings("unchecked")
		List<String>[] bucket = new ArrayList[maxFreq + 1];

		for (String n : countMap.keySet()) {
			int freq = countMap.get(n);

			if (bucket[freq] == null)
				bucket[freq] = new ArrayList<>();

			bucket[freq].add(n);
		}

		int count = 0;
		// Pick top k elements
		for (int i = bucket.length - 1; i >= 0; i--) {
			if (bucket[i] != null) {
				for (String element : bucket[i]) {
					System.out.print(element + " ");
					count++;
					if (count == k)
						return;
				}
			}
		}

	}

	public static void main(String[] args) {
		String[] arr = { "nishant", "yes", "good", "yes", "nishant", "to", "nishant" };
		kMostFrequent(arr, 2);
	}

}
