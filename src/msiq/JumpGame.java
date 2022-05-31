package msiq;

/**
 * You are given an integer array nums. You are initially positioned at the
 * array's first index, and each element in the array represents your maximum
 * jump length at that position.
 * 
 * Return true if you can reach the last index, or false otherwise.
 * 
 * @author nishantchauhan
 * O(n)
 *
 */

//nickwhite

public class JumpGame {

	public static boolean canJump(int[] nums) {
		int lastGoodIndex = nums.length - 1;

		for (int i = nums.length - 1; i >= 0; i--) {
			if (i + nums[i] >= lastGoodIndex) {
				lastGoodIndex = i;
			}

		}
		return lastGoodIndex == 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 3, 2, 1, 0, 4 };

		System.out.print(canJump(arr));

	}
}
