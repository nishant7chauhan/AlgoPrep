package array;
/* 22. Buy sell stocks to maximize profit*/  //multiple transaction

import java.util.ArrayList;

// Solution structure 
class Stock {
	int buy, sell;
}

public class BuySellStock1 {
	// This function finds the buy sell schedule for maximum profit
	void stockBuySell(int price[], int n) {
		// Prices must be given for at least two days
		if (n == 1)
			return;

		int count = 0;

		// solution array
		ArrayList<Stock> sol = new ArrayList<Stock>();

		// Traverse through given price array
		int i = 0;
		while (i < n - 1) {
			// Find Local Minima. Note that the limit is (n-2) as we are
			// comparing present element to the next element.                              // local minima is compared only eith next element that's why it is local(which is not the case of single transaction)
			while ((i < n - 1) && (price[i + 1] <= price[i]))
				i++;
			// If we reached the end, break as no further solution possible
			if (i == n - 1)
				break;

			Stock e = new Stock();
			e.buy = i++;
			// Store the index of minima

			// Find Local Maxima. Note that the limit is (n-1) as we are
			// comparing to previous element
			while ((i < n) && (price[i] >= price[i - 1]))
				i++;

			// Store the index of maxima
			e.sell = i - 1;
			sol.add(e);

			// Increment number of buy/sell
			count++;
		}

		// print solution
		if (count == 0)
			System.out.println("There is no day when buying the stock " + "will make profit");
		else
			for (int j = 0; j < count; j++)
				System.out.println("Buy on day: " + sol.get(j).buy + "        " + "Sell on day : " + sol.get(j).sell);

		return;
	}

	public static void main(String args[]) {
		BuySellStock1 stock = new BuySellStock1();

		// stock prices on consecutive days
		int price[] = { 100, 180, 260, 310, 40, 535, 695 };
		int n = price.length;
		stock.stockBuySell(price, n);
	}

}
