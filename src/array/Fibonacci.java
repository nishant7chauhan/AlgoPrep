package array;

/*******Fibonacci LogN*******/

//check recursive O(2^n)O(n),then dynamic O(n)O(n),then dynamic with space optimization O(n)O(1), then O(log n)

// can be used Nth stair if can jump only 2 ways (1,2)

public class Fibonacci {

	/* function that returns nth Fibonacci number */
	static int fib(int n) {
		int F[][] = new int[][] { { 1, 1 }, { 1, 0 } };
		if (n == 0)
			return 0;
		power(F, n - 1);

		return F[0][0];
	}

	static void multiply(int F[][], int M[][]) {
		int x = F[0][0] * M[0][0] + F[0][1] * M[1][0];
		int y = F[0][0] * M[0][1] + F[0][1] * M[1][1];
		int z = F[1][0] * M[0][0] + F[1][1] * M[1][0];
		int w = F[1][0] * M[0][1] + F[1][1] * M[1][1];

		F[0][0] = x;
		F[0][1] = y;
		F[1][0] = z;
		F[1][1] = w;
	}

	/* Optimized version of power() in method 4 */
	static void power(int F[][], int n) {
		if (n == 0 || n == 1)
			return;
		int M[][] = new int[][] { { 1, 1 }, { 1, 0 } };

		power(F, n / 2); //temp
		multiply(F, F); //even(see power(m,n) algo  //temp *temp

		if (n % 2 != 0)  //odd(see power(m,n) algo //temp*temp*x
			multiply(F, M);
	}

	/* Driver program to test above function */
	public static void main(String args[]) {
		int n = 6;
		System.out.println(fib(n));
	}


}
