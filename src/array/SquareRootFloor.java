package array;

/**
 * square root floor value
 * @author nishantchauhan
 * O(logn)
 */

public class SquareRootFloor {
	public int floorSqrt(int x) {
		// Base Cases
		if (x == 0 || x == 1)
			return x;

		// Do Binary Search
		// for floor(sqrt(x))
		int start = 1, end = x, ans = 0;
		while (start <= end) {
			int mid = (start + end) / 2;

			// If x is a
			// perfect square
			if (mid * mid == x)
				return mid;

			// Since we need floor, we
			// update answer when mid *
			// mid is smaller than x,
			// and move closer to sqrt(x)
			if (mid * mid < x) {
				start = mid + 1;
				ans = mid;
			}

			// If mid*mid is
			// greater than x
			else
				end = mid - 1;
		}
		return ans;
	}

	// Driver Code
	public static void main(String[] args) {
		SquareRootFloor obj = new SquareRootFloor();
		System.out.print(obj.floorSqrt(11));
	}

}
