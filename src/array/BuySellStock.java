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

	public static void main(String[] args) {
		int[] stockPrice = { 100, 80, 120, 130, 70, 60, 100, 125 };
		System.out.println(maxProfitSingleTransaction(stockPrice));
		System.out.println(maxProfitMultipleTransaction(stockPrice));
	}
}
