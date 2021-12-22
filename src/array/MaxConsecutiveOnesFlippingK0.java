package array;

/**
 * Given an array of 0s and 1s,maximum 1 flipping K 0
 * produce a longest continuous 1s.
 * 
 * @author nishantchauhan O(n)
 */


public class MaxConsecutiveOnesFlippingK0 {	
	public static void countConsecutiveOnes(int[] arr,int k) {
		int maxConsecutiveOne = 0;
		int start = 0;
		int zeroCount = 0;
		int start_index = 0;
		int end_index = 0;
		int zero_index = 0;
		// Move end pointer/index
		for (int end = 0; end < arr.length; end++) {
			// If zero is found, then increment zeroCount
			if (arr[end] == 0) {
				zeroCount++;
			}
			/*
			 * If the value of zeroCount is greater than k, move start pointer and reset the
			 * window.
			 */
			while (zeroCount > k) {
				if (arr[start] == 0) {
					zeroCount--;
				}
				start++;
			}
			// maxConsecutiveOne = Math.max(maxConsecutiveOne, end - start + 1);
			if ((end - start + 1) > maxConsecutiveOne) {
				maxConsecutiveOne = end - start + 1;
				start_index = start;
				end_index = end;
				if(arr[end] == 0)
				zero_index = end;
			}

		}
		System.out.println("maxConsecutiveOne: "+ maxConsecutiveOne + " start_index: " + start_index +" end_index: " +end_index + " zero_index: "+zero_index);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1 };
		countConsecutiveOnes(arr,1);
	}
	
	
}
