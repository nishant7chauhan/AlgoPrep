package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
 * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to
 * identify repeated sequences within the DNA. Write a function to find all the
 * 10-letter-long sequences (substrings) that occur more than once in a DNA
 * molecule. For example, given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", re-
 * turn: ["AAAAACCCCC", "CCCCCAAAAA"].
 * 
 * @author nishantchauhan
 *
 *
 *         O(n)
 *
 */

public class RepeatedDNA {

	public static List<String> findRepeatedDnaSequences(String s) {

		List<String> result = new ArrayList<>();
		Map<String, Integer> seen = new HashMap<>();

		int i = 0;

		while (i + 10 <= s.length()) {
			String substring = s.substring(i, i++ + 10); // i would increment after adding 10;
			seen.put(substring, seen.getOrDefault(substring, 0) + 1);

			if (seen.get(substring) == 2)
				result.add(substring);
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "AAAAAAAAAAA";

		System.out.print(findRepeatedDnaSequences(s));
	}

}
