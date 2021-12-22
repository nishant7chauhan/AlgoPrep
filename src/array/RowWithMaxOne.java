package array;

//print row with maximum 1's  //Given a boolean 2D array, where each row is sorted. Find the row with the maximum number of 1s. 

//O(m+n))


public class RowWithMaxOne {
	
	static final int N = 4; 
	  
    // function for finding row with maximum 1 
    static void findMax(int arr[][]) { 
          
        int row = 0, i, j; 
  
        for (i = 0, j = N - 1; i < N; i++) { 
              
            // find left most position of 1 in 
            // a row find 1st zero in a row 
            while (j >= 0 && arr[i][j] == 1) { 
                  
                row = i; 
                j--; 
            } 
        } 
          
        System.out.print("Row number = " 
                                + (row + 1)); 
        System.out.print(", MaxCount = " 
                               + (N - 1 - j)); 
    } 
      
    // Driver code 
    public static void main(String[] args) { 
        int arr[][] = {{0, 1, 1, 1},  
                       {0, 0, 1, 1},  
                       {0, 0, 0, 0},  
                       {1, 1, 1, 1}}; 
        findMax(arr); 
    }

}





/**   O(nlogn)
 *  
	static int R = 4, C = 4; 
	
	
	static int rowWithMax1s(int mat[][]) 
	{ 
	    // Initialize first row as row with max 1s 
	    int max_row_index = 0; 
	  
	    // The function first() returns index of first 1 in row 0. 
	    // Use this index to initialize the index of leftmost 1 seen so far 
	    int j = first(mat[0], 0, C-1); 
	    if (j == -1) // if 1 is not present in first row 
	      j = C - 1; 
	  
	    for (int i = 1; i < R; i++) 
	    { 
	        // Move left until a 0 is found 
	        while (j >= 0 && mat[i][j] == 1) 
	        { 
	           j = j-1;  // Update the index of leftmost 1 seen so far 
	           max_row_index = i;  // Update max_row_index 
	        } 
	    } 
	    return max_row_index; 
	} 
	
	
	
	 static int first(int arr[], int low, int high) 
    { 
        if (high >= low) { 
            // Get the middle index 
            int mid = (low + high) / 2;  // or low + (high - low)/2
  
            // Check if the element at middle index is first 1 
            if ((mid == 0 || (arr[mid - 1] == 0)) && arr[mid] == 1) 
                return mid; 
  
            // If the element is 0, recur for right side 
            else if (arr[mid] == 0) 
                return first(arr, (mid + 1), high); 
                  
            // If element is not first 1, recur for left side 
            else 
                return first(arr, low, (mid - 1)); 
        } 
        return -1; 
    } 
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int mat[][] = { { 0, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 0, 0 } };
		System.out.println("Index of row with maximum 1s is " + rowWithMax1s(mat));
	}
 */