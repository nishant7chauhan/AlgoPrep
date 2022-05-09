package msoa;

import java.util.HashSet;

public class MinMumDeletionToMakeStringUnique {

	public static int minDeletions(String s) {
		// Create array of fixed size to store frequency of characters
		int frequency[] = new int[26];
		for (char currentChar : s.toCharArray()) {
			frequency[currentChar - 'a']++;
		}
		// Create HashSet to store unique frequencies
		HashSet<Integer> hs = new HashSet<>();

		// final answer is stored in below variable
		int ans = 0;

		// traverse the frequency array
		for (int val : frequency) {
			// if frequency is 0, do nothing
			if (val == 0)
				continue;
			else if (!hs.contains(val)) {
				// if frequency value is not present in HashSet then add it into hashset
				hs.add(val);
			} else {
				// check if current frequency is present in hashSet then traverse until it finds
				// frequency not present in hashset
				while (hs.contains(val) && val > 0) {
					val--;
					ans++;
				}
				hs.add(val);
			}
		}
		// Return answer
		return ans;
	}
	/* Driver program to test above functions */
    public static void main (String[] args) 
    { 
    	String s = "aaabbbcc";
        System.out.print(minDeletions(s)); 
    } 

}
