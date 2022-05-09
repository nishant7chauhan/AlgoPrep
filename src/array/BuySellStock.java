package array;

/* 22. Buy sell stocks to maximize profit*/  //single transaction IDeserve
public class BuySellStock {

	private static int maxProfitSingleTransaction(int[] stockPrice) {
		int profit = 0;
		int minimumPrice = Integer.MAX_VALUE;

		for (int i = 0; i < stockPrice.length; i++) {
			profit = Math.max(profit, stockPrice[i] - minimumPrice);
			minimumPrice = Math.min(stockPrice[i], minimumPrice);
		}
		return profit;
	}

	private static int maxProfitMultipleTransaction(int[] stockPrice) {
		int totalProfit = 0;

		for (int i = 1; i < stockPrice.length; i++) {
			int currentTotal = stockPrice[i] - stockPrice[i - 1];
			if (currentTotal > 0) {
				totalProfit += currentTotal;
			}
		}

		return totalProfit;
	}

	
	
    /**
     * This is slow method but easier to understand.
     * Time complexity is O(k * number of days ^ 2)
     * T[i][j] = max(T[i][j-1], max(prices[j] - prices[m] + T[i-1][m])) where m is 0...j-1
   
    public int maxProfitSlowSolution(int prices[], int K) {
        if (K == 0 || prices.length == 0) {
            return 0;
        }
        int T[][] = new int[K+1][prices.length];

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                int maxVal = 0;
                for (int m = 0; m < j; m++) {
                    maxVal = Math.max(maxVal, prices[j] - prices[m] + T[i-1][m]);
                }
                T[i][j] = Math.max(T[i][j-1], maxVal);
            }
        }
        printActualSolution(T, prices);
        return T[K][prices.length - 1];
    }	
	*/
	
	
	public static void main(String[] args) {
		int[] stockPrice = { 100, 80, 120, 130, 70, 60, 100, 125 };
		System.out.println(maxProfitSingleTransaction(stockPrice));
		System.out.println(maxProfitMultipleTransaction(stockPrice));
	}
}
