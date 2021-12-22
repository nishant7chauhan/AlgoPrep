package array;

/**
 * Find max diff between two array element a[j]-a[i]; j>i
 * 
 * @author nishantchauhan O(n)
 */

public class MaximumDifference {


	 int maxIndexDiff(int arr[], int arr_size)
	    {
	        int max_diff = arr[1] - arr[0];
	        int min_element = arr[0];
	        int i;
	        for (i = 1; i < arr_size; i++)
	        {
	            if (arr[i] - min_element > max_diff)
	                max_diff = arr[i] - min_element;
	            if (arr[i] < min_element)
	                min_element = arr[i];
	        }
	        return max_diff;
	    }

	/* Driver program to test the above functions */
	public static void main(String[] args) {
		MaximumDifference max = new MaximumDifference();
		int arr[] = { 9, 2, 3, 4, 5, 6, 7, 8, 18, 0 };
		int n = arr.length;
		int maxDiff = max.maxIndexDiff(arr, n);
		System.out.println(maxDiff);
	}

}
