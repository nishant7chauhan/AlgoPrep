package array;

/**
 * Max sum contiguous sub-array can check geeksfor geeks video for all -ve
 * numbers solution
 * 
 * @author nishant.chauhan O(n)
 */

// similar approach for subarray with given sum(use left index and right index) https://www.youtube.com/watch?v=Ofl4KgFhLsM

/*
public int maxSubArray(int[] A) {
    int newsum=A[0];
    int max=A[0];
    for(int i=1;i<A.length;i++){
       newsum=Math.max(newsum+A[i],A[i]);           //check this solution ,for negative case check negative return value.
       max= Math.max(max, newsum);
    }
return max; }
*/


public class Kadane {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { -2, -3, -4, -1, -2, -1, -5, -3 };
		int n = a.length;
		maxSubArraySum(a, n);

	}

	private static void maxSubArraySum(int[] a, int n) {
		// TODO Auto-generated method stub
		int max_so_far = Integer.MIN_VALUE;
		int max_ending_here = 0, start = 0, end = 0, s = 0;

		for (int i = 0; i < a.length; i++) {

			max_ending_here += a[i];

			if (max_ending_here < 0) {
				max_ending_here = 0;
				s = i + 1;
			}

			else if (max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
				start = s;
				end = i;
			}

		}

		if (max_so_far == Integer.MIN_VALUE) {
			System.out.print("All negative numbers ans is 0");
		} else
			System.out.print("Sum: " + max_so_far + "\n" + "Start Index: " + start + "\n" + "End Index: " + end);
	}

}
