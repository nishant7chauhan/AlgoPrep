package msiq;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
	
	
	 public boolean wordBreak(String s, List<String> dict) {     
	        boolean[] dp = new boolean[s.length() + 1];
	        dp[0] = true; 
	       
	         for(int i = 0; i <= s.length(); i++){
	            for(int j = 0; j < i; j++){
	                if(dp[j] && dict.contains(s.substring(j, i))){
	                    dp[i] = true;
	                    break;
	                }
	            }
	        }
	         return dp[s.length()];
	    }
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WordBreak obj = new WordBreak();
			
		String s = "nishant";
		List<String> list = new ArrayList<>();
		list.add("ant");
		list.add("nish");
		
		System.out.print(obj.wordBreak(s,list));
		
		
	}

}
