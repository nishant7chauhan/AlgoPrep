package msoa;

import java.util.Arrays;

public class UniqueIntegerSumToZero {

	public static int[] sumZero(int N) {
		int arr[] = new int[N];
		if (N == 1) {
			arr[0] = 0;
			return arr;
		}

		int index = 0;
		for (int i = 1; i <= N / 2; i++) {
			arr[index++] = i;
			arr[index++] = -i;

		}
		if (N % 2 == 1) {
			arr[index++] = 0;

		}

		return arr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print(Arrays.toString(sumZero(5)));

	}

}
