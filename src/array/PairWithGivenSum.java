package array;

import java.util.HashMap;

/**
 * Find pair with given sum
 * @author nishantchauhan
 * O(n) , O(n)
 */



public class PairWithGivenSum {

	
	static void printpairs(int arr[], int sum) 
    { 
        HashMap<Integer,Integer> s = new HashMap<Integer,Integer>(); 
        for (int i = 0; i < arr.length; ++i) { 
            int temp = sum - arr[i]; 
  
            // checking for condition 
            if (s.containsKey(temp)) { 
                System.out.println( 
                    "Pair with given sum "
                    + sum + " is (" + arr[i] 
                    + ", " + temp + ")" + "\n" + "and index are: "+ s.get(temp) + "," + i ); 
            } 
            s.put(arr[i],i); 
        } 
    } 
  
    // Main to test the above function 
    public static void main(String[] args) 
    { 
        int A[] = { 1, 4, 45, 6, 10, 8 }; 
        int n = 16; 
        printpairs(A, n); 
    } 
	
}
