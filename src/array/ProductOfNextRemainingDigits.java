package array;

import java.util.Arrays;

/**
 * Given an integer list. Output should be the product of next remaining digits
 * @author nishant.chauhan
 * O(n)
 */


public class ProductOfNextRemainingDigits {
	
	
	static int[] product(int arr[]) {
		
		int initial_product = 1;
		for(int i = 0; i<arr.length; i++ ) {
			initial_product = initial_product * arr[i];
		}
		

		int j = 0;
		while(j<arr.length) {
			int k = arr[j];
			arr[j++] = initial_product;
			initial_product =  initial_product/k;			
		}
		
		return arr;
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] input = {1,2,3,4,5};
		
		System.out.println(Arrays.toString(product(input)));
	}

}
