package array;

/**
 * 
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most
 * twice? For example, given sorted array A = [1,1,1,2,2,3], your function
 * should return length = 5, and A is now [1,1,2,2,3].
 * 
 * @author nishantchauhan
 *
 */

public class RemoveDuplicateII {
	public static int removeDuplicatesII(int[] A) {
		if (A.length <= 2)
			return A.length;
		int prev = 1; // point to previous
		int curr = 2; // point to current
		while (curr < A.length) {
			if (A[curr] == A[prev] && A[curr] == A[prev - 1]) {
				curr++;
			} else {
				prev++;
				A[prev] = A[curr];
				curr++;
			}
		}
		return prev + 1;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 2, 3, 3 };

		System.out.println(removeDuplicatesII(arr));
	}

}
