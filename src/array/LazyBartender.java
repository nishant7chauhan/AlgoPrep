package array;

/**
 * 
 * 52.Discussions about Lazy Bartender on Career Cup.(2) There are N number of
 * possible drinks.(n1,n2..) Has C number of fixed customers. Every customer has
 * fixed favorite set of drinks. Bartender has to create least possible number
 * of drinks to suffice need of all the customers Example: Cust1: n3,n7,n5,n2,n9
 * Cust2: n5 Cust3: n2,n3 Cust4: n4 Cust5: n3,n4,n3,n5,n7,n4 Output: 3(n3,n4,n5)
 * 
 * @author nishantchauhan
 *
 *
 *
 */

public class LazyBartender {

	public static int printLeastNumber(int[][] array, int m, int n) {

		int[][] arr = new int[m][n + 1];
		// filling the arr
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < array[i].length; j++) {
				int ind = array[i][j];
				arr[ind][i] = 1;
			}
		}
		// filling the last column of the arr
		for (int i = 0; i < m; i++) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				sum += arr[i][j];
			}
			arr[i][n] = sum;
		}

		int p = n; // creating a counter variable to track the number of customers left
		int count = 0; // counter variable to track the output

		while (p > 0) {
			int index = 0;
			int val = 0;
			int maxim = 0;
			// for loop to find the row index which has the maximum sum value
			for (int i = 0; i < m; i++)
				if (arr[i][n] > maxim) {
					maxim = arr[i][n];
					index = i;
				}
			System.out.print(index + ",");
			count++; // increasing the count as we found out one drink which serves the maximum
						// number of customers

			p = p - maxim;
			// for loop to eliminate the already counted drinks and customers and to
			// calculate the new sum
			for (int i = 0; i < n; i++) {
				if (arr[index][i] == 1) {
					for (int j = 0; j < m; j++) {
						if (arr[j][i] == 1) {
							arr[j][i] = 0;
							arr[j][n] -= 1;
						}
					}
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = { { 0, 1, 3, 6 }, { 1, 4, 7 }, { 2, 4, 7, 5 }, { 3, 2, 5 }, { 5, 8 } };
		int count = printLeastNumber(a, 9, 5);
		System.out.println("Output = " + count);

	}
}
