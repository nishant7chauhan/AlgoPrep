package array;
/* 21. Trapping rain water */

/**
 *  Trapping rain water
 * @author nishantchauhan
 *
 *         Time Complexity: O(n). Only one traversal of the array is needed.
 *         Auxiliary Space: O(1). As no extra space is required.
 */

public class RainWaterBetweenTowers {

	static int getMaxRainwaterBetweenTowers(int arr[], int n) {
		// initialize output
		int result = 0;

		// maximum element on left and right
		int left_max = 0, right_max = 0;

		// indices to traverse the array
		int lo = 0, hi = n - 1;

		while (lo <= hi) {
			if (arr[lo] < arr[hi]) {
				if (arr[lo] > left_max)

					// update max in left
					left_max = arr[lo];
				else

					// water on curr element =
					// max - curr
					result += left_max - arr[lo];
				lo++;
			} else {
				if (arr[hi] > right_max)

					// update right maximum
					right_max = arr[hi];

				else
					result += right_max - arr[hi];
				hi--;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] towerHeight = { 1, 5, 2, 3, 1, 7, 2, 4 };
		System.out.println("Maximum water that " + "can be accumulated is "
				+ getMaxRainwaterBetweenTowers(towerHeight, towerHeight.length));
	}
}
