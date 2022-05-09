package string;

/**
 * 
 * @author nishantchauhan
 * O(n)
 */

public class ValidPalindromAlphaNumeric {

	public static boolean isValidPalindrome(String s) {
		if (s == null || s.length() == 0)
			return false;
		s = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase(); //^ is negation (matches all character except a-zA-Z0-9 and changed to "")
		System.out.println(s);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String str = "A man, a plan, a canal: Panama";
		System.out.println(isValidPalindrome(str));
	}
}
