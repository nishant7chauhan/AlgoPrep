package string;

/**
 * Print all the non-repeating words out of two given sentences.
 * 
 * @author nishant.chauhan
 *
 *
 */

public class NonRepeatingWord {

	static void removeRepeating(String s1, String s2) {

		// Concatenate the two Strings
		// into one
		String s3 = s1 + " " + s2 + " ";

		// Iterating over the whole
		// concatenated String
		for (String word : s3.split(" ")) {
			
			
			if (!s1.contains(word) || !s2.contains(word))
				System.out.print(word+ " ");

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1 = "I have go a pen";
		String s2 = "I want to go park";
		removeRepeating(s1, s2);

	}

}
