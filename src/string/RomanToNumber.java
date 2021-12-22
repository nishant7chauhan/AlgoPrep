package string;

/**
 * Convert a roman number into an integer number. He provided me with a set of
 * rules.
 * 
 * @author nishantchauhan
 * 
 * O(n)
 *
 */

public class RomanToNumber {

	// This function returns
	// value of a Roman symbol
	int value(char r) {
		if (r == 'I')
			return 1;
		if (r == 'V')
			return 5;
		if (r == 'X')
			return 10;
		if (r == 'L')
			return 50;
		if (r == 'C')
			return 100;
		if (r == 'D')
			return 500;
		if (r == 'M')
			return 1000;
		return -1;
	}

	private int romanToDecimal(String str) {
		// TODO Auto-generated method stub
		int result = 0;
		for (int i = 0; i < str.length(); i++) {
			if (i > 0 && value(str.charAt(i)) > value(str.charAt(i - 1))) {
				result += value(str.charAt(i)) - 2 * value(str.charAt(i - 1));
			} else {
				result += value(str.charAt(i));
			}

		}

		return result;
	}

	public static void main(String args[]) {
		RomanToNumber ob = new RomanToNumber();

		// Considering inputs given are valid
		String str = "MCMIV";
		System.out.println("Integer form of Roman Numeral" + " is " + ob.romanToDecimal(str));
	}

}
