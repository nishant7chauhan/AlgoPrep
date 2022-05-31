package array;

/**
 * There are N children standing in a line. Each child is assigned a rating
 * value. You are giving candies to these children subjected to the following
 * requirements: 1. Each child must have at least one candy. 2. Children with a
 * higher rating get more candies than their neighbors. What is the minimum
 * candies you must give?
 * 
 * @author nishantchauhan
 * 
 *         O(n)
 *
 */

public class CandyDistribution {

	public static int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0) {
			return 0;
		}
		int[] candies = new int[ratings.length];
		candies[0] = 1;
		// from let to right
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candies[i] = candies[i - 1] + 1;
			} else {
				// if not ascending, assign 1
				candies[i] = 1;
			}
		}

		int result = candies[ratings.length - 1];
		// from right to left
		for (int i = ratings.length - 2; i >= 0; i--) {
			int cur = 1;
			if (ratings[i] > ratings[i + 1]) {
				cur = candies[i + 1] + 1;
			}
			result += Math.max(cur, candies[i]);
			candies[i] = cur;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 12, 4, 3, 11, 34, 34, 1, 67 };

		System.out.print(candy(arr));

	}

}
