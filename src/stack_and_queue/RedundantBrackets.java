package stack_and_queue;

import java.util.Scanner;

public class RedundantBrackets {

	public static boolean redundantBrackets(String str) {
		if (str == null || str.isEmpty())
			return false;
		StackUsingLL<Character> stack = new StackUsingLL<>();
		for (int i = 0; i < str.length(); i++) {
			char top = ' ';
			if (str.charAt(i) == ')') {
				try {
					top = stack.top();
					stack.pop();
					boolean flag = true;

					while (top != '(') {
						if (top == '+' || top == '-' || top == '*' || top == '/') {
							flag = false;
						}
						top = stack.top();
						stack.pop();
					}
					if (flag == true) {
						return true;
					}
				} catch (StackEmptyException e) {
					e.printStackTrace();
				}
			} else {
				stack.push(str.charAt(i));
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(redundantBrackets(str));
		sc.close();
	}

}
