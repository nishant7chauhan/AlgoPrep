package array;

/**
 * Matrix chain multiplication
 * 
 * @author nishantchauhan
 *
 *         O(N3)
 */

public class MatrixMultiplicationCost {

	public int findCost(int arr[]) {
		int temp[][] = new int[arr.length][arr.length];
		int q = 0;
		for (int l = 2; l < arr.length; l++) {
			for (int i = 0; i < arr.length - l; i++) {
				int j = i + l; // not -1 because 4,2,3 makes length of 2(4x2,2x3)
				temp[i][j] = Integer.MAX_VALUE;
				for (int k = i + 1; k < j; k++) { // k =i+1 because array index 0,1 represent 1 matrix
					q = temp[i][k] + temp[k][j] + arr[i] * arr[k] * arr[j];
					if (q < temp[i][j]) {
						temp[i][j] = q;
					}
				}
			}
		}
		return temp[0][arr.length - 1];
	}

	public static void main(String args[]) {
		MatrixMultiplicationCost mmc = new MatrixMultiplicationCost();
		int arr[] = { 4, 2, 3, 5, 3 };
		int cost = mmc.findCost(arr);
		System.out.print(cost);
	}

}
