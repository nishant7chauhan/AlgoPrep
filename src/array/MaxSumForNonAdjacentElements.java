package array;

/**
 * Find maximum sum in an array such that no 2 numbers are adjacent to each other
 * @author nishantchauhan
 * O(n)
 */


public class MaxSumForNonAdjacentElements {

    public int maxSum(int arr[]) {
        int excl = 0;
        int incl = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int temp = incl;
            incl = Math.max(excl + arr[i], incl);
            excl = temp;
        }
        return incl;
    }


    public static void main(String args[]) {
        MaxSumForNonAdjacentElements msn = new MaxSumForNonAdjacentElements();
        int arr[] = { 2, 10, 13, 4, 2, 15, 10 };
        System.out.println(msn.maxSum(arr));

    }
	
	
}
