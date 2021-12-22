package array;

/**
 * Count strings without consecutive 1’s(let's count be c)
 * Count number of binary strings without consecutive 1’s
 * @author nishant.chauhan
 * 
 *         with cosecutive one do 2^n - c
 *
 */

public class NumberWithOutConsecutive1 {

	static int countStrings(int n) {
		int a[] = new int[n];
		int b[] = new int[n];
		a[0] = b[0] = 1;
		for (int i = 1; i < n; i++) {

			a[i] = a[i - 1] + b[i - 1];
			System.out.print(" a:" + i + ":" + a[i]);
			b[i] = a[i - 1];
			System.out.print(" b:" + i + ":" + b[i]);
		}
		return a[n - 1] + b[n - 1];
	}

	/* Driver program to test above function */
	public static void main(String args[]) {
		System.out.println("\n" + countStrings(5));
	}

}
