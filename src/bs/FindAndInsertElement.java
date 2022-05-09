package bs;

/**
 * 
 * @author nishantchauhan
 * o(logn)
 */


public class FindAndInsertElement {
	
	
	
	public static int searchInsert(int[] nums, int target) {
	    int i=0; 
	    int j=nums.length-1;
	 
	    while(i<=j){
	        int mid = (i+j)/2;
	 
	        if(target > nums[mid]){
	            i=mid+1;
	        }else if(target < nums[mid]){
	            j=mid-1;
	        }else{
	            return mid;
	        }
	    }
	 
	    return i;
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int []arr = {1,2,4,5,6,7,8};
		
		System.out.print(searchInsert(arr,3));
		
		
	}

}
