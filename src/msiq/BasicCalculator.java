package msiq;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BasicCalculator {

	Map<Character, Integer> precedenceMap; // tell which operator has what precedence

	public int calculate(String s) {
		precedenceMap = new HashMap<>();
		precedenceMap.put('+', 0);
		precedenceMap.put('-', 0);
		precedenceMap.put('*', 1);
		precedenceMap.put('/', 1);

		s = s.replace(" ", ""); // replace all 'spaces' with 'empty char' (can be avoided is a string 's' cannot
								// contain spaces)

		// the following for loop could be avoided if we confirm from the interviewer
		// whether '+' or '-' could come at start of expression (or sub-expression) or
		// not. If they CANNOT come in start, then no need to do this step
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if ((c == '+' || c == '-') && (i == 0 || s.charAt(i - 1) == '(')) {
				sb.append(0);
			}
			sb.append(c);
		}

		s = sb.toString();

		Stack<Integer> operand = new Stack<>(); // to store operand (num formed by performing operations)
		Stack<Character> operator = new Stack<>(); // operators

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (Character.isDigit(ch)) {
				int val = ch - '0';
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) { // form the complete num
					val = val * 10 + s.charAt(i + 1) - '0';
					i++;
				}
				operand.push(val); // the number formed is pushed to the stack
			} else { // if '+', '-', '*', '/'
				// this 'while' will take care that '*' & '/' will be taken care first before
				// '+' or '-'
				while (!operator.isEmpty() && findPrecedence(operator.peek(), ch) >= 0) { // if the operator on the top
																							// is of HIGHER precedence
																							// than 'ch', then compute
																							// the value
					int secondOperand = operand.pop();
					int firstOperand = operand.pop();
					operand.push(operate(firstOperand, secondOperand, operator.pop()));
				}
				operator.push(ch); // push the operator to the stack
			}
		}

		// if stacks are not empty
		while (!operator.isEmpty()) {
			int secondOperand = operand.pop();
			int firstOperand = operand.pop();
			operand.push(operate(firstOperand, secondOperand, operator.pop()));
		}

		return operand.pop();
	}

	private int operate(int num1, int num2, char operator) {
		switch (operator) {
		case '+':
			return num1 + num2;
		case '-':
			return num1 - num2;
		case '*':
			return num1 * num2;
		case '/':
			return num1 / num2;
		default: // because outside witch we do not have return statement
			return num1 + num2;
		}
	}

	private int findPrecedence(char op1, char op2) {
		return precedenceMap.get(op1) - precedenceMap.get(op2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BasicCalculator obj = new BasicCalculator();
		
		String s = "3+2*2";
		
		System.out.print(obj.calculate(s));

	}

}
