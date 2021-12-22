package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O(4n), where n is a number of digits in the input number.
 * Each digit of a number has 3 or 4 alphabets, so it can be said that each
 * digit has 4 alphabets as options. If there are n digits then there are 4
 * options for the first digit and for each alphabet of the first digit there
 * are 4 options in the second digit, i.e for every recursion 4 more recursions
 * are called (if it does not match the base case). So the time complexity is
 * O(4n). Space Complexity:O(1). As no extra space is needed.
 * 
 * 
 * @author nishantchauhan
 *
 */

public class PhoneLetterCombination {

	public List<String> letterCombinations(String digits) {

		List<String> result = new ArrayList<String>();
		if (digits == null || digits.length() == 0) {
			return result;
		}

		String[] mappings = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		letterCombinationRecursive(result, digits, "", 0, mappings);

		return result;

	}

	private void letterCombinationRecursive(List<String> result, String digits, String current, int index,
			String[] mappings) {
		// TODO Auto-generated method stub

		if (index == digits.length()) {
			result.add(current);
			return;
		}

		String letters = mappings[digits.charAt(index)-'0'];

		for (int i = 0; i < letters.length(); i++) {
			letterCombinationRecursive(result, digits, current + letters.charAt(i), index + 1, mappings);
		}

	}

	public static void main(String args[]) {

		PhoneLetterCombination obj = new PhoneLetterCombination();
		List<String> ans = obj.letterCombinations("23");

		for (String element : ans)
			System.out.print(element + " ");

	}
}
