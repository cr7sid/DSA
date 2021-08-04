package stack_and_queue;

import java.util.Scanner;

public class BalancedParentheses {

	public static boolean isBalanced(String str) throws StackEmptyException {
		if (str == null || str.isEmpty())
			return true;
		StackUsingLL<Character> parentheses = new StackUsingLL<>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '(') {
				parentheses.push(str.charAt(i));
			}
			if (str.charAt(i) == '}') {
				if (parentheses.isEmpty() || !parentheses.pop().equals('{')) {
					return false;
				}
			}
			if (str.charAt(i) == ']') {
				if (parentheses.isEmpty() || !parentheses.pop().equals('[')) {
					return false;
				}
			}
			if (str.charAt(i) == ')') {
				if (parentheses.isEmpty() || !parentheses.pop().equals('(')) {
					return false;
				}
			}
		}
		if (parentheses.size() != 0)
			return false;
		return true;
	}

	public static void main(String[] args) throws StackEmptyException {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(isBalanced(str));
		sc.close();
	}

}
