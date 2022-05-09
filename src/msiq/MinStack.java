package msiq;

import java.util.Stack;

public class MinStack {
	class Pair {
		int val;
		int min;

		Pair(int val, int min) {
			this.val = val;
			this.min = min;
		}
	}

	int min;
	Stack<Pair> stk;

	public MinStack() {
		stk = new Stack<>();
		min = Integer.MAX_VALUE;
	}

	public void push(int val) {
		if (stk.isEmpty() || val < min) {
			min = val;
			stk.push(new Pair(val, val));
		} else {
			stk.push(new Pair(val, min));
		}
	}

	public void pop() {
		stk.pop();
		if (!stk.isEmpty())
			min = stk.peek().min;
	}

	public int top() {
		return stk.peek().val;
	}

	public int getMin() {
		return stk.peek().min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.print(minStack.getMin() + "\n"); // return -3
		minStack.pop();
		System.out.print(minStack.top() + "\n");    // return 0
		System.out.print(minStack.getMin());
		
	}

}
