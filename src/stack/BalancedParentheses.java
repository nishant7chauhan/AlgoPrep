package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedParentheses {

	// function to check if paranthesis are balanced
	static boolean areParanthesisBalanced(String expr) {
		// Using ArrayDeque is faster than using Stack class
		Deque<Character> stack = new ArrayDeque<Character>();

		// Traversing the Expression
		for (int i = 0; i < expr.length(); i++) {
			char check = expr.charAt(i);

			if (check == '(' || check == '[' || check == '{') {
				// Push the element in the stack
				stack.push(check);
				continue;
			}

			// IF current current character is not opening
			// bracket, then it must be closing. So stack
			// cannot be empty at this point.
			if (stack.isEmpty())
				return false;

			char x = stack.pop();

			switch (check) {
			case ')':

				if (x == '{' || x == '[')
					return false;
				break;

			case '}':

				if (x == '(' || x == '[')
					return false;
				break;

			case ']':

				if (x == '(' || x == '{')
					return false;
				break;
			}
		}

		// Check Empty Stack
		return (stack.isEmpty());
	}

	/* driver program to test above functions */
	public static void main(String[] args) {
		String expr = "([(}])";
		if (areParanthesisBalanced(expr))
			System.out.println("Balanced ");
		else
			System.out.println("Not Balanced ");
	}

}
