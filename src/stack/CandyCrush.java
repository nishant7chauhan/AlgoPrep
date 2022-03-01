package stack;

import java.util.Stack;

class Pair {
	char c;
	int freq;

	Pair(char c, int freq) {
		this.c = c;
		this.freq = freq;
	}
}

public class CandyCrush {

	public static String removeDuplicates(String s, int k) {
		
		if (k == 1) {
            String ans = "";
            return ans;
        }
		Stack<Pair> stack = new Stack<Pair>();
		
		
		for (int i = 0; i < s.length(); i++) {

            if (!stack.isEmpty() && stack.peek().c == s.charAt(i)) {
                Pair p = stack.pop();       
                p.freq += 1;
                if (p.freq == k) {
                    continue;
                }
                else {
                    stack.push(p);
                }
            }
            else {
            	stack.push(new Pair(s.charAt(i), 1));
            }
        }

        String ans = "";
        while (stack.size() > 0) {
            char c = stack.peek().c;
            int cnt = stack.peek().freq;
            while (cnt-- > 0)
                ans = c + ans;
            stack.pop();
        }
        return ans;
    }
		
	public static String removeDuplicates(String s) {

		char[] stack = new char[s.length()];

		int index = 0;

		for (int i = 0; i < s.length(); i++) {

			if (index > 0 && stack[index - 1] == s.charAt(i)) {
				index--;
			} else {
				stack[index] = s.charAt(i);
				index++;
			}
		}

		return new String(stack, 0, index);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "geeksforgeeks";

		System.out.print("with out k : " + removeDuplicates(s));
		System.out.print("\nwith k : " + removeDuplicates(s,2));

	}

}
