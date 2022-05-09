package msoa;

public class MinSwapPalindrom {

	public static boolean isValid(String s) {
		int[] counter = new int[26];
		int oddCount = 0;

		for (int i = 0; i < s.length(); i++) {
			counter[s.charAt(i) - 'a']++;
		}
		for (int value : counter) {
			if (value % 2 != 0) {
				oddCount++;
			}
		}
		return oddCount <= 1;
	}

	static int minSwap(String inp) {
		if (!isValid(inp)) {
			return -1;
		}

		int n = inp.length();
		char s[] = inp.toCharArray();
		int count = 0;
		for (int i = 0; i < n / 2; i++) {
			int left = i;
			int right = n - left - 1;
			while (left < right) {
				if (s[left] == s[right]) {
					break;
				} else {
					right--;
				}
			}
			if (left == right) {
				// s[left] is the character in the middle of the palindrome
				char t = s[left];
				s[left] = s[left + 1];
				s[left + 1] = t;
				count++;
				i--;
			} else {
				for (int j = right; j < n - left - 1; j++) {
					char t = s[j];
					s[j] = s[j + 1];
					s[j + 1] = t;
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(minSwap("aabcb"));
	}

}
