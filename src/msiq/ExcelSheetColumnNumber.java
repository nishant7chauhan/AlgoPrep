package msiq;

public class ExcelSheetColumnNumber {
	
	
	 public int titleToNumber(String columnTitle) {
	        int result = 0;
	        for(char c : columnTitle.toCharArray())
	        {
				//d = s[i](char) - 'A' + 1 (we used  s[i] -  'A' to convert the letter to a number like it's going to be C)

	            int d = c - 'A' + 1;
	            result = result * 26 + d;
	        }
	        return result;
	    }
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExcelSheetColumnNumber obj = new ExcelSheetColumnNumber();
		
		String columnTitle = "AB";
		
		System.out.print(obj.titleToNumber(columnTitle));
		
	}

}
