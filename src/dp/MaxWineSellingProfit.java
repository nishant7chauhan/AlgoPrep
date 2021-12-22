package dp;

/**
 * Given an array of wine prices, any given year you can sell a bottle of wine
 * only from either of the ends. Bottle of wine increases every year. Find max
 * profit after selling all.[done]
 * 
 * @author nishantchauhan
 *
 *         O(N2)
 */

public class MaxWineSellingProfit {

	static int N = 5;

	static int[][] dp = new int[N][N];

	// This array stores the "optimal action"
	// for each state i, j
	static int[][] sell = new int[N][N];

	// Function to maximize profit
	static int maxProfitUtil(int price[], int begin, int end, int year) {
		if (dp[begin][end] != -1)
			return dp[begin][end];

		if (begin == end)
			return year * price[begin];

		// x = maximum profit on selling the
		// wine from the front this year
		int x = price[begin] * year + maxProfitUtil(price, begin + 1, end, year + 1);

		// y = maximum profit on selling the
		// wine from the end this year
		int y = price[end] * year + maxProfitUtil(price, begin, end - 1, year + 1);

		int ans = Math.max(x, y);
		dp[begin][end] = ans;

		if (x >= y)
			sell[begin][end] = 0;
		else
			sell[begin][end] = 1;

		return ans;
	}

	// Util Function to calculate maxProfit
	static int maxProfit(int price[], int n) {

		// reseting the dp table
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				dp[i][j] = -1;

		int ans = maxProfitUtil(price, 0, n - 1, 1);

		int i = 0, j = n - 1;

		for (int l = 0; l < N; l++) {
			for (int m = 0; m < N; m++) {
				System.out.print(sell[l][m] + " ");
			}
			System.out.print("\n");
		}

		while (i <= j) {

			// sell[i][j]=0 implies selling
			// the wine from beginning will
			// be more profitable in the
			// long run
			if (sell[i][j] == 0) {
				System.out.print("beg "); // because sell only first or end check sell table result.
				i++;
			} else {
				System.out.print("end ");
				j--;
			}
		}

		System.out.println();

		return ans;
	}

	// Driver code
	public static void main(String[] args) {
		// Price array
		int price[] = { 2, 4, 6, 2, 5 };

		int n = price.length;

		int ans = maxProfit(price, n);

		System.out.println(ans);
	}

}
