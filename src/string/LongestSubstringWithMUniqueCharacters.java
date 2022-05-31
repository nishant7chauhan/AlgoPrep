package string;

import java.util.HashMap;
import java.util.Map;

//Find longest substring with k unique characters

/**
 * 
 * @author nishant.chauhan
 * 
 *  Time Complexity: Considering function �isValid()� takes constant time, time complexity of above solution is O(n).
 */

public class LongestSubstringWithMUniqueCharacters {

	public static int longestSubstringLengthWithKDistinctCharacters(String str, int k) {
	    if(str == null || str.length() == 0 || k <= 0 || k > str.length()) {
	      return -1;
	    }
	    
	    int maxLength = 0;
	    int start, end;
	    start = end = 0;
	    
	    Map<Character, Integer> map = new HashMap<>();
	        
	    while(end < str.length()) {
	      char currentChar = str.charAt(end);
	      map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
	      
	      while(map.size() > k) {
	        char charFromFront = str.charAt(start);
	        map.put(charFromFront, map.get(charFromFront) - 1);
	        
	        if(map.get(charFromFront) == 0) {
	          map.remove(charFromFront);
	        }
	        start++;
	      }
	      
	      maxLength = Math.max(end - start + 1, maxLength);   //can save start and end to print string
	      end++;
	    }
	    
	    return maxLength;
	  }
	  
	  public static void main(String[] args) {
	    
	    String str = "karaap";
	    int k = 2;
	    System.out.println(LongestSubstringWithMUniqueCharacters.longestSubstringLengthWithKDistinctCharacters(str, k));
	  }

}
