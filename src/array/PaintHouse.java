package array;

/**
 * n building are given their is a cost associated with each building for
 * painting in 3 colours R, G, B, given that no two adjacent buildings can have
 * same color find minimum cost to paint all n buildings ( most optimal space
 * and time complexity expected )
 * 
 * @author nishantchauhan
 * 
 * O(n)
 *
 */

public class PaintHouse {

	public int minCost(int[][] costs) {

		if (costs == null || costs.length == 0)
			return 0;

		for (int i = 1; i < costs.length; i++) {
			costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
			costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
			costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
		}

		return Math.min(Math.min(costs[costs.length - 1][0], costs[costs.length - 1][1]), costs[costs.length - 1][2]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int M[][] = new int[][] { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } };
		PaintHouse obj = new PaintHouse();
		System.out.println("Min cost: " + obj.minCost(M));
	}
}
