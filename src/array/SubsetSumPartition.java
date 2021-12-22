package array;

/**
 * Partition a set into two subsets such that the difference of subset sums is
 * minimum
 * 
 * @author nishantchauhan
 *
 *
 *         * Time complexity - O(input.size * total_sum) Space complexity -
 *         O(input.size*total_sum)
 */

public class SubsetSumPartition {

	public int partition(int arr[]) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		
		boolean[][] T = new boolean[arr.length + 1][sum + 1];

		for (int i = 0; i <= arr.length; i++) {
			T[i][0] = true;
		}

		for (int i = 1; i <= arr.length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (j - arr[i - 1] >= 0) {
					T[i][j] = T[i - 1][j] || T[i - 1][j - arr[i - 1]];
				} else {
					T[i][j] = T[i - 1][j];
				}
			}
		}

		int lastRow = arr.length;
		int firstPartitionSum = -1;

		for (int j = sum/2; j >= 0; j--) {
			if (T[lastRow][j]) {
				firstPartitionSum = j;
				break;
			}
		}

		//System.out.print("firstPartitionSum: "+firstPartitionSum);
		path(T, arr.length, firstPartitionSum, arr);

		int secondPartitionSum = sum - firstPartitionSum;

		return Math.abs(firstPartitionSum - secondPartitionSum);
	}

	public void path(boolean[][] T, int i, int j, int[] input) {
		System.out.print("Elements are: ");
		while (i > 0 && j > 0) {
			if (T[i][j] && T[i - 1][j]) {
				i--;
			} else {
				System.out.print(input[i - 1] + " ");
				j = j - input[i - 1];
				i--;
			}
		}

	}

	public static void main(String args[]) {
		SubsetSumPartition ss = new SubsetSumPartition();
		int arr[] = { 2,4,2,3 };
		System.out.println("partition sum: " + ss.partition(arr));

	}

}
