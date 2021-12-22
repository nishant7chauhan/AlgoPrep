package array;

/**
 * Max sum contiguous sub-array
 * @author nishant.chauhan
 * O(n)
 */

// similar approach for subarray with given sum(use left index and right index) https://www.youtube.com/watch?v=Ofl4KgFhLsM


public class Kadane {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 }; 
        int n = a.length; 
        maxSubArraySum(a, n); 
		
	}

	private static void maxSubArraySum(int[] a, int n) {
		// TODO Auto-generated method stub
		int max_so_far = Integer.MIN_VALUE;
		int max_ending_here = 0,start = 0,end = 0,s = 0;
		
		for(int i=0;i<a.length;i++) {
			
			max_ending_here += a[i];
			
			if(max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
				start = s;
				end = i;
			}
			
			if(max_ending_here < 0) {
				max_ending_here = 0;
				s = i + 1;
			}
		}
		
		System.out.print("Sum: " + max_so_far + "\n" + "Start Index: "+ start + "\n" + "End Index: "+end);
	}

}

