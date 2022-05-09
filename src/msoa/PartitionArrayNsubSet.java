package msoa;

public class PartitionArrayNsubSet {

	
	/**
	 * 
	 *  private int K;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        K = k;
        int total = Arrays.stream(nums).sum();
        if(total%k != 0)
            return false;
        int reqSum = total/k;
        
        Arrays.sort(nums); // asc order instead of random order to speed up
        return solve(nums, k, reqSum, 0, 0);
    }
    
    private boolean solve(int[] nums, int k, int reqSum, int sum, int j) {
        if (k==1)
            return true;
        if (sum==reqSum) {
            return solve(nums, k-1, reqSum, 0, K - k + 1); // for subset #i, check only from nums[i] (worst case) to speed up
        }
        for(int i=j; i<nums.length; ++i) {
            // if nums[i] not used, try it
            if(nums[i]!=0 && sum+nums[i] <= reqSum) {
                int tmp = nums[i];
                nums[i] = 0; // set val to 0 to mark as used
                if(solve(nums, k, reqSum, sum+tmp, i+1))
                    return true;
                nums[i] = tmp; // restore val for future use
            }
            // skip nums[i] and try something else
        }
        return false;
    }
	 */
}
