package recursion_1;

import java.util.Scanner;

public class Palindrome {
	
	public static boolean palindrome(String str) {
		int n = str.length();
		if(n == 0 || n == 1) {
			return true;
		}
		if(str.charAt(0) != str.charAt(n - 1)) {
			return false;
		}
		return palindrome(str.substring(1, n - 1));
	}

	public static void main(String[] args) {
		String str;
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		boolean ans = palindrome(str);
		System.out.print(ans);
		sc.close();
	}

}
