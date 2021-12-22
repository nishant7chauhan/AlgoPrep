package array;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A running stream of numbers is coming you need to keep track of top K most
 * frequent elements   https://www.youtube.com/watch?v=flZ0hwcJetc
 * 
 * @author nishantchauhan O(n) , space O(n)
 */

public class KmostFrequentElement {

	public static void kMostFrequent(int[] nums, int k) {

		// Map which stores number and it's occurrence count
		Map<Integer, Integer> countMap = new HashMap<>();

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
		List<Integer>[] bucket = new ArrayList[maxFreq + 1];

		for (int n : countMap.keySet()) {
			int freq = countMap.get(n);

			if (bucket[freq] == null)
				bucket[freq] = new ArrayList<>();

			bucket[freq].add(n);
		}

		int count = 0;
		// Pick top k elements
		for (int i = bucket.length - 1; i >= 0; i--) {
			if (bucket[i] != null) {
				for (int element : bucket[i]) {
					System.out.print(element + " ");
					count++;
					if (count == k)
						return;
				}
			}
		}

	}

	public static void main(String[] args) {
		int[] arr = { 1, 4, 4, 4, 5, 1 };
		kMostFrequent(arr, 2);
	}

}
