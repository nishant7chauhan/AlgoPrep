package array;

/**
 * Find next greater number with same set of digits
 * @author nishant.chauhan
 * O(n) space O(n)
 */

public class NextGreaterNumber {

	 static int nextGreater(int num){
		    // we create an array named digits to store digits of num
		    char[] digits = String.valueOf(num).toCharArray();

		    // we create and initialize i to the before last index 
		    // (because the last element has no next element
		    // so digits[i+1] doesn't exist)
		    int i = digits.length - 2;
		    // we search for the element that breaks the ascending order
		    while(i >= 0 && digits[i] >= digits[i+1]) i--;
		    // if we find -1, then the next greater doesn't exist, we return num
		    if(i == -1) return num;

		    // we create and initialize j to the last index
		    int j = digits.length - 1; 
		    // we search for the first digit that is greater than digits[i]
		    while(digits[j] <= digits[i]) j--;

		    // we swap digits[i] with digits[j]
		    char temp = digits[i];
		    digits[i] = digits[j];
		    digits[j] = temp;

		    // we reverse the part that starts from i+1
		    int left = i+1, right = digits.length - 1;
		    while(left < right){
		      temp = digits[left];
		      digits[left] = digits[right];
		      digits[right] = temp;
		      left++;
		      right--;
		    }

		    // we return digits as an integer
		    return Integer.parseInt(String.valueOf(digits));
		  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(nextGreater(24892));
		
	}

}
