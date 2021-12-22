package dp;
	/**
	 * Given a string find longest palindromic subsequence in this string.
	 * Time complexity - O(n2)
	 * Space complexity - O(n2)
	 */

	public class LongestPalindromicSubsequence {

	    public int calculate1(char []str){
	        int T[][] = new int[str.length][str.length];
	        for(int i=0; i < str.length; i++){
	            T[i][i] = 1;
	        }
	        for(int l = 2; l <= str.length; l++){
	            for(int i = 0; i <= str.length-l; i++){
	                int j = i + l - 1;
	                if(l == 2 && str[i] == str[j]){
	                    T[i][j] = 2;
	                }else if(str[i] == str[j]){
	                    T[i][j] = T[i + 1][j-1] + 2;
	                }else{
	                    T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
	                }
	            }
	        }
	        //nishant edit
	        
	        for(int i = 0; i<str.length; i++) {
	        	for(int j = 0; j<str.length; j++) {
	        		System.out.print(T[i][j]);
	        	}
	        	System.out.print("\n");
	        }
	        
	        
	        return T[0][str.length-1];
	    }


	    public int calculateRecursive(char str[],int start,int len){
	        if(len == 1){
	            return 1;
	        }
	        if(len ==0){
	            return 0;
	        }
	        if(str[start] == str[start+len-1]){
	            return 2 + calculateRecursive(str,start+1,len-2);
	        }else{
	            return Math.max(calculateRecursive(str, start+1, len-1), calculateRecursive(str, start, len-1));
	        }
	    }
	    
	    public static void main(String args[]){
	        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
	        String str = "agbdba";
	        int r1 = lps.calculateRecursive(str.toCharArray(), 0, str.length());
	        int r2 = lps.calculate1(str.toCharArray());
	        System.out.print(r1 + " " + r2);
	    }
	    
	}
