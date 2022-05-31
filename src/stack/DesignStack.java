package stack;

import java.util.Stack;

public class DesignStack {

	Stack<Integer> s = new Stack<Integer>();
	int minEle;

	// Prints minimum element of MyStack
	void getMin() {
		if (s.empty())
			System.out.print("Stack is empty\n");

		// variable minEle stores the minimum element
		// in the stack.
		else
			System.out.print("Minimum Element in the stack is: " + minEle + "\n");
	}

	// Prints top element of MyStack
	void peek() 
	{ 
		if (s.empty()) 
		{ 
			System.out.print("Stack is empty "); 
			return; 
		} 

		int t = s.peek(); // Top element. 

		System.out.print( "Top Most Element is: "); 

		// If t < minEle means minEle stores 
		// value of t. 
		int k = t < minEle ? minEle:t; 
		
		System.out.print(k);
	}

	// Remove the top element from MyStack
	void pop() {
		if (s.empty()) {
			System.out.print("Stack is empty\n");
			return;
		}

		System.out.print("Top Most Element Removed: ");
		int t = s.pop();
		// Minimum will change as the minimum element
		// of the stack is being removed.
		if (t < minEle) {
			System.out.print(minEle + "\n");
			minEle = 2 * minEle - t;
		}

		else
			System.out.print(t + "\n");
	}

	// Removes top element from MyStack
	void push(int x) {
		// Insert new number into the stack
		if (s.empty()) {
			minEle = x;
			s.push(x);
			System.out.print("Number Inserted: " + x + "\n");
			return;
		}

		// If new number is less than minEle
		if (x < minEle) {
			s.push(2 * x - minEle);
			minEle = x;
		}

		else
			s.push(x);

		System.out.print("Number Inserted: " + x + "\n");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DesignStack s = new DesignStack();
		s.push(3);
		s.push(5);
		s.getMin();
		s.push(2);
		s.push(1);
		s.getMin();
		s.pop();
		s.getMin();
		s.pop();
		s.peek();
	}

}
