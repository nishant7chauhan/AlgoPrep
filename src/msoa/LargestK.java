package msoa;

import java.util.HashSet;

public class LargestK {

	public static int largestK(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		int curMax = 0;
		for (int a : nums) {
			if (set.contains(-a))
				curMax = Math.max(curMax, Math.abs(a));
			else
				set.add(a);
		}
		return curMax;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {3, 2, -2, 5, -3};
		//int L = 2, R = 3;
		
		System.out.print(largestK(arr));
		
		
	}

}
