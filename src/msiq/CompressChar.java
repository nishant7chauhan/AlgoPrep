package msiq;

public class CompressChar {

	public int compress(char[] chars) {
		int i = 0, count = 1;
		for (int j = 1; j <= chars.length; j++) {
			if (j < chars.length && chars[j] == chars[j - 1])
				count++;
			else {
				chars[i++] = chars[j - 1];
				if (count > 1)
					for (char c : ("" + count).toCharArray())
						chars[i++] = c;
				count = 1;
			}
		}
		return i;

	}
}