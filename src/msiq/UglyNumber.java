package msiq;

public class UglyNumber {

	public boolean isUgly(int n) {
		if (n == 1 || n == 2 || n == 3 || n == 5)
			return true;
		if (n == 0)
			return false;
		while (n % 2 == 0) {
			n = n / 2;
		}
		while (n % 3 == 0) {
			n = n / 3;
		}
		while (n % 5 == 0) {
			n = n / 5;
		}
		return n == 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UglyNumber obj = new UglyNumber();
		
		System.out.print(obj.isUgly(14));
	}

}
