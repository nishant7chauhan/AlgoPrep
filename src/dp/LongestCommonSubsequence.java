package dp;

/**
 * Longest Common Subsequence of two string
 * @author nishant.chauhan
 * O(mn)
 */


public class LongestCommonSubsequence {

	public int lcsDynamic(char[] str1, char[] str2) {
		int temp[][] = new int[str1.length + 1][str2.length + 1];
		for (int i = 1; i < temp.length; i++) {
			for (int j = 1; j < temp[i].length; j++) {
				if (str1[i - 1] == str2[j - 1]) {
					temp[i][j] = temp[i - 1][j - 1] + 1;
				} else {
					temp[i][j] = Math.max(temp[i - 1][j], temp[i][j - 1]);
				}
			}
		}

		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				System.out.print(temp[i][j]);
			}
			System.out.print("\n");
		}

		int n1 = str1.length;
		int n2 = str2.length;
		
		while (n1 > 0 && n2 > 0) {
			
			if (temp[n1][n2] == temp[n1 - 1][n2 - 1] + 1  && temp[n1 - 1][n2] == temp[n1][n2 - 1]) {
				System.out.println(str2[n2-1]); //any string as characters are common
				n1--;
				n2--;
			} else {
				if (temp[n1 - 1][n2] > temp[n1][n2 - 1]) {
					n1--;
				} else {
					n2--;
				}

			}
		}

	return temp[str1.length][str2.length];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		String str1 = "ABCDAF";
		String str2 = "ACBCF";

		int result = lcs.lcsDynamic(str1.toCharArray(), str2.toCharArray());
		System.out.print("Ans: "+result);

	}

}
