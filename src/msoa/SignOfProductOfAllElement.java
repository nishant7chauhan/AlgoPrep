package msoa;

public class SignOfProductOfAllElement {

	int solution(int[] nums) {
		int nc = 0;
		int pc = 0;
		int zc = 0;

		for (int val : nums) {
			if (val < 0) {
				nc++;
			} else if (val == 0) {
				zc++;
				break;
			} else {
				pc++;
			}
		}

		if (zc > 0) {
			return 0;
		} else if (nc > 0 && nc % 2 != 0) {
			return -1;
		} else {
			return 1;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SignOfProductOfAllElement obj = new SignOfProductOfAllElement();
		int arr[] = { -2, 3, 5, -9 };
		System.out.print(obj.solution(arr));
	}

}
