package array;

/**
 * Given an array of integers  and a window size ‘k’, find first negative number for each possible window in the array.
 * @author nishantchauhan
 * O(n) , O(1)
 */


public class WindowFirstNegative {

	public static void main(String[] args) {
		int arr[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
		int n = arr.length;
		int k = 3;
		printFirstNegativeInteger(arr, n, k);
	}

	private static void printFirstNegativeInteger(int[] arr, int n, int k) {
		// TODO Auto-generated method stub

		int firstNegativeIndex = 0;
		int firstNegativeElement = 0;

		for (int i = k - 1; i < arr.length; i++) {

			// skip out of window and positive elements
			while (firstNegativeIndex < i && (firstNegativeIndex <= i - k || arr[firstNegativeIndex] > 0))
				firstNegativeIndex += 1;

			// check if a negative element is found, otherwise use 0
			if (arr[firstNegativeIndex] < 0)
				firstNegativeElement = arr[firstNegativeIndex];
			else
				firstNegativeElement = 0;
			System.out.print(firstNegativeElement + " ");

		}
	}

}
