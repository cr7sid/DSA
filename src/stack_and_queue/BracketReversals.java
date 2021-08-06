package stack_and_queue;

import java.util.Scanner;

public class BracketReversals {
	
	//TODO: Read and learn.

	public static int minReversals(String str) throws StackEmptyException {
		int len = str.length();
		if (len % 2 != 0)
			return -1;

		StackUsingLL<Character> s = new StackUsingLL<>();

		for (int i = 0; i < len; i++) {
			char c = str.charAt(i);
			if (c == '}' && !s.isEmpty()) {
				if (s.top() == '{')
					s.pop();
				else
					s.push(c);
			} else
				s.push(c);
		}

		// Length of the reduced expression
		// red_len = (m+n)
		int red_len = s.size();

		// count opening brackets at the end of
		// stack
		int n = 0;
		while (!s.isEmpty() && s.top() == '{') {
			s.pop();
			n++;
		}

		// return ceil(m/2) + ceil(n/2) which is
		// actually equal to (m+n)/2 + n%2 when
		// m+n is even.
		return (red_len / 2 + n % 2);
	}

	public static void main(String[] args) throws StackEmptyException {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(minReversals(str));
		sc.close();
	}

}
