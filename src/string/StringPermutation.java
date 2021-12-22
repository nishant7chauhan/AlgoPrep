package string;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Print all anagrams of a given string (Permutation)(Lexographical order) [3]
 * @author nishantchauhan 
 * (nlogn*n!) check again as treemap insertion takes nlogn times
 */

public class StringPermutation {

	public List<String> permute(char input[]) {
		Map<Character, Integer> countMap = new TreeMap<>();
		for (char ch : input) {
			countMap.compute(ch, (key, val) -> {
				if (val == null) {
					return 1;
				} else {
					return val + 1;
				}
			});
		}
		char str[] = new char[countMap.size()];
		int count[] = new int[countMap.size()];
		int index = 0;
		for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
			str[index] = entry.getKey();
			count[index] = entry.getValue();
			index++;
		}
		List<String> resultList = new ArrayList<>();
		char result[] = new char[input.length];
		permuteUtil(str, count, result, 0, resultList);
		return resultList;
	}

	public void permuteUtil(char str[], int count[], char result[], int level, List<String> resultList) {
		if (level == result.length) {
			resultList.add(new String(result));
			return;
		}

		for (int i = 0; i < str.length; i++) {
			if (count[i] == 0) {
				continue;
			}
			result[level] = str[i];
			count[i]--;
			permuteUtil(str, count, result, level + 1, resultList);
			count[i]++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringPermutation sp = new StringPermutation();
		sp.permute("AABC".toCharArray()).forEach(s -> System.out.print(s + ", "));

	}

}

/*
 * private void permute(String str, int l, int r) { if (l == r)
 * System.out.println(str); else { for (int i = l; i <= r; i++) { str =
 * swap(str,l,i); permute(str, l+1, r); str = swap(str,l,i); } } }
 */
