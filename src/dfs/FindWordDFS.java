package dfs;

public class FindWordDFS {
	
	static int rowNum[] = {-1, -1, -1, 0, 0, 1, 1, 1}; 
	static int colNum[] = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	static boolean isvalid(int row, int col, int prevRow, int prevCol) 
	{ 
	    // return true if row number and column number 
	    // is in range 
	    return (row >= 0) && (row < 3) && 
	           (col >= 0) && (col < 5); //&& 
	           //!(row== prevRow && col == prevCol); 
	} 
	
	static void DFS(char[][] mat,int row, int col, int prevRow,int prevCol,char[] word,String path, int index,int n){
		
		
		if(index > n || mat[row][col] != word[index]) {
			return;
		}
		
		path = path + word[index] + "(" + row 
		        + ", " + col + ") ";
		
		if(index == n) {
			System.out.print(path + "\n");
		}
		
		for (int k = 0; k < 8; ++k) {
	        if (isvalid(row + rowNum[k], col + colNum[k], 
	                    prevRow, prevCol)) {
	  
	            DFS(mat, row + rowNum[k], col + colNum[k], 
	                row, col, word,path,index+1, n);
	        }
		}
		
	}
	

	static void findWords(char[][] mat, char[] word, int n) {
		 for(int i=0;i<3;i++) {
			 for(int j=0;j<5;j++) {
				 if(mat[i][j] == word[0]) {
					 DFS(mat,i,j,-1,-1,word,"",0,n);
				 }
			 }
		 }
	 }
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[][] mat = { { 'B', 'N', 'E', 'Y', 'S' }, { 'H', 'E', 'D', 'E', 'S' }, { 'S', 'G', 'N', 'D', 'E' } };

		char [] word = {'D','E','S'};

		
		
		findWords(mat, word, word.length-1);
	}

}
