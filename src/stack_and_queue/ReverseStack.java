package stack_and_queue;

import java.util.Scanner;

public class ReverseStack {

	public static StackUsingLL<Integer> reverseStack(StackUsingLL<Integer> stack) {
		if (stack.isEmpty() || stack.size() == 1)
			return stack;
		StackUsingLL<Integer> newStack = new StackUsingLL<Integer>();
		while (!stack.isEmpty()) {
			try {
				newStack.push(stack.pop());
			} catch (StackEmptyException e) {
				e.printStackTrace();
			}
		}
		return newStack;
	}

	public static void main(String[] args) {
		StackUsingLL<Integer> stack = new StackUsingLL<>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			stack.push(sc.nextInt());
		}
		StackUsingLL<Integer> newStack = reverseStack(stack);
		while (!newStack.isEmpty()) {
			try {
				System.out.print(newStack.pop() + " ");
			} catch (StackEmptyException e) {
				e.printStackTrace();
			}
		}
		sc.close();
	}
}
