package array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	public static int longestConsecutive(int[] num) {
		// if array is empty, return 0
		if (num.length == 0) {
			return 0;
		}
		Set<Integer> set = new HashSet<Integer>();
		int max = 1;
		for (int e : num)
			set.add(e);
		for (int e : num) {
			int left = e - 1;
			int right = e + 1;
			int count = 1;
			while (set.contains(left)) {
				count++;
				set.remove(left);
				left--;
			}
			while (set.contains(right)) {
				count++;
				set.remove(right);
				right++;
			}

			max = Math.max(count, max);
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = new int[] { 6, 8, 2, 3, 4, 5, 9 };

		System.out.print("longest consecutive sequence: "+longestConsecutive(array));
	}

}
