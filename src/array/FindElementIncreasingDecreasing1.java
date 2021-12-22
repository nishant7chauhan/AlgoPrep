package array;

/**
 * Find an element in first increasing and decreasing array
 * 
 * @author nishantchauhan O(logn)
 */

public class FindElementIncreasingDecreasing1 {

	private static int ascendingBinarySearch(int[] arr, int l, int h, int key) {
		// TODO Auto-generated method stub

		while (l <= h) {

			int mid = (l + h) / 2;

			if (arr[mid] == key)
				return mid;
			else if (arr[mid] > key)
				h = mid - 1;
			else
				l = mid + 1;

		}

		return -1;
	}

	private static int descendingBinarySearch(int[] arr, int l, int h, int key) {
		// TODO Auto-generated method stub

		while (l <= h) {

			int mid = (l + h) / 2;

			if (arr[mid] == key)
				return mid;

			else if (arr[mid] < key)
				h = mid - 1;
			else
				l = mid + 1;

		}

		return -1;
	}

	private static int searchElement(int[] arr, int key, int index, int n) {
		// TODO Auto-generated method stub
		if (key > arr[index])
			return -1;
		else if (key == arr[index])
			return arr[index];

		int temp = ascendingBinarySearch(arr, 0, index - 1, key);
		if (temp != -1)
			return temp;

		return descendingBinarySearch(arr, index + 1, n - 1, key);
	}

	private static int findPivot(int[] arr, int l, int r, int n) {
		// TODO Auto-generated method stub

		// check for base condition FindPivotInSortedRotatedArray

		while (l <= r) {
			int mid = (l + r) / 2;

			if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
				return mid; // return mid+1 for actual pivot , this is for max element

			if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1])
				r = mid - 1;
			else
				l = mid + 1;
		}

		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { -8, 1, 2, 3, 4, 5, -2, -3 };
		int key = 2;
		int n, l, r;
		n = arr.length;
		l = 0;
		r = n - 1;
		int index;
		index = findPivot(arr, l, r, n);
		System.out.print("pivot index: " + index +"\n");

		int x = searchElement(arr, key, index, n);

		if (x == -1)
			System.out.println("Element Not Found");
		else
			System.out.println("Element Found at index " + x);

	}

}
