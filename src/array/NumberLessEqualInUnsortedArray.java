package array;

import java.util.Arrays;

/**
 * Given two unsorted arrays A, B. They can contain duplicates. For each element in A count elements less than or equal to it in array B
 * 
 * 
 * @author IN006166
 *
 * O(NlogN) check O(N) solution commented below( O(max + n ) , O(max)
 *
 */


public class NumberLessEqualInUnsortedArray {

	// method returns the index of largest element smaller than equal to 'x' in
	// 'arr'. For duplicates it returns the last index of occurrence of required
	// element. If no such element exits then it returns -1.
	static int binary_search(int arr[], int l, int h, int x) {
		while (l <= h) {
			int mid = (l + h) / 2;

			// if 'x' is greater than or equal
			// to arr[mid], then search in
			// arr[mid+1...h]
			if (arr[mid] <= x)
				l = mid + 1;

			// else search in arr[l...mid-1]
			else
				h = mid - 1;
		}

		// Required index
		return h;
	}

	// Method to count for each
	// element in 1st array,
	// elements less than or equal
	// to it in 2nd array
	static void countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n) {
		// Sort the 2nd array
		Arrays.sort(arr2);

		// for each element of 1st array
		for (int i = 0; i < m; i++) {
			// Last index of largest element
			// smaller than or equal to x
			int index = binary_search(arr2, 0, n - 1, arr1[i]);

			// Required count for the element arr1[i]
			System.out.print((index + 1) + " ");
		}
	}

	// Driver method
	public static void main(String[] args) {
		int arr1[] = { 1, 2, 3, 4, 7, 9 };
		int arr2[] = { 0, 1, 2, 1, 1, 4 };

		countEleLessThanOrEqual(arr1, arr2, arr1.length, arr2.length);
	}
}

/**
 * static int MAX = 100000; 
  
// Function for each element  
// in 1st array count elements  
// less than or equal to it  
// in 2nd array  
static void countEleLessThanOrEqual(int arr1[], int m,  
                                    int arr2[], int n) 
{  
    // Creating hash array initially 
    // filled with zero 
    int hash[] = new int[MAX]; 
      
    // Insert element of arr2[] to 
    // hash such that hash[i] will 
    // give count of element i in arr2[] 
    for (int i = 0; i < n; i++) 
        hash[arr2[i]]++; 
  
    // Presum of hash array 
    // such that hash[i] will  
    // give count of element  
    // less than or equals to  
    // i in arr2[] 
    for(int i = 1; i < MAX; i++) 
    { 
        hash[i] = hash[i] +  
                  hash[i - 1]; 
    } 
      
    // Traverse arr1[] and  
    // print hash[arr[i]] 
    for (int i = 0; i < m; i++)  
    { 
        System.out.print(hash[arr1[i]] + " "); 
    } 
} 
  
// Driver code 
public static void main (String[] args)  
{ 
    int arr1[] = {1, 2, 3, 4, 7, 9}; 
    int arr2[] = {0, 1, 2, 1, 1, 4}; 
    int m, n; 
      
    m = arr1.length; 
    n = arr2.length; 
      
    countEleLessThanOrEqual(arr1, m, arr2, n); 
} 
} 
 */








































