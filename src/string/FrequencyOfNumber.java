package string;

/******* count element (or frequency) in a sorted String *******/
//O(Logn)

public class FrequencyOfNumber {

	/*
	 * if x is present in arr[] then returns the count of occurrences of x,
	 * otherwise returns -1.
	 */
	static int count(String arr, char x, int n) {
		// index of first occurrence of x in arr[0..n-1]
		int i;

		// index of last occurrence of x in arr[0..n-1]
		int j;

		/* get the index of first occurrence of x */
		i = first(arr, 0, n - 1, x);

		/* If x doesn't exist in arr[] then return -1 */
		if (i == -1)
			return i;

		/*
		 * Else get the index of last occurrence of x. Note that we are only looking in
		 * the subarray after first occurrence
		 */
		j = last(arr, i, n - 1, x, n);

		/* return count */
		return j - i + 1;
	}

	/*
	 * if x is present in arr[] then returns the index of FIRST occurrence of x in
	 * arr[0..n-1], otherwise returns -1
	 */
	static int first(String arr, int low, int high, char x) {
		while (high >= low) {
			/* low + (high - low)/2; */
			int mid = (low + high) / 2;
			if ((mid == 0 || x > arr.charAt(mid - 1)) && arr.charAt(mid) == x)
				return mid;
			else if (x > arr.charAt(mid))
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}

	/*
	 * if x is present in arr[] then returns the index of LAST occurrence of x in
	 * arr[0..n-1], otherwise returns -1
	 */
	static int last(String arr, int low, int high, char x, int n) {
		while (high >= low) {
			/* low + (high - low)/2; */
			int mid = (low + high) / 2;
			if ((mid == n - 1 || x < arr.charAt(mid + 1)) && arr.charAt(mid) == x)
				return mid;
			else if (x < arr.charAt(mid))
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}

	public static void main(String args[]) {
		// int arr[] = { 1, 2, 2, 3, 3, 3, 3 };
		String arr = "abcddeefffffg";

		// Element to be counted in arr[]
		char x = 'f';
		int n = arr.length();
		int c = count(arr, x, n);
		System.out.println(x + " occurs " + c + " times");
	}

}
