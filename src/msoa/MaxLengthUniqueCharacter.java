package msoa;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLengthUniqueCharacter {


	private static int maxLengthUnique(String[] arr, int result, String current) {

		int i = 0, n = arr.length;

		// We use queue to store all the combinations possible!
		Queue<String> q = new LinkedList<>();
		q.add("");

		// Loop for all the strings in array.
		while (i < n) {
			int size = q.size();

			// Loop till all the elements in Queue are appended with "" and the string 'str'
			for (int loop = 0; loop < size; loop++) {
				String temp = q.poll(); // temp = ""
				String dontConsider = temp; // dontConsider = ""
				String consider = temp + arr[i]; // consider = "un" --> Aboe 3 steps Repeated till the last element.

				// Function call to calculate the unique characters
				if (uniqueCharacters(dontConsider) > result) {
					result = dontConsider.length();
				}
				// Function call to calculate the unique characters
				if (uniqueCharacters(consider) > result) {
					result = consider.length();
				}
				// Adding the new strings to our queue again.
				q.add(dontConsider);
				q.add(consider);
			}
			i++;
		}
		
		return result;

	}

	private static int  uniqueCharacters(String string) {
		char[] alpha = new char[26];

		for (char character : string.toCharArray())
			if (alpha[character - 'a']++ > 0)
				return -1;

		return string.length();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String [] arr = {"cha","r","act","ers"};
		
		System.out.print(maxLengthUnique(arr, 0, ""));
	}

}
